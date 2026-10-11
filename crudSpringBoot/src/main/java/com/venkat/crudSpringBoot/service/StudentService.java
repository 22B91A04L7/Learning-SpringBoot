package com.venkat.crudSpringBoot.service;

import com.venkat.crudSpringBoot.entity.Student;
import com.venkat.crudSpringBoot.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    //to create a student
    public Student createStudent(Student studentReq) {
        Student studentResponse = studentRepository.save(studentReq); // asking repository layer
        return studentResponse;
    }

    // to read a single student details
    public Student findStudent(Long id){
        Optional<Student> studentResponse = studentRepository.findById(id);
        if(studentResponse.isPresent()){
            return studentResponse.get();
        }
        return null;
    }

    // to get all students details
    public List<Student> getAllStudents(){
        List<Student> studentsListResp = studentRepository.findAll();
        return studentsListResp;
    }

    // to update studeny with id
    public Student updateStudent(Long id, Student student){
       Optional<Student> foundStudent = studentRepository.findById(id);
       if(foundStudent.isEmpty()){
           return null;
       }
       Student updatedStudentResp = studentRepository.save(student);
       return updatedStudentResp;
    }

    // to delete a student
    public String deleteStudent(Long id){
        Optional<Student> isExisting = studentRepository.findById(id);
        if(!isExisting.isPresent()){
            return "Student does not exist";
        }
        studentRepository.deleteById(id);
        return "Student Deleted Successfully";
    }

}
