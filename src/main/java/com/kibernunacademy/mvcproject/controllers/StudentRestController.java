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


  // Eliminar el estudiante



}
