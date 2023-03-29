package com.example.be.repository;
import com.example.be.model.ProgressReport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import javax.transaction.Transactional;
import java.util.List;


@Transactional
@Repository
public interface IProgressReportRepository extends JpaRepository<ProgressReport, Long> {

    /**
     * Created by: SyVT,
     * Date created : 29/03/2023
     * Function : Find All Progress Report
     *
     */
    @Query(value = "SELECT pr.* FROM progress_report as pr", nativeQuery = true)
    List<ProgressReport> findAllProgressReport();

    /**
     * Created by: SyVT,
     * Date created : 29/03/2023
     * Function : Save ProgressReport
     *
     */
    @Modifying
    @Query(value = "INSERT INTO progress_report(progress_report_content, progress_report_file, project_id, stage_id,progress_report_date ) " +
            "VALUES (:progress_report_content, :progress_report_file, :project_id, :stage_id, :progress_report_date)",
            nativeQuery = true)
    void saveProgressReport(@Param("progress_report_content") String progress_report_content, @Param("progress_report_file") String progress_report_file,
                            @Param("project_id") Long project_id,
                            @Param("stage_id") int stage_id, @Param("progress_report_date") String progress_report_date);

    /**
     * Created by: SyVT,
     * Date created : 29/03/2023
     * Function : Find ProgressReport By Id
     *
     */
    @Query(value = "SELECT pr.* FROM progress_report as pr WHERE progress_report_id = :progress_report_id", nativeQuery = true)
    ProgressReport findProgressReportById(@Param("progress_report_id") Long progress_report_id);

    /**
     * Created by: SyVT,
     * Date created : 29/03/2023
     * Function : Find ProgressReport By StageId And ProjectId
     *
     */
    @Query(value = "SELECT pr.* FROM progress_report as pr WHERE stage_id = :project_id and project_id = :stage_id", nativeQuery = true)
    ProgressReport findProgressReportByStageIdAndProjectId(@Param("project_id") Long project_id, @Param("stage_id") int stage_id);


}
