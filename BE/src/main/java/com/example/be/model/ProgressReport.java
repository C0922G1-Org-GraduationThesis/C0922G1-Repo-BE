package com.example.be.model;

import javax.persistence.*;

@Entity
public class ProgressReport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "progress_report_id")
    private Long progressReportId;
    @Column(columnDefinition = "text", nullable = false)
    private String progressReportContent;
    @Column(columnDefinition = "text", nullable = false)
    private String progressReportFile;
    @Column(columnDefinition = "date", nullable = false)
    private String progressReportDate;
    @ManyToOne
    @JoinColumn(name = "stage_id", referencedColumnName = "stage_id")
    private Stage stage;
    @JoinColumn(name = "project_id", referencedColumnName = "project_id")
    @ManyToOne
    private Project project;

    public ProgressReport() {
    }

    public ProgressReport(Long progressReportId, String progressReportContent,
                          String progressReportFile, String progressReportDate, Stage stage,
                          Project project) {
        this.progressReportId = progressReportId;
        this.progressReportContent = progressReportContent;
        this.progressReportFile = progressReportFile;
        this.progressReportDate = progressReportDate;
        this.stage = stage;
        this.project = project;
    }

    public String getProgressReportDate() {
        return progressReportDate;
    }

    public void setProgressReportDate(String progressReportDate) {
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


    public Stage getStage() {
        return stage;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }
}
