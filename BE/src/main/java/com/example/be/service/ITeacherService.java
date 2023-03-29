package com.example.be.service;

import com.example.be.dto.ITeacherDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface ITeacherService {
    Page<ITeacherDto> getAllTeacher(String name, Pageable pageable);

    Optional<ITeacherDto> findTeacherById(Long id);

    void deleteTeacherById(long id);
}
