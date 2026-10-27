package com.venkat.crudSpringBoot.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class UpdateStudentReqDto {

    @NotBlank(message = "Name cannot be null or blank or empty spaces")
    private String name;

    @NotNull(message = "Age cannot be empty")
    @Min(value = 18, message = "Age must be greater than 17")
    private int age;

    @NotBlank(message = "subject cannot be empty or blank or null")
    private String subject;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
}
