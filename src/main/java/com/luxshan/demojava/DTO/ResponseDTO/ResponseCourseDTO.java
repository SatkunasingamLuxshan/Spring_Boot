package com.luxshan.demojava.DTO.ResponseDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class ResponseCourseDTO {
    private String courseName;
    private String description;
    private int duration;
}
