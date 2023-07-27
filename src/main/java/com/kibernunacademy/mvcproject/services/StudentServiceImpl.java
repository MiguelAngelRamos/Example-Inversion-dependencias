package com.kibernunacademy.mvcproject.services;

import com.kibernunacademy.mvcproject.entitys.Student;
import com.kibernunacademy.mvcproject.repositories.IStudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class StudentServiceImpl implements IStudentService{
  // Inyectamos el Dao que hereda del CrudRepository

  private final IStudentRepository repository;

  @Autowired
  public StudentServiceImpl(IStudentRepository repository) {
    this.repository = repository;
  }

  @Override
  public List<Student> listAllStudents() {
    return (List<Student>) repository.findAll(); // select * from students;
  }

  @Override
  public Student saveStudent(Student student) {
    return repository.save(student); // va aplicar Insert Sql.
  }

  @Override
  public Optional<Student> getStudentById(Long id) {
    return repository.findById(id);
  }

  @Override
  public Student updateStudent(Student student) {
    return repository.save(student);
  }

  @Override
  public void deleteStudentById(Long id) {
    repository.deleteById(id);
  }
}
