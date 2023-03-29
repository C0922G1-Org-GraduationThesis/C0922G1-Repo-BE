package com.example.be.service;

import com.example.be.model.ProgressReport;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface IProgressReportService {
    /**
     * Created by: SyVT,
     * Date created : 29/03/2023
     * Function : FindAll
     *
     */
    List<ProgressReport> findAll();

    /**
     * Created by: SyVT,
     * Date created : 29/03/2023
     * Function : FindById
     *
     */
    ProgressReport findById(Long id);

    /**
     * Created by: SyVT,
     * Date created : 29/03/2023
     * Function :Find Progress Report By StageId and ProjectId
     *
     */
    ProgressReport findProgressReportByStageIdAndProjectId(Long projectId, int stageId);

    /**
     * Created by: SyVT,
     * Date created : 29/03/2023
     * Function : Save
     *
     */
    void save(String progress_report_content,String progress_report_file,Long project_id,int stage_id,String progress_report_date);



}
