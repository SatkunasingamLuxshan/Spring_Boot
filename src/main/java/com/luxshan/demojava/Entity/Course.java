package com.luxshan.demojava.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "course")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String courseName;
    private String description;
    private int duration;

    public Course(String courseName, String description, int duration) {
        this.courseName=courseName;
        this.description=description;
        this.duration=duration;
    }
}

