package com.example.be.service.impl;

import com.example.be.dto.StudentDto;
import com.example.be.dto.StudentInfo;
import com.example.be.repository.IStudentRepository;
import com.example.be.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class StudentService implements IStudentService {

    @Autowired
    private IStudentRepository studentRepository;

    @Override
    public Page<StudentDto> getStudentList(Pageable pageable, String nameSearch) {
        return studentRepository.getStudentList(pageable, nameSearch);
    }

    @Override
    public Page<StudentInfo> findAllStudent(Pageable pageable, String nameSearch, Long idTeacher) {
        return studentRepository.findAllStudent(pageable,nameSearch,idTeacher);
    }
}
