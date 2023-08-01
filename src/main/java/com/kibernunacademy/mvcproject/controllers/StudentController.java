package com.kibernunacademy.mvcproject.controllers;

import com.kibernunacademy.mvcproject.entitys.Student;
import com.kibernunacademy.mvcproject.services.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

@Controller // @RestController (cuando queramos retornar un json)
public class StudentController {

  private final IStudentService service;

  @Autowired
  public StudentController(IStudentService service) {
    this.service = service;
  }

  // http://localhost:8080/students
  // http://localhost:8080
  @GetMapping({"/students", "/"})
  public String getAllStudents(Model model) {
    model.addAttribute("students", service.listAllStudents());
    return "index";
  }
  // Para llamar al formulario para crear un estudiante
  // http://localhost:8080/student/new
  @GetMapping("/student/new")
  public String createStudentForm(Model model) {
    Student student = new Student();
    model.addAttribute("student", student);
    return "create-student"; // create-student.html
  }

  // Para guardar el estudiante
  // http://localhost:8080/student
  @PostMapping("/student")
  public String saveStudent(@ModelAttribute("student") Student student) {
    service.saveStudent(student);
    return "redirect:/";
  }

  // Un controlador que llame al formulario para editar un estudiante
  // http://localhost:8080/student/edit/1
  @GetMapping("/student/edit/{id}")
  public String showFormEditStudent(@PathVariable Long id, @ModelAttribute("student") Student student, Model model) {
    Optional<Student> optionalStudent = service.getStudentById(id);

    if(!optionalStudent.isPresent()) {
      throw new StudentNotFoundException("No se encontro el estudiante con ese id: " +  id);
    }
    Student studentExists = optionalStudent.get();
    model.addAttribute("student", studentExists);
    return "edit-student";

    /*if(optionalStudent.isPresent()) {
      Student studentExists = optionalStudent.get();
      model.addAttribute("student", student);
      return "edit-student";
    } else {
      // generar la excepción
      throw  new StudentNotFoundException("No se encontro el estudiante con ese id: " +  id);
    } */

  }

  // Vamos actualizar al Estudiante

  @PostMapping("/student/{id}")
  public String updateStudent(@PathVariable Long id, @ModelAttribute("student") Student student, Model model) {
    // comprobar que existe el usuario que queremos actualizar
    Optional<Student> optionalStudent = service.getStudentById(id);

    if(!optionalStudent.isPresent()) {
      throw new StudentNotFoundException("No se encontro un estudiante con ese id: " +  id);
    }
    Student studentExists = optionalStudent.get(); // obtengo al estudiante por su id (de la base de datos para actualizarlo)

    // Actualizamos al estudiante
    studentExists.setId(id);
    studentExists.setName(student.getName());
    studentExists.setLastname(student.getLastname());
    studentExists.setEmail(student.getEmail());

    service.updateStudent(studentExists);
    return "redirect:/";

}

// Para eliminar un Estudiante
  @GetMapping("/student-delete/{id}")
  public String deleteStudent(@PathVariable Long id) {
    service.deleteStudentById(id);
    return "redirect:/";
  }
}

class StudentNotFoundException extends RuntimeException {
  public  StudentNotFoundException (String message) {
    super(message);
  }
}
