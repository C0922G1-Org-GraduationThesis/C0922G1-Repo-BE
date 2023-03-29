package com.example.be.service;

import com.example.be.model.ProgressReport;
import com.example.be.repository.IProgressReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProgressReportService implements IProgressReportService {
    @Autowired
    private IProgressReportRepository progressReportRepository;
    /**
     * Created by: SyVT,
     * Date created : 29/03/2023
     * Function : Find All Progress Report
     *
     * @return HttpStatus.OK if result is not error or HttpStatus.NO_CONTENT if no content
     */
    @Override
    public List<ProgressReport> findAll() {
        return progressReportRepository.findAllProgressReport();
    }

    /**
     * Created by: SyVT,
     * Date created : 29/03/2023
     * Function : Find Student Progress Report By progressReportId
     *
     * @return HttpStatus.OK if result is not error or HttpStatus.NO_CONTENT if no content
     */
    @Override
    public ProgressReport findById(Long id) {
        return progressReportRepository.findProgressReportById(id);
    }

    /**
     * Created by: SyVT,
     * Date created : 29/03/2023
     * Function : Find Progress Report By ProjectId and By StageId
     *
     * @return HttpStatus.OK if result is not error or HttpStatus.NO_CONTENT if no content
     */
    @Override
    public ProgressReport findProgressReportByStageIdAndProjectId(Long projectId, int stageId) {
        return progressReportRepository.findProgressReportByStageIdAndProjectId(projectId, stageId);
    }

    /**
     * Created by: SyVT,
     * Date created : 29/03/2023
     * Function : Save Progress Report
     *
     * @param progress_report_content, progress_report_file, project_id, stage_id, progress_report_date
     */
    @Override
    public void save(String progress_report_content, String progress_report_file, Long project_id, int stage_id, String progress_report_date) {
        progressReportRepository.saveProgressReport(progress_report_content, progress_report_file, project_id, stage_id, progress_report_date);
    }


}
