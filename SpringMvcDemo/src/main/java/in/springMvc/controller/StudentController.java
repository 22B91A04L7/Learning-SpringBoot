package in.springMvc.controller;

import in.springMvc.entity.Student;
import in.springMvc.service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    private StudentService studentService;

    public StudentController(StudentService studentService){
        this.studentService = studentService;
    }

    @PostMapping()
    public ResponseEntity<Student> createStudent(@RequestBody Student studentReq){
        Student studentResp = studentService.createStudent(studentReq);
        return ResponseEntity.ok(studentResp);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable("id") Long id){
        Student studentResp = studentService.getStudentById(id);
        if(studentResp == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(studentResp);
    }

    @GetMapping
    public ResponseEntity<List<Student>> getAllStudents(){
        List<Student> studentResp = studentService.getAllStudents();
        if(studentResp.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(studentResp);
    }
}
