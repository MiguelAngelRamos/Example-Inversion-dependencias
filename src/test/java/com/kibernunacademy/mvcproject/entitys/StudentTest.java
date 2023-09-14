package com.kibernunacademy.mvcproject.entitys;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class StudentTest {
  private Student student; // Objeto de la clase que vamos a probar

  @BeforeEach // Este método se ejecuta antes de cada prueba
  void setup() {
    student = new Student("Richard", "Stallman", "richard.stallman@correo.com");
  }

  @Test // Indica que este método es una prueba
  void shouldSetName() {
    student.setName("Angel"); // Cambios el nombre
    assertEquals("Angel", student.getName()); // Comprobamos que el cambio se realizó correctamente
  }

  @Test
  void shouldSetLastName() {
    student.setLastname("Rodriguez"); // Cambiamos el apellido
    assertEquals("Rodriguez", student.getLastname());// Comprobamos que el cambio se realizó correctamente
  }

  @Test
  void shouldSetEmail() {
    student.setEmail("miguel.ramos@gmail.com");
    assertEquals("miguel.ramos@gmail.com", student.getEmail());
  }

  @Test
  void shouldInitializeCorrectlyUsingConstructor() {
    Student newStudent = new Student("Richard", "Stallman", "richard.stallman@correo.com");
    assertEquals("Richard", newStudent.getName());
    assertEquals("Stallman", newStudent.getLastname());
    assertEquals("richard.stallman@correo.com", newStudent.getEmail());
    // System.out.println(newStudent); // student@34149187131ff4 -> toString()
  }

  @Test
  void shouldReturnCorrectToStringRepresentation() {
    String expect ="Student{id=0, name='Richard', lastname='Stallman', email='richard.stallman@correo.com'}";
    assertEquals(expect, student.toString());
  }
}
