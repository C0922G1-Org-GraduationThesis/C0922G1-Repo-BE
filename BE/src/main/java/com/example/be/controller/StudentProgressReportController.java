package com.example.be.controller;

import com.example.be.dto.StudentProgressReport;
import com.example.be.service.StudentProgressReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * SyVT
 */
@RestController
@RequestMapping("")
public class StudentProgressReportController {
    @Autowired
    private StudentProgressReportService studentProgressReportService;

    @GetMapping("studentProgressReport")
    public ResponseEntity<StudentProgressReport> findProgressReportById(@RequestParam Long id) {
        StudentProgressReport studentProgressReport = studentProgressReportService.findStudentProgressReportProjectId(id);
        if (studentProgressReport == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(studentProgressReport, HttpStatus.OK);
    }
}
