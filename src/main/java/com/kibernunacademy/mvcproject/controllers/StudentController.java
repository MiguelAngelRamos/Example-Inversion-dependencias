package com.kibernunacademy.mvcproject.controllers;

import com.kibernunacademy.mvcproject.entitys.Student;
import com.kibernunacademy.mvcproject.services.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

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
    return "redirect:/index";
  }

}
