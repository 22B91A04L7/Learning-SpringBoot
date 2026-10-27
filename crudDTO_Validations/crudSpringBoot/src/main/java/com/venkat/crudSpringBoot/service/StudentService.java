package com.venkat.crudSpringBoot.service;

import com.venkat.crudSpringBoot.dto.CreateStudentReqDto;
import com.venkat.crudSpringBoot.dto.CreateStudentRespDto;
import com.venkat.crudSpringBoot.dto.UpdateStudentReqDto;
import com.venkat.crudSpringBoot.dto.UpdateStudentRespDto;
import com.venkat.crudSpringBoot.entity.Student;
import com.venkat.crudSpringBoot.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
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
    public CreateStudentRespDto createStudent(CreateStudentReqDto createStudentReqDto) {
        Student studentReq = mapToEntity(createStudentReqDto);
        Student studentResponse = studentRepository.save(studentReq); // asking repository layer
        return mapToDto(studentResponse);
    }

    // to read a single student details
    public UpdateStudentRespDto findStudent(Long id){
        Optional<Student> studentResponse = studentRepository.findByIdAndDeletedIsFalse(id);
       if(studentResponse.isEmpty()){
           return null;
       }
       Student foundStudent = studentResponse.get();
       return mapToUpdatedDto(foundStudent);
    }

    // to get all students details
    public List<UpdateStudentRespDto> getAllStudents(){
        List<Student> studentsListResp = studentRepository.findByDeletedIsFalse();

        return studentsListResp.stream().map(this::mapToUpdatedDto).toList();
    }

    // to update studeny with id
    public UpdateStudentRespDto updateStudent(Long id, UpdateStudentReqDto incomingStudentDto){
       Optional<Student> studentResp = studentRepository.findByIdAndDeletedIsFalse(id);
       if(studentResp.isEmpty()){
           return null;
       }
       Student existingStudent = studentResp.get();
       existingStudent.setName(incomingStudentDto.getName());
       existingStudent.setAge(incomingStudentDto.getAge());
       existingStudent.setSubject(incomingStudentDto.getSubject());
//       existingStudent.setDeleted(false); // Ensure it stays active
        Student updatedStudentResp = studentRepository.save(existingStudent);
       return mapToUpdatedDto(updatedStudentResp);
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
        Optional<Student> studentResp = studentRepository.findByIdAndDeletedIsFalse(id);
        if(studentResp.isEmpty()) return false;
        Student studentToSave = studentResp.get();
        studentToSave.setDeleted(true);
        studentRepository.save(studentToSave);
        return true;
    }

    private Student mapToEntity(CreateStudentReqDto createStudentReqDto){
        Student student = new Student();

        student.setName(createStudentReqDto.getName());
        student.setAge(createStudentReqDto.getAge());
        student.setEmail(createStudentReqDto.getEmail());
        student.setRollNo(createStudentReqDto.getRollNo());
        student.setSubject(createStudentReqDto.getSubject());

        student.setDeleted(false);
        student.setCreatedAt(LocalDateTime.now());
        student.setUpdatedAt(LocalDateTime.now());
        return student;
    }

    private CreateStudentRespDto mapToDto(Student studentEntity){
        CreateStudentRespDto createStudentRespDto = new CreateStudentRespDto();

        createStudentRespDto.setId(studentEntity.getId());
        createStudentRespDto.setName(studentEntity.getName());
        createStudentRespDto.setAge(studentEntity.getAge());
        createStudentRespDto.setRollNo(studentEntity.getRollNo());
        createStudentRespDto.setEmail(studentEntity.getEmail());
        createStudentRespDto.setSubject(studentEntity.getSubject());
        createStudentRespDto.setCreatedAt(studentEntity.getUpdatedAt());
        createStudentRespDto.setUpdatedAt(studentEntity.getUpdatedAt());
        createStudentRespDto.setMessage("Student created successfully");

        return createStudentRespDto;
    }

    private UpdateStudentRespDto mapToUpdatedDto(Student studentResp){
        UpdateStudentRespDto studentRespDto = new UpdateStudentRespDto();

        studentRespDto.setId(studentResp.getId());
        studentRespDto.setAge(studentResp.getAge());
        studentRespDto.setEmail(studentResp.getEmail());
        studentRespDto.setName(studentResp.getName());
        studentRespDto.setRollNo(studentResp.getRollNo());
        studentRespDto.setSubject(studentResp.getSubject());
        studentRespDto.setUpdatedAt(LocalDateTime.now());
        studentRespDto.setMessage("Student updated successfully");
        return studentRespDto;
    }

}
