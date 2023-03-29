package com.example.be.controller;

import com.example.be.model.ProgressReport;
import com.example.be.service.IProgressReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
/**
 * SyVT
 */
@RestController
@RequestMapping("report")
public class ProgressReportController {
    @Autowired
    private IProgressReportService progressReportService;

    @PostMapping("/")
    public ResponseEntity<?> saveBus(@RequestBody ProgressReport progressReport) {
        progressReportService.save(progressReport.getProgressReportContent(), progressReport.getProgressReportFile(), progressReport.getProject().getProjectId(), progressReport.getStage().getStageId(), progressReport.getProgressReportDate());
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProgressReport> findProgressReportById(@PathVariable Long id) {
        ProgressReport progressReport = progressReportService.findById(id);
        if (progressReport == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(progressReport, HttpStatus.OK);
    }

    @GetMapping("/searchProjectIdAndStageId")
    public ResponseEntity<ProgressReport> findProgressReportByProjectIdAndStageId(@RequestParam("project_id") Long projectId, @RequestParam("stage_id") int stageId) {
        ProgressReport progressReport = progressReportService.findProgressReportByStageIdAndProjectId(projectId, stageId);
        if (progressReport == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(progressReport, HttpStatus.OK);
    }

}
