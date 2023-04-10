package com.springdatajpa.tutorial.repository;

import com.springdatajpa.tutorial.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    List<Student> findByFirstName(String firstName);
    List<Student> findByFirstNameContaining(String name);
    List<Student> findByLastNameNotNull();
    List<Student> findByGuardianName(String guardianName);

    Student findByFirstNameAndLastName(String firstName, String lastName);

    //JPQL
    @Query("select s from Student s where s.emailId = ?1")
    Student getStudentByEmailAddress(String emailId);

    //JPQL

    @Query("select s.firstName from Student s where s.emailId = ?1")
    String getStudentFistNameByEmailAddress(String emailId);

    // Native Query
    @Query(
            value = "SELECT * FROM tbl_student s where s.email_address = ?1",
            nativeQuery = true
    )
    Student getStudentByEmailAddressNative(String emailId);

    // Native Query Named Param
    @Query(
            value = "SELECT * FROM tbl_student s where s.email_address = :emailId",
            nativeQuery = true
    )
    Student getStudentByEmailAddressNativeNamedParam(@Param("emailId") String emailId);

    // This method is unable to execute the query, It's showing the following error:
    // java.lang.IllegalStateException: Failed to load ApplicationContext
    // Caused by: org.springframework.beans.factory.BeanCreationException: Error creating bean with name 'studentRepository'
    //      defined in com.springdatajpa.tutorial.repository.StudentRepository
    // Caused by: org.springframework.data.repository.query.QueryCreationException: Could not create query for
    //      public abstract int com.springdatajpa.tutorial.repository.StudentRepository.updateStudentFirstNameByEmailId(java.lang.String,java.lang.String);
    // Caused by: java.lang.NullPointerException

//    @Modifying
//    @Transactional
//    @Query(
//            value = "update tbl_student set first_name = ?1 where guardian_email like %?2",
//            nativeQuery = true
//    )
//    int updateStudentNameByEmailId(String firstName, String emailId);

    List<Student> findByEmailId(String str);

}
