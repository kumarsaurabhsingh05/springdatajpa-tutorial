package com.springdatajpa.tutorial.Entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString(exclude = "course")   // this is uncommented because i am using fetch = FetchType.EAGER
                                // if fetch = FetchType.LAZY then we have to comment the @ToString annotation
                                // it's pretty obvious when we get the material then why would we get the course
                                // this is called unidirectional one-to-one mapping
                                // its necessary in course where we get the course with course material, right ?
                                // have a look in Course class where we have defined bidirectional one-to-one relationship
public class CourseMaterial {
    @Id
    @SequenceGenerator(
            name ="course_material_sequence",
            sequenceName = "course_material_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "course_material_sequence"
    )
    private Long courseMaterialId;
    private String url;

    @OneToOne(
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            optional = false
    )
    @JoinColumn(
            name = "course_id",
            referencedColumnName = "courseId"
    )
    private Course course;
}
