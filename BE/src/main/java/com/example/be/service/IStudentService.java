package com.example.be.service;

import com.example.be.model.ProgressReport;
import com.example.be.model.Stage;
import com.example.be.model.Student;

import java.util.List;
/**
 * SyVT
 */
public interface IStudentService {
    List<Student> findAll();

    Student findById(Long id);
}
