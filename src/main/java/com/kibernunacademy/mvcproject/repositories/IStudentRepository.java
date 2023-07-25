package com.kibernunacademy.mvcproject.repositories;


import com.kibernunacademy.mvcproject.entitys.Student;
import org.springframework.data.repository.CrudRepository;

public interface IStudentRepository extends CrudRepository<Student, Long> {

}
