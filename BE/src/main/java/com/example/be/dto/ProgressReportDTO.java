package com.example.be.dto;

import com.example.be.model.Project;
import com.example.be.model.Stage;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

public class ProgressReportDTO {

    private Long progressReportId;
    @NotEmpty
    @NotBlank
    private String progressReportContent;
    @NotEmpty
    @NotBlank
    private String progressReportFile;
    @NotEmpty
    @NotBlank
    private String progressReportDate;

    public ProgressReportDTO(Long progressReportId, String progressReportContent, String progressReportFile, String progressReportDate) {
        this.progressReportId = progressReportId;
        this.progressReportContent = progressReportContent;
        this.progressReportFile = progressReportFile;
        this.progressReportDate = progressReportDate;
    }

    public ProgressReportDTO(String progressReportContent, String progressReportFile, String progressReportDate) {

        this.progressReportContent = progressReportContent;
        this.progressReportFile = progressReportFile;
        this.progressReportDate = progressReportDate;
    }

    public Long getProgressReportId() {
        return progressReportId;
    }

    public void setProgressReportId(Long progressReportId) {
        this.progressReportId = progressReportId;
    }

    public String getProgressReportContent() {
        return progressReportContent;
    }

    public void setProgressReportContent(String progressReportContent) {
        this.progressReportContent = progressReportContent;
    }

    public String getProgressReportFile() {
        return progressReportFile;
    }

    public void setProgressReportFile(String progressReportFile) {
        this.progressReportFile = progressReportFile;
    }

    public String getProgressReportDate() {
        return progressReportDate;
    }

    public void setProgressReportDate(String progressReportDate) {
        this.progressReportDate = progressReportDate;
    }
}
