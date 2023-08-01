package com.kibernunacademy.mvcproject.controllers;

import com.kibernunacademy.mvcproject.entitys.Student;
import com.kibernunacademy.mvcproject.services.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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

}