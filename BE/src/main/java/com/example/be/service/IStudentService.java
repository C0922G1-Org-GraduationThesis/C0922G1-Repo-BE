package com.example.be.service;

import com.example.be.model.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IStudentService {
    /**
     * Create by: HauNN
     * Date create: 29/03/2023
     * Function: find all student by name containing or code containing
     *
     * @return list page student if result is not error else return null
     * @Param: searchStr, pageable
     */
    Page<Student> findAllByNameOrStudentCode(String searchStr, Pageable pageable);

    /**
     * Create by: HauNN
     * Date create: 29/03/2023
     * Function: find all student by team id
     *
     * @return list page student if result is not error else return null
     * @Param: teamId, pageable
     */
    Page<Student> findAllByTeamId(Long teamId, Pageable pageable);
}
