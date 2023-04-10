package com.springdatajpa.tutorial.repository;

import com.springdatajpa.tutorial.Entity.Guardian;
import com.springdatajpa.tutorial.Entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;


import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

@SpringBootTest
public class StudentRepositoryTest {
    @Autowired
    private StudentRepository studentRepository;
    @Test
    public void saveStudent() {
        Student student = Student.builder()
                .emailId("swatinashipudi@gmail.com")
                .firstName("Swathi")
                .lastName("Nashipudi")
                //.guardianName("Mom")
                //.guardiaMobile("9999999999")
                //.guardianEmail("Mom@gmail.com")
                .build();
        studentRepository.save(student);
    }
    @Test
    public void saveStudentWithGuardian() {

        Guardian guardian = Guardian.builder()
                .name("Mom Nashipudi")
                .email("mom@gmail.com")
                .mobile("9989999999")
                .build();

        Student student = Student.builder()
                .firstName("Swathi")
                .lastName("Nashipudi")
                .emailId("swati07@gmail.com")
                .guardian(guardian)
                .build();
        studentRepository.save(student);
    }
    @Test
    public void printStudentByFirstName() {
        List<Student> students = studentRepository.findByFirstName("Ashutosh");
        System.out.println(students);
    }

    @Test
    public void printStudentByFirstNameContaining() {
        List<Student> students = studentRepository.findByFirstNameContaining("s");
        System.out.println("Students = " + students);
    }
    @Test
    public void printAllStudent() {
        List<Student> studentList = studentRepository.findAll();
        System.out.println(studentList);
    }

    @Test
    public void printStudentBasedOnGuardianName() {
        List<Student> students = studentRepository.findByGuardianName("Mom");
        System.out.println("Students = " + students);
    }
    @Test
    public void printStudentByEmailAddress() {
        Student student = studentRepository.getStudentByEmailAddress("srbhkmr27@gmail.com");
        System.out.println("Student = " + student);
    }

    @Test
    public void printStudentFirstNameByEmailAddress() {
        String name = studentRepository.getStudentFistNameByEmailAddress("srbhkm27@gmail.com");
        System.out.println("First Name = " + name);
    }

    @Test
    public void printStudentByEmailAddressNative() {
        Student student = studentRepository.getStudentByEmailAddressNative("srbhkm27@gmail.com");
        System.out.println("Student = " + student);
    }

    @Test
    public void printStudentByEmailAddressNativeNamedParam() {
        Student student = studentRepository.getStudentByEmailAddressNativeNamedParam("srbhkm27@gmail.com");
        System.out.println("Student = " + student);
    }

    // this method is unable to execute the query, It's showing the following error:
    // java.lang.IllegalStateException: Failed to load ApplicationContext
    // Caused by: org.springframework.beans.factory.BeanCreationException: Error creating bean with name 'studentRepository'
    //      defined in com.springdatajpa.tutorial.repository.StudentRepository
    // Caused by: org.springframework.data.repository.query.QueryCreationException: Could not create query for
    //      public abstract int com.springdatajpa.tutorial.repository.StudentRepository.updateStudentFirstNameByEmailId(java.lang.String,java.lang.String);
    // Caused by: java.lang.NullPointerException
//    @Test
//    public void updateStudentNameByEmailIdTest() {
//        studentRepository.updateStudentNameByEmailId("Er. Saurabh", "ramjiyadav@gmail.com");
//    }

    @Test
    public void findByEmailIdTest(){
        List<Student> student = studentRepository.findByEmailId("ashutosh@gmail.com");
        System.out.println(student);
    }


}


