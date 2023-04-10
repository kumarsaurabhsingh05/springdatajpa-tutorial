package com.springdatajpa.tutorial.repository;

import com.springdatajpa.tutorial.Entity.Course;
import com.springdatajpa.tutorial.Entity.CourseMaterial;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseMaterialRepositoryTest {
    @Autowired
    private CourseMaterialRepository repository;
    @Test
    public void saveCourseMaterial() {
        Course course =
                Course.builder()
                        .courseTitle("Spring Data")
                        .credit(6)
                        .build();

        CourseMaterial courseMaterial =
                CourseMaterial.builder()
                        .url("www.facebook.com")
                        .course(course)
                        .build();

        repository.save(courseMaterial);
    }

    @Test
    public void printAllCourses() {
        List<CourseMaterial> courseMaterials =
                repository.findAll();

        System.out.println("CourseMaterial = " + courseMaterials);
    }


}