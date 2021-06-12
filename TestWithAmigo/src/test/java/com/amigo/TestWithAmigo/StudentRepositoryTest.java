package com.amigo.TestWithAmigo;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class StudentRepositoryTest {

    @Autowired
    private StudentRepository underTest;


    @AfterEach
    void teardown() {
        underTest.deleteAll();
    }


    @Test
    void selectExistsEmail() {

        Student student = new Student(
                "Julia",
                "J@gmail.com",
                Gender.FEMALE
        );
        underTest.save(student);

        Boolean exists = underTest.selectExistsEmail("J@gmail.com");
        assertThat(exists).isTrue();

    }


}