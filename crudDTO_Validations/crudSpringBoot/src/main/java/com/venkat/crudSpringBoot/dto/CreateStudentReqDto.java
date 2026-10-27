package com.venkat.crudSpringBoot.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class CreateStudentReqDto {

    @NotBlank(message = "Name cannot be null or blank or empty spaces")
    private String name;

    @NotNull(message = "Age cannot be empty")
    @Min(value = 18, message = "Age must be greater than 17")
    private Integer age;

    @NotNull(message = "email cannot be null or empty")
    @Email(message = "Email must be valid")
    private String email;

    @NotNull(message = "RollNo cannot be null or empty")
    private int rollNo;

    @NotBlank(message = "subject cannot be empty or blank or null")
    private String subject;

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public int getRollNo() {
        return rollNo;
    }

    public void setRollNo(int rollNo) {
        this.rollNo = rollNo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
