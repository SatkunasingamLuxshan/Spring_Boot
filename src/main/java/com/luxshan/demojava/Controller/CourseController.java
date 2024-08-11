package com.luxshan.demojava.Controller;
import com.luxshan.demojava.DTO.RequestDTO.RequestCourseDTO;
import com.luxshan.demojava.DTO.RequestDTO.RequestStudentDTO;
import com.luxshan.demojava.Service.CourseService;
import com.luxshan.demojava.Service.StudentService;
import com.luxshan.demojava.Util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path ="/api/v1/school")
public class CourseController {
    @Autowired
    private CourseService courseService;

    //Save Record
    @PostMapping(path="/courses")
    private ResponseEntity<StandardResponse> SaveCourseDetail(
            @RequestBody RequestCourseDTO dto1)
    {
        return new ResponseEntity<>(new StandardResponse(
                " Course Deatils Saved!",
                200,
                courseService.saveCourse(dto1)),
                HttpStatus.OK);
    }

    //Get All Record
    @GetMapping("/courses")
    private ResponseEntity<StandardResponse> getCourseDetails(){
        return new ResponseEntity<>(new StandardResponse(
                "All Records are Fetched...!",
                200,
                courseService.getAllCourse()),
                HttpStatus.OK);
    }

    //Delete Record
    @DeleteMapping(path="courses/{id}")
    private ResponseEntity<StandardResponse> deleteCourseDetail(@PathVariable long id){
        return new ResponseEntity<>(new StandardResponse(
                "Record Deleted..!",
                204,
                courseService.deleteCourse(id)),
                HttpStatus.OK);
    }

    //Update Record
    @PutMapping (path="/courses/{id}")
    private ResponseEntity<StandardResponse>  UpdateCourseDeatils(
            @RequestBody RequestCourseDTO dto,
            @PathVariable long id)
    {
        return new ResponseEntity<>(new StandardResponse(
                "Data Updated...!",
                200,
                courseService.updateCourse(dto,id)),
                HttpStatus.OK);
    }

    //Get Record By ID
    @GetMapping("/courses/{id}")
    private ResponseEntity<StandardResponse> getCourseById(@PathVariable long id) {
        return new ResponseEntity<>(new StandardResponse(
                "Record Fetched...!", 200, courseService.getCourseById(id)), HttpStatus.OK);
    }
}
