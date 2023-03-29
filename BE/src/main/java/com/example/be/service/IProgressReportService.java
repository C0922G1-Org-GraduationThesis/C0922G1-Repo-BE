package com.example.be.service;

import com.example.be.model.ProgressReport;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
/**
 * SyVT
 */
public interface IProgressReportService {
    List<ProgressReport> findAll();

    ProgressReport findById(Long id);

    ProgressReport findProgressReportByStageIdAndProjectId(Long projectId, int stageId);

    void save(String progress_report_content,String progress_report_file,Long project_id,int stage_id,String progress_report_date);

    void delete(Long id);

}
