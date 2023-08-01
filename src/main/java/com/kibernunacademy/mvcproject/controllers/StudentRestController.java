package com.kibernunacademy.mvcproject.controllers;

import com.kibernunacademy.mvcproject.entitys.Student;
import com.kibernunacademy.mvcproject.services.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class StudentRestController {

  @Autowired
  private IStudentService studentService;

  // localhost:8080/api/students
  @GetMapping("/students")
  @ResponseStatus(HttpStatus.OK)
  public List<Student> getStudentAll() {
    return studentService.listAllStudents();
  }

  // localhost:8080/api/student/1
  @GetMapping("/student/{id}")
  public Optional<Student> getStudentById(@PathVariable Long id) {

    Optional<Student> optionalStudent = studentService.getStudentById(id);
    if(!optionalStudent.isPresent()) throw new StudentNotFoundException("No existe un Student con ese id: "+ id);
    return optionalStudent;
  }

  // crear un estudiante
  // localhost:8080/api/student
  @PostMapping("/student")
  public Student createStudent(@RequestBody Student student) {
    return studentService.saveStudent(student);
  }

  // Actualizar el estudiante
  @PutMapping("/student/{id}")
  public Optional<Student> updatedStudent(@RequestBody Student student, @PathVariable Long id) {
    // Encontrar dentro de la base de datos al estudiante que necesitamos actualizar
    Optional<Student> studentBD = studentService.getStudentById(id); // obtenemos al estudiante de la base datos

    if(!studentBD.isPresent()) throw new StudentNotFoundException("No existe un Student con ese id: "+ id);

    // comenzamos a actualizar al estudiante
    studentBD.get().setName(student.getName());
    studentBD.get().setLastname(student.getLastname());
    studentBD.get().setEmail(student.getEmail());
    // studentBD
    // llamamos al servicio para guardar los dato actualizados del estudiante
    studentService.saveStudent(studentBD.get());
    return studentBD;
  }

  // Eliminar el estudiante

  @DeleteMapping("/student/{id}")
  public void deleteStudent(@PathVariable Long id) {
    studentService.deleteStudentById(id);
  }

}
