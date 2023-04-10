package com.springdatajpa.tutorial.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Course {
    @Id
    @SequenceGenerator(
            name ="course_sequence",
            sequenceName = "course_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "course_sequence"
    )
    private Long courseId;
    private String courseTitle;
    private Integer credit;

    // we have defined bidirectional one-to-one relationship, it will bring the data from CourseMaterial also.
    // Here (In Course class), we can get the data of CourseMaterial also :)
    // because the attribute mappedBy = "course" is fetching the data
    @OneToOne(mappedBy = "course")
    private CourseMaterial courseMaterial;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(
            name = "teacher_id",
            referencedColumnName = "teacherId"
    )
    private Teacher teacher;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "student_course_map",
            joinColumns = @JoinColumn(
                    name = "course_id",
                    referencedColumnName = "courseId"
            ),
            inverseJoinColumns = @JoinColumn(
                    name = "student_id",
                    referencedColumnName = "student_id"
            )
    )
    private List<Student> students;

    public void addStudents(Student student) {
        if (students == null) {
            students = new ArrayList<>();
        } else {
            students.add(student);
        }
    }


}
