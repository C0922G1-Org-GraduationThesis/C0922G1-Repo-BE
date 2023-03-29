package com.example.be.service.impl;

import com.example.be.model.Student;
import com.example.be.repository.IStudentRepository;
import com.example.be.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
public class StudentService implements IStudentService {
    @Autowired
    private IStudentRepository studentRepository;
    @Override
    public Student findStudentByEmail(String email) {
        return studentRepository.findStudentByEmail(email);
    }
}
