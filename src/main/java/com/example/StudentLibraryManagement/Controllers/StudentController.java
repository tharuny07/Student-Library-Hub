package com.example.StudentLibraryManagement.Controllers;

import com.example.StudentLibraryManagement.DTOs.StudentUpdateMobReqDto;
import com.example.StudentLibraryManagement.Models.Student;
import com.example.StudentLibraryManagement.Services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/students")
public class StudentController {
    @Autowired
    StudentService studentService;

    @PostMapping("/add_student")
    public String createStudent(@RequestBody Student student){
        return studentService.createStudent(student);
    }
    @GetMapping("/get-name-by-emailid")
    public String getNameByEmailId(@RequestParam("email") String emailId){
       return studentService.getNameByEmailId(emailId);
    }

    @PutMapping("/update-mobile-no")
    public String updateMobNo(@RequestBody StudentUpdateMobReqDto updateMobReq){
        return studentService.updateMobNo(updateMobReq);
    }
}
