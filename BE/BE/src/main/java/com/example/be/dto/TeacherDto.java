package com.example.be.dto;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

public class TeacherDto implements Validator {

    private Long teacherId;
    @NotBlank(message = "Không được để trống")
    private String teacherName;

    private String email;

    private String phoneNumber;


    private String teacherAddress;


    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}
