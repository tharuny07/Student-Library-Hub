package com.example.StudentLibraryManagement.Controllers;

import com.example.StudentLibraryManagement.Models.Student;
import com.example.StudentLibraryManagement.Services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/students")
public class StudentController {
    @Autowired
    StudentService studentService;

    @PostMapping("/add_student")
    public String createStudent(@RequestBody Student student){
        return studentService.createStudent(student);
    }
}
