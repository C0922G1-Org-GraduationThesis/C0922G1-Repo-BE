package com.example.be.repository;

import com.example.be.dto.StudentProgressReport;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
/**
 * SyVT
 */
@Repository
@Transactional
public interface IStudentProgressReportRepository {

    @Query(value = "SELECT pr.progress_report_content, pr.progress_report_file, pr.progress_report_date, tl.leader_name FROM\n" +
            " progress_report pr join project p on pr.project_id = p.project_id \n" +
            " join team t on  p.project_id = t.project_id join team_leader tl WHERE p.project_id = : project_id", nativeQuery = true)
    StudentProgressReport findStudentProgressReportProjectId(@Param("project_id") Long project_id);
}
