package com.kibernunacademy.mvcproject.entitys;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="students")
public class Student implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id; // valor por defecto de una propiedad 0
  @Column(name="name", nullable = false, length = 50)
  private String name; // valor por defecto de una propiedad String null
  @Column(name="lastname", nullable = false, length = 50)
  private String lastname;
  @Column(name="email", nullable = false, length = 50, unique = true)
  private String email;

  public Student() {}
  public Student(String name, String lastname, String email) {
    this.name = name;
    this.lastname = lastname;
    this.email = email;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getLastname() {
    return lastname;
  }

  public void setLastname(String lastname) {
    this.lastname = lastname;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  @Override
  public String toString() {
    return "Student{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", lastname='" + lastname + '\'' +
            ", email='" + email + '\'' +
            '}';
  }
}
