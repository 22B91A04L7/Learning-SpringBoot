package com.venkat.crudSpringBoot.controller;

import com.venkat.crudSpringBoot.dto.CreateStudentReqDto;
import com.venkat.crudSpringBoot.dto.CreateStudentRespDto;
import com.venkat.crudSpringBoot.dto.UpdateStudentReqDto;
import com.venkat.crudSpringBoot.dto.UpdateStudentRespDto;
import com.venkat.crudSpringBoot.entity.Student;
import com.venkat.crudSpringBoot.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    private StudentService studentService;
    @Autowired
    public StudentController(StudentService studentService){
        this.studentService = studentService;
    }

    //create student
    @PostMapping
    public ResponseEntity<CreateStudentRespDto> createStudent(@Valid @RequestBody CreateStudentReqDto createStudentReqDto){
        CreateStudentRespDto createdStudent = studentService.createStudent(createStudentReqDto); // asking service layer
        return ResponseEntity.status(HttpStatus.CREATED).body(createdStudent);
    }

    //read student by id
    @GetMapping("/{id}")
    public ResponseEntity<UpdateStudentRespDto> getStudent( @PathVariable Long id) {
        UpdateStudentRespDto foundStudent = studentService.findStudent(id);

        return ResponseEntity.ok(foundStudent);
    }

    //get all students
    @GetMapping
    public ResponseEntity<List<UpdateStudentRespDto>> getAllStudents(){
        List<UpdateStudentRespDto> studentsList = studentService.getAllStudents();
        return ResponseEntity.ok(studentsList);
    }

    //update a student
    @PutMapping
    public ResponseEntity<UpdateStudentRespDto> updateStudent(@RequestParam Long id,
                                                 @Valid @RequestBody UpdateStudentReqDto studentReqDto){
        UpdateStudentRespDto updatedStudent = studentService.updateStudent(id, studentReqDto);
        return ResponseEntity.ok(updatedStudent);
    }

    //delete a student with id
    @DeleteMapping
    public ResponseEntity<String> deleteStudent(@RequestParam Long id){
        studentService.deleteStudent(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PatchMapping("/soft-delete")
    public ResponseEntity<String> deleteStudentSoft(@RequestParam Long id){
        studentService.deleteStudentSoft(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
