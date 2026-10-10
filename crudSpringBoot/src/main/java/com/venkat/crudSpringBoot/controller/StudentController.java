package com.venkat.crudSpringBoot.controller;

import com.venkat.crudSpringBoot.entity.Student;
import com.venkat.crudSpringBoot.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    private StudentService studentService;
    @Autowired
    public StudentController(StudentService studentService){
        this.studentService = studentService;
    }

    @PostMapping
    public ResponseEntity<Student> createStudent(@RequestBody Student student){
        System.out.println("Inside Student Controller");
        Student createdStudent = studentService.createStudent(student);
        System.out.println("Exiting Student Controller");
        return ResponseEntity.status(HttpStatus.CREATED).body(createdStudent);
    }
}
