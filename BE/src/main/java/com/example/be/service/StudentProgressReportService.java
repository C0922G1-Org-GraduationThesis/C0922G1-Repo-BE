package com.example.be.service;

import com.example.be.repository.IStudentProgressReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 * SyVT
 */
@Service
public class StudentProgressReportService {
    @Autowired
    private IStudentProgressReportRepository studentProgressReportRepository;

    public com.example.be.dto.StudentProgressReport findStudentProgressReportProjectId(Long project_id) {
        return studentProgressReportRepository.findStudentProgressReportProjectId(project_id);
    }
}
