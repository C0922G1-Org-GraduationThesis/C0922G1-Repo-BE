package com.example.be.controller;

import com.example.be.dto.StudentProgressReport;
import com.example.be.service.StudentProgressReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("")
public class StudentProgressReportController {

    @Autowired
    private StudentProgressReportService studentProgressReportService;

    /**
     * Created by: SyVT,
     * Date created : 29/03/2023
     * Function : find Student ProgressReport By progressReportId
     *
     * @return HttpStatus.OK if result is not error or HttpStatus.NO_CONTENT if no content
     */
    @GetMapping("studentProgressReport")
    public ResponseEntity<StudentProgressReport> findStudentProgressReportById(@RequestParam Long id) {
        StudentProgressReport studentProgressReport = studentProgressReportService.findStudentProgressReportProjectId(id);
        if (studentProgressReport == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(studentProgressReport, HttpStatus.OK);
    }
}
