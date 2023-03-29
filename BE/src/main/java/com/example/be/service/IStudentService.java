package com.example.be.service;

import com.example.be.dto.StudentDto;
import com.example.be.dto.StudentInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IStudentService {

    Page<StudentDto> getStudentList(Pageable pageable, String nameSearch);

    Page<StudentInfo> findAllStudent(Pageable pageable, String nameSearch, Long idTeacher);

}
