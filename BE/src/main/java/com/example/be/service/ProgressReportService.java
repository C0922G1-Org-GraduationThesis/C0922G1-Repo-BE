package com.example.be.service;

import com.example.be.model.ProgressReport;
import com.example.be.repository.IProgressReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
/**
 * SyVT
 */
@Service
public class ProgressReportService implements IProgressReportService {
    @Autowired
    private IProgressReportRepository progressReportRepository;

    @Override
    public List<ProgressReport> findAll() {
        return progressReportRepository.findAllProgressReport();
    }

    @Override
    public ProgressReport findById(Long id) {
        return progressReportRepository.findProgressReportById(id);
    }

    @Override
    public ProgressReport findProgressReportByStageIdAndProjectId(Long projectId, int stageId) {
        return progressReportRepository.findProgressReportByStageIdAndProjectId(projectId, stageId);
    }
    @Override
    public void save(String progress_report_content, String progress_report_file, Long project_id, int stage_id, String progress_report_date) {
        progressReportRepository.saveProgressReport(progress_report_content, progress_report_file, project_id, stage_id, progress_report_date);
    }

    @Override
    public void delete(Long id) {
        progressReportRepository.deleteById(id);
    }

}
