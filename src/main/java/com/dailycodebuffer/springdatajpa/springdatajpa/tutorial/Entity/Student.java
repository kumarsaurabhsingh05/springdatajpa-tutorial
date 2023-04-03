package com.dailycodebuffer.springdatajpa.springdatajpa.tutorial.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Student {
    @Id
    private Long studentId;
    private String fName;
    private String lName;
    private String emailId;
    private String guardianName;
    private String guardianEmail;
    private String guardiaMobile;

}
