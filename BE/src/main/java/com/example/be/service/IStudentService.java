package com.example.be.service;

import com.example.be.dto.StudentDto;
import com.example.be.dto.StudentInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IStudentService {

    /**
     * Create by : VinhLD
     * Date create 29/03/2023
     * Function: show list student
     *
     * @param pageable
     * @param nameSearch
     * @return json list student
     */
    Page<StudentDto> getStudentList(Pageable pageable, String nameSearch);



    /**
     * Create by : VinhLD
     * Date create 29/03/2023
     * Function: show the instructor's list of students
     *
     * @param pageable
     * @param nameSearch
     * @param idTeacher
     * @return json the instructor's list of students
     */
    Page<StudentInfo> findAllStudent(Pageable pageable, String nameSearch, Long idTeacher);

}
