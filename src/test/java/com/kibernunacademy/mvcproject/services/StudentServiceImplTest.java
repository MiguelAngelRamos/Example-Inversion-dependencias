package com.kibernunacademy.mvcproject.services;

import com.kibernunacademy.mvcproject.entitys.Student;
import com.kibernunacademy.mvcproject.repositories.IStudentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.Optional;

import static org.mockito.Mockito.*;
public class StudentServiceImplTest {

  private StudentServiceImpl studentService;

  @Mock
  private IStudentRepository repository;
  @BeforeEach // Este método se ejecuta antes de cada @Test
  public void setup() {
    MockitoAnnotations.openMocks(this); // en este caso inicializamos el repository
    studentService = new StudentServiceImpl(repository);
  }

  @Test
  public void shouldSaveStudent() {
    // 1. Fase (act) Preparación - Crear un nuevo estudiante
    Student student = new Student("James", "Gosling", "jglosing@example.com");
    // 2. Fase (act) Acción - Simular el comportamiento de guardar el Student
    when(repository.save(any(Student.class))).thenReturn(student);
    // llamar al método del servicio
    studentService.saveStudent(student);
    // 3. fase Assert (Afirmar o Verificar)
    verify(repository).save(student); // Verifica si save fue llamado
  }

  @Test
  public void shouldFindStudentById() {
    // Preparación
    Student student = new Student("James", "Gosling", "jglosing@example.com");
    student.setId(1L); // LONG  1L = 1
    // Configurar el comportamiento esperado del mock del repositorio
    when(repository.findById(any(Long.class))).thenReturn(Optional.of(student));
    // Acción
    // Llamar al método del servicio que deseamos probar
    studentService.getStudentById(1L);
    // Afirmamos (Assert)
    // Verificar que el método del repositorio fue llamado con el valor correcto
    verify(repository).findById(1L);
  }

  @Test
  public void shouldListAllStudents() {

    Student student1 = new Student("James", "Gosling", "jglosing@example.com");
    Student student2 = new Student("Richard", "Stallman", "richard@example.com");

    when(repository.findAll()).thenReturn(Arrays.asList(student1, student2));

    studentService.listAllStudents();

    verify(repository).findAll();

  }
}
