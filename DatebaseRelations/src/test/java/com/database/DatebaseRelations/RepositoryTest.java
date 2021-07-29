package com.database.DatebaseRelations;

import com.database.DatebaseRelations.daily_code_buffer.StudentRepository;
import com.database.DatebaseRelations.daily_code_buffer.entity.Guardian;
import com.database.DatebaseRelations.daily_code_buffer.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class RepositoryTest {

    @Autowired
    private StudentRepository repository;

    @Test
    public void save() {
        Guardian guardian = new Guardian("G1", "G1@gmail.com", "0911");
        Student student = new Student(1L, "Jimmy", "McMock",
                "JimmyMC@gmail.com", guardian);

        repository.save(student);
    }

    @Test
    public void getAllStudents() {
        List<Student> studentList = repository.findAll();
        System.out.println(studentList);
    }

    @Test
    public void getStudentByFirstName() {
        List<Student> studentList = repository.findByFirstName("Jimmy");
        System.out.println(studentList);
    }

    @Test
    public void getStudentByFirstNameContaining() {
        List<Student> studentList = repository.findByFirstNameContaining("Ji");
        System.out.println(studentList);
    }


    @Test
    public void printStudentBasedOnGuardian() {
        List<Student> studentList = repository.findByGuardianName("G1");
        System.out.println(studentList);
    }




}
