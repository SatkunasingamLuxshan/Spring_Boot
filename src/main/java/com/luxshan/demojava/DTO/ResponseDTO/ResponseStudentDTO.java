package com.luxshan.demojava.DTO.ResponseDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseStudentDTO {
    private String firstName;
    private String lastName;
    private String email;
    private String course;
}
