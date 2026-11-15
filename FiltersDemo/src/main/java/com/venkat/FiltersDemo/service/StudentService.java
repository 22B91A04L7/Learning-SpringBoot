package com.venkat.FiltersDemo.service;

import com.venkat.FiltersDemo.dto.StudentDto;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    public void createStudent(StudentDto student){
        System.out.println("Student created!");
        System.out.println(student.getName());
        System.out.println(student.getEmail());
    }
}
