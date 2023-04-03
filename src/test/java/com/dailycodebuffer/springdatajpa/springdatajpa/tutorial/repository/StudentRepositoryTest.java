package com.dailycodebuffer.springdatajpa.springdatajpa.tutorial.repository;

import com.dailycodebuffer.springdatajpa.springdatajpa.tutorial.Entity.Guardian;
import com.dailycodebuffer.springdatajpa.springdatajpa.tutorial.Entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StudentRepositoryTest {
    @Autowired
    private StudentRepository studentRepository;
    @Test
    public void saveStudent() {
        Student student = Student.builder()
                .emailId("swatikn07@gmail.com")
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
                .name("Ramchandra Yadav")
                .email("ramji@gmail.com")
                .mobile("8989899987")
                .build();

        Student student = Student.builder()
                .firstName("Ashutosh")
                .lastName("Yadav")
                .emailId("ashutoshrana@gmail.com")
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
        String name = studentRepository.getStudentFistNameByEmailAddress("swatikn07@gmail.com");
        System.out.println(name);
    }

}