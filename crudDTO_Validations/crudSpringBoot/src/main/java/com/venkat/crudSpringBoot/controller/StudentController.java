package com.venkat.crudSpringBoot.controller;

import com.venkat.crudSpringBoot.dto.CreateStudentReqDto;
import com.venkat.crudSpringBoot.dto.CreateStudentRespDto;
import com.venkat.crudSpringBoot.dto.UpdateStudentReqDto;
import com.venkat.crudSpringBoot.dto.UpdateStudentRespDto;
import com.venkat.crudSpringBoot.entity.Student;
import com.venkat.crudSpringBoot.service.StudentService;
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
    @PostMapping("/create")
    public ResponseEntity<CreateStudentRespDto> createStudent(@RequestBody CreateStudentReqDto createStudentReqDto){
        CreateStudentRespDto createdStudent = studentService.createStudent(createStudentReqDto); // asking service layer
        return ResponseEntity.status(HttpStatus.CREATED).body(createdStudent);
    }

    //read student by id
    @GetMapping("/get")
    public ResponseEntity<UpdateStudentRespDto> getStudent( @RequestParam Long id) {
        UpdateStudentRespDto foundStudent = studentService.findStudent(id);
        if(foundStudent == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(foundStudent);
    }

    //get all students
    @GetMapping("/getAll")
    public ResponseEntity<List<UpdateStudentRespDto>> getAllStudents(){
        List<UpdateStudentRespDto> studentsList = studentService.getAllStudents();
        if(studentsList.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(studentsList);
        }
        return ResponseEntity.ok(studentsList);
    }

    //update a student
    @PutMapping("/update/{id}")
    public ResponseEntity<UpdateStudentRespDto> updateStudent(@PathVariable Long id,
                                                 @RequestBody UpdateStudentReqDto studentReqDto){
        UpdateStudentRespDto updatedStudent = studentService.updateStudent(id, studentReqDto);
        if(updatedStudent == null){
            return  ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedStudent);
    }

    //delete a student with id
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable Long id){
        String response = studentService.deleteStudent(id);
        return ResponseEntity.ok(response);
    }

    @PatchMapping("/soft-delete/{id}")
    public ResponseEntity<String> deleteStudentSoft(@PathVariable Long id){
        Boolean isDeleted = studentService.deleteStudentSoft(id);

        if(!isDeleted){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok("Soft Deleted! Success");
    }
}
