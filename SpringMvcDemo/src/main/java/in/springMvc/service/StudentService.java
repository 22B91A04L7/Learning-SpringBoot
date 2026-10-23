package in.springMvc.service;

import in.springMvc.entity.Student;
import in.springMvc.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }

    public Student createStudent(Student studentReq){
        Student studentRes = studentRepository.save(studentReq);
        return studentRes;
    }

    public Student getStudentById(Long id){
       return studentRepository.getStudentById(id);
    }

    public List<Student> getAllStudents(){
        return studentRepository.getAllStudents();
    }
}
