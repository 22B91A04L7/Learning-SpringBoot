package com.venkat.crudSpringBoot.controller;

import com.venkat.crudSpringBoot.entity.Student;
import com.venkat.crudSpringBoot.service.StudentService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
    public ResponseEntity<Student> createStudent(@RequestBody Student student){
        Student createdStudent = studentService.createStudent(student); // asking service layer
        return ResponseEntity.status(HttpStatus.CREATED).body(createdStudent);
    }

    //read student by id
    @GetMapping("/get")
    public ResponseEntity<Student> getStudent( @RequestParam Long id) {
        Student foundStudent = studentService.findStudent(id);
        if(foundStudent == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(foundStudent);
    }

    //get all students
    @GetMapping("/getAll")
    public ResponseEntity<List<Student>> getAllStudents(){
        List<Student> studentsList = studentService.getAllStudents();
        if(studentsList.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(studentsList);
        }
        return ResponseEntity.ok(studentsList);
    }

    //update a student
    @PutMapping("/update/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable Long id,
                                                 @RequestBody  Student student){
        Student updatedStudent = studentService.updateStudent(id, student);
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
