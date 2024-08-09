package com.luxshan.demojava.Service.Impl;
import com.luxshan.demojava.DTO.RequestDTO.RequestStudentDTO;
import com.luxshan.demojava.DTO.ResponseDTO.ResponseStudentDTO;
import com.luxshan.demojava.Entity.Student;
import com.luxshan.demojava.Repo.StudentRepo;
import com.luxshan.demojava.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentRepo studentRepo;

    //Insert Record
    public String saveStudent(RequestStudentDTO dto1){
        Student s = new Student(
                dto1.getFirstName(),
                dto1.getLastName(),
                dto1.getEmail(),
                dto1.getCourse()
        );
        studentRepo.save(s);
        return dto1.getFirstName();


    }

    //Delete a Record
    public String deleteStudent(long id) {
        Optional<Student> student = studentRepo.findById(id);
        if(student.isEmpty()){
            throw new RuntimeException("Student not found");
        }
        else {
            studentRepo.delete(student.get());
            return student.get().getFirstName();
        }

    }

    //Fetch All Record
    public List<ResponseStudentDTO> getAllStudents() {
        ArrayList<ResponseStudentDTO> arrayList = new ArrayList<>();
        List<Student> students = studentRepo.findAll();

        for(Student s : students){
            arrayList.add(new ResponseStudentDTO(
                s.getFirstName(),
                s.getLastName(),
                s.getEmail(),
                s.getCourse()
            ));
        }
        return arrayList;
    }

//Update a Record
    public String updateStudent(RequestStudentDTO dto,long id) {
        Optional<Student> student = studentRepo.findById(id);
        if(student.isEmpty()){
            throw new RuntimeException("Student not found");
        }
        else {
            student.get().setFirstName(dto.getFirstName());
            student.get().setLastName(dto.getLastName());
            student.get().setEmail(dto.getEmail());
            student.get().setCourse(dto.getCourse());
            studentRepo.save(student.get());
            return dto.getFirstName();
        }
    }
    //Get Record By ID
    public ResponseStudentDTO getStudentById(long id) {
        Optional<Student> student = studentRepo.findById(id);
        if(student.isEmpty()){
            throw new RuntimeException("Student details not found");
        } else {
            Student s = student.get();
            return new ResponseStudentDTO(
                    s.getFirstName(),
                    s.getLastName(),
                    s.getEmail(),
                    s.getCourse());
        }
    }
}
