package com.springdatajpa.tutorial.repository;

import com.springdatajpa.tutorial.Entity.Course;
import com.springdatajpa.tutorial.Entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TeacherRepositoryTest {
    @Autowired
    private TeacherRepository teacherRepository;
    @Test
    public void saveTeacher() {

        Course course1 = Course.builder()
                .courseTitle("DAA")
                .credit(5)
                .build();

        Course course2 = Course.builder()
                .courseTitle("DBMS")
                .credit(6)
                .build();

        Course course3 = Course.builder()
                .courseTitle("Cyber Security")
                .credit(5)
                .build();

        Teacher teacher = Teacher.builder()
                .firstName("Devanshu")
                .lastName("Dube")
//                .courses(List.of(course1, course2, course3))
                .build();

        teacherRepository.save(teacher);
    }
}