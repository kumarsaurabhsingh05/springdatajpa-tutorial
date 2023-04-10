package com.springdatajpa.tutorial.repository;

import com.springdatajpa.tutorial.Entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Long> {

}
