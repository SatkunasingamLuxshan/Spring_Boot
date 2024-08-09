package com.luxshan.demojava.Repo;

import com.luxshan.demojava.Entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepo extends JpaRepository<Course,Long> {
}
