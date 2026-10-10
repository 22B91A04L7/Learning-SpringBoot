package com.venkat.crudSpringBoot.service;

import com.venkat.crudSpringBoot.entity.Student;
import com.venkat.crudSpringBoot.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    private StudentRepository studentRepository;
    @Autowired
    public StudentService(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }
    public Student createStudent(Student studentReq){
        System.out.println("Inside Student Service");
        Student studentResponse = studentRepository.saveStudent(studentReq);
        System.out.println("Exiting Student Service");
        return studentResponse;
    }
}
