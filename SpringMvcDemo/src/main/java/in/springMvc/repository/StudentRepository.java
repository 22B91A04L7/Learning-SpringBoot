package in.springMvc.repository;

import in.springMvc.entity.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class StudentRepository {
    private Map<Long, Student> userDB;

    public StudentRepository(){
        userDB = new HashMap<>();
    }

    public Student save(Student studentReq){
        userDB.put(studentReq.getId(), studentReq);
        return userDB.get(studentReq.getId());
    }

    public Student getStudentById(Long id){
        return userDB.get(id);
    }

    public List<Student> getAllStudents(){
        return new ArrayList<>(userDB.values());
    }
}
