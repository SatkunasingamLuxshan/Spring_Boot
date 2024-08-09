package com.luxshan.demojava.Entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.web.bind.annotation.GetMapping;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String firstName;
    private String lastName;
    @Column(unique = true)  // This makes the email field unique
    private String email;
    private String course;

    public Student(String firstName,String lastName,String email,String course) {
        this.firstName=firstName;
        this.lastName=lastName;
        this.email=email;
        this.course=course;
    }
}