package com.example.be.service;

import com.example.be.model.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IStudentService {
    /**
     * Create by: HauNN
     * Date create: 29/03/2023
     * Function: find all student by student name containing or student code containing
     */
    Page<Student> findAllByNameOrStudentCode(String searchStr, Pageable pageable);

    /**
     * Create by: HauNN
     * Date create: 29/03/2023
     * Function: fill all Student by team id
     */
    Page<Student> findAllByTeamId(Long teamId, Pageable pageable);
}
