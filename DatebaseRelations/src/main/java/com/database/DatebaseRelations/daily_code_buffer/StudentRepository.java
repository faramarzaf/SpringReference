package com.database.DatebaseRelations.daily_code_buffer;

import com.database.DatebaseRelations.daily_code_buffer.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {


    List<Student> findByFirstName(String firstName);

    List<Student> findByFirstNameContaining(String name);

    List<Student> findByLastNameNotNull();

    List<Student> findByGuardianName(String name);

    // JPQL
    @Query("select s from Student s where s.emailId=?1")
    Student getStudentByEmailAddress(String emailId);

}
