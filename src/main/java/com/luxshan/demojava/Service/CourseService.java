package com.luxshan.demojava.Service;

import com.luxshan.demojava.DTO.RequestDTO.RequestCourseDTO;
import com.luxshan.demojava.DTO.ResponseDTO.ResponseCourseDTO;


import java.util.List;

public interface CourseService {

    public String saveCourse(RequestCourseDTO dto1);
    List<ResponseCourseDTO> getAllCourse();
    String deleteCourse(long id);
    String updateCourse(RequestCourseDTO dto,long id);
    ResponseCourseDTO getCourseById(long id);
}
