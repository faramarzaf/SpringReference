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

    // JPQL
    @Query("select s.firstName from Student s where s.emailId=?1")
    String getStudentFirstNameByEmailAddress(String emailId);

    //Native
    @Query(value = "SELECT * FROM tbl_students s where s.email_address = ?1",
            nativeQuery = true)
    Student getStudentByEmailAddressNative(String emailId);


    //Native Named Param
    @Query(value = "SELECT * FROM tbl_students s where s.email_address= :emailId",
            nativeQuery = true)
    Student getStudentByEmailAddressNativeNamedParam(@Param("emailId") String emailId);


    // Insert data //
    @Modifying
    @Transactional // org.springframework. You can set this on service layer but for now it's here.
    @Query(value = "update tbl_students set first_name = ?1 where email_address = ?2",
            nativeQuery = true)
    int updateStudentNameByEmailId(String firstName, String emailId);


}
