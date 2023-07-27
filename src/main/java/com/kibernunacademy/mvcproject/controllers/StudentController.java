package com.kibernunacademy.mvcproject.controllers;

import com.kibernunacademy.mvcproject.services.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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

}
