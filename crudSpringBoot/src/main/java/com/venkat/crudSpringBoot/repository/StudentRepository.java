package com.venkat.crudSpringBoot.repository;

import com.venkat.crudSpringBoot.entity.Student;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
public class StudentRepository {
    public Student saveStudent(Student req){
        System.out.println("Inside Student Repository");

        System.out.println("Saved to DB");
        // dummy data
        Student s1 = new Student();
        s1.setName("Veera");
        s1.setAge(23);
        s1.setEmail("veera@gmail.com");
        s1.setRollNo(202);

        System.out.println("Exiting Student Repository");

        return s1;
    }
}
