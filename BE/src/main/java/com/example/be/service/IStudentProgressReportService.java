package com.example.be.service;

import com.example.be.dto.StudentProgressReport;

public interface IStudentProgressReportService {
   /**
    * Created by: SyVT,
    * Date created : 29/03/2023
    * Function : Find Student Progress Report By ProjectId
    *
    */
   StudentProgressReport findStudentProgressReportProjectId(Long projectId);
}
