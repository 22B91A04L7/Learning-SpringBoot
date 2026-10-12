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
        studentReq.setDeleted(false);
        Student studentResponse = studentRepository.save(studentReq); // asking repository layer
        return studentResponse;
    }

    // to read a single student details
    public Student findStudent(Long id){
        Optional<Student> studentResponse = studentRepository.findByIdAndDeletedIsFalse(id);
        if(studentResponse.isPresent()){
            return studentResponse.get();
        }
        return null;
    }

    // to get all students details
    public List<Student> getAllStudents(){
        List<Student> studentsListResp = studentRepository.findByDeletedIsFalse();
        return studentsListResp;
    }

    // to update studeny with id
    public Student updateStudent(Long id, Student incomingStudent){
       Optional<Student> studentResp = studentRepository.findByIdAndDeletedIsFalse(id);
       if(studentResp.isEmpty()){
           return null;
       }
       Student existingStudent = studentResp.get();
       existingStudent.setName(incomingStudent.getName());
       existingStudent.setAge(incomingStudent.getAge());
       existingStudent.setEmail(incomingStudent.getEmail());
       existingStudent.setRollNo(incomingStudent.getRollNo());
       existingStudent.setSubject(incomingStudent.getSubject());
       existingStudent.setDeleted(false); // Ensure it stays active
        Student updatedStudentResp = studentRepository.save(existingStudent);
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

    public Boolean deleteStudentSoft(Long id){
        Optional<Student> studentResp = studentRepository.findById(id);
        if(studentResp.isEmpty()) return false;
        Student studentToSave = studentResp.get();
        studentToSave.setDeleted(true);
        studentRepository.save(studentToSave);
        return true;
    }

}
