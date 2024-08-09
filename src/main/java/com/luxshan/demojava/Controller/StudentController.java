package com.luxshan.demojava.Controller;
import com.luxshan.demojava.DTO.RequestDTO.RequestStudentDTO;
import com.luxshan.demojava.Service.StudentService;
import com.luxshan.demojava.Util.StandardResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path ="/api/v1/school")
public class StudentController {
    @Autowired
    private StudentService studentService;
    private final Logger LOGGER = LoggerFactory.getLogger(StudentController.class);

    //Save Record
    @PostMapping(path="/students")
    private ResponseEntity<StandardResponse>  SaveStudentDetails(
            @RequestBody RequestStudentDTO dto1)
    {
        LOGGER.info("API Received");
        return new ResponseEntity<>(new StandardResponse(
                "Data Saved...!",
                200,
                studentService.saveStudent(dto1)),
                HttpStatus.OK);
    }

    //Get All Record
    @GetMapping("/students")
    private ResponseEntity<StandardResponse> getStudentDetails(){
        return new ResponseEntity<>(new StandardResponse(
                "All Records are Fetched...!",
                200,
                studentService.getAllStudents()),
                HttpStatus.OK);
    }

    //Delete Record
    @DeleteMapping(path="students/{id}")
    private ResponseEntity<StandardResponse> deleteStudent(@PathVariable long id){
        return new ResponseEntity<>(new StandardResponse(
                "Record Deleted..!",
                    204,
                studentService.deleteStudent(id)),
                HttpStatus.OK);
    }

    //Update Record
    @PutMapping (path="/students/{id}")
    private ResponseEntity<StandardResponse>  UpdateUserDeatils(
            @RequestBody RequestStudentDTO dto,
            @PathVariable long id
    ){
        return new ResponseEntity<>(new StandardResponse(
                "Data Updated...!",
                200,
                studentService.updateStudent(dto,id)),
                HttpStatus.OK);
    }

    ////Get Record By ID
    @GetMapping("/students/{id}")
    private ResponseEntity<StandardResponse> getStudentById(@PathVariable long id) {
        return new ResponseEntity<>(new StandardResponse(
                "Record Fetched...!",
                200,
                studentService.getStudentById(id)),
                HttpStatus.OK);
    }
}


