package com.venkat.FiltersDemo.controller;

import com.venkat.FiltersDemo.dto.StudentDto;
import com.venkat.FiltersDemo.service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    StudentService studentService;

    public StudentController(StudentService studentService){
        this.studentService = studentService;
    }

    @PostMapping
    public ResponseEntity<String> createStudent(@RequestBody StudentDto student){
        studentService.createStudent(student);
        return ResponseEntity.ok("DONE");
    }
}
