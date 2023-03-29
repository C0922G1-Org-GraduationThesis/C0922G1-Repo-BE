package com.example.be.service;

import com.example.be.repository.IStudentProgressReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class StudentProgressReportService implements IStudentProgressReportService {

    @Autowired
    private IStudentProgressReportRepository studentProgressReportRepository;

    /**
     * Created by: SyVT,
     * Date created : 29/03/2023
     * Function : Find Student Progress Report By ProjectId
     *
     * @param projectId
     */
    public com.example.be.dto.StudentProgressReport findStudentProgressReportProjectId(Long projectId) {
        return studentProgressReportRepository.findStudentProgressReportProjectId(projectId);
    }
}
