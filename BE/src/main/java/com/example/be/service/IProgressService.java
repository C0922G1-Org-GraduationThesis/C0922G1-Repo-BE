package com.example.be.service;

import com.example.be.dto.ProgressDto;
import com.example.be.dto.ProgressStudentDto;
import com.example.be.model.Project;

import java.util.List;

public interface IProgressService {
    List<ProgressDto> findAll();
    List<ProgressStudentDto>findAllStudentOfTeam(Long projectId);

}
