package com.kibernunacademy.mvcproject.services;

import com.kibernunacademy.mvcproject.entitys.Student;

import java.util.List;
import java.util.Optional;

public interface IStudentService {

  public List<Student> listAllStudents();
  public Student saveStudent(Student student);
  public Optional<Student> getStudentById(Long id);
  public Student updateStudent(Student student);
  public void deleteStudentById(Long id);
}
