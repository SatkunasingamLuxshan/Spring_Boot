package com.luxshan.demojava.Service;
import com.luxshan.demojava.DTO.RequestDTO.RequestStudentDTO;
import com.luxshan.demojava.DTO.ResponseDTO.ResponseStudentDTO;
import java.util.List;

public interface StudentService {

    public String saveStudent(RequestStudentDTO dto1);
    String deleteStudent(long id);
    List<ResponseStudentDTO> getAllStudents();
    String updateStudent(RequestStudentDTO dto,long id);
    ResponseStudentDTO getStudentById(long id);

}
