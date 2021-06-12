package com.amigo.TestWithAmigo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class StudentServiceTest {

    @Mock
    private StudentRepository studentRepository;

    private StudentService underTest;


    @BeforeEach
    void setUp() {

        underTest = new StudentService(studentRepository);
    }


    @Test
    void getAllStudents() {
        underTest.getAllStudents();
        verify(studentRepository).findAll();
    }

    @Test
    void addStudent() {
        Student student = new Student(
                "Julia",
                "J@gmail.com",
                Gender.FEMALE
        );
        underTest.addStudent(student);

        ArgumentCaptor<Student> studentArgumentCaptor =
                ArgumentCaptor.forClass(Student.class);
        verify(studentRepository).save(studentArgumentCaptor.capture());
        //studentArgumentCaptor.capture() we want to capture the actual student that we passed in (studentRepository).save

        Student capturedStudent = studentArgumentCaptor.getValue();
        assertThat(capturedStudent).isEqualTo(student);
    }

    @Test
    void throwExceptionWhenEmailTaken() {
        Student student = new Student(
                "Julia",
                "J@gmail.com",
                Gender.FEMALE
        );

        given(studentRepository.selectExistsEmail(student.getEmail())) // we simulate that email is exists
                .willReturn(true);

        assertThatThrownBy(() -> underTest.addStudent(student))
                .isInstanceOf(BadRequestException.class)
                .hasMessageContaining("Email " + student.getEmail() + " taken");

        verify(studentRepository, never()).save(any()); // we expect if email has taken, never saves any student
    }

    @Test
    void canDeleteStudent() {
        // given
        long id = 10;
        given(studentRepository.existsById(id)).willReturn(true);

        // when
        underTest.deleteStudent(id);

        // then
        verify(studentRepository).deleteById(id);
    }

    @Test
    void willThrowWhenDeleteStudentNotFound() {
        // given
        long id = 10;
        given(studentRepository.existsById(id)).willReturn(false);
        // when
        // then
        assertThatThrownBy(() -> underTest.deleteStudent(id))
                .isInstanceOf(StudentNotFoundException.class)
                .hasMessageContaining("Student with id " + id + " does not exists");

        verify(studentRepository, never()).deleteById(any());
    }
}