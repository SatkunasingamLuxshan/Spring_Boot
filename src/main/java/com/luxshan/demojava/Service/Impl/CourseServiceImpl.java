package com.luxshan.demojava.Service.Impl;

import com.luxshan.demojava.DTO.RequestDTO.RequestCourseDTO;
import com.luxshan.demojava.DTO.ResponseDTO.ResponseCourseDTO;
import com.luxshan.demojava.Entity.Course;
import com.luxshan.demojava.Repo.CourseRepo;
import com.luxshan.demojava.Service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CourseServiceImpl implements CourseService {
    @Autowired
    private CourseRepo courseRepo;

    //Insert Record
    public String saveCourse(RequestCourseDTO dto1){
        Course c = new Course(
                dto1.getCourseName(),
                dto1.getDescription(),
                dto1.getDuration()
        );
        courseRepo.save(c);
        return dto1.getCourseName() ;
    }

    //Fetch All Record
    public List<ResponseCourseDTO> getAllCourse() {
        ArrayList<ResponseCourseDTO> arrayList = new ArrayList<>();
        List<Course> courses = courseRepo.findAll();

        for(Course c : courses){
            arrayList.add(new ResponseCourseDTO(
                    c.getCourseName(),
                    c.getDescription(),
                    c.getDuration()
                    )
            );
        }
        return arrayList;
    }

    //Delete a Record
    public String deleteCourse(long id) {
        Optional<Course> course = courseRepo.findById(id);
        if(course.isEmpty()){
            throw new RuntimeException("Course details not found");
        }
        else {
            courseRepo.delete(course.get());
            return course.get().getCourseName();
        }
    }

    //Update a Record
    public String updateCourse(RequestCourseDTO dto,long id) {
        Optional<Course> course = courseRepo.findById(id);
        if(course.isEmpty()){
            throw new RuntimeException("Course Deatils not found");
        }
        else {
            course.get().setCourseName(dto.getCourseName());
            course.get().setDescription(dto.getDescription());
            course.get().setDuration(dto.getDuration());

            courseRepo.save(course.get());
            return dto.getCourseName();
        }

    }
    //Get Record By ID
    public ResponseCourseDTO getCourseById(long id) {
        Optional<Course> course = courseRepo.findById(id);
        if(course.isEmpty()){
            throw new RuntimeException("Course details not found");
        } else {
            Course c = course.get();
            return new ResponseCourseDTO(c.getCourseName(), c.getDescription(), c.getDuration());
        }
    }
}
