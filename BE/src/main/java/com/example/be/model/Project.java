package com.example.be.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "project_id")
    private Long projectId;
    @Column(columnDefinition = "varchar(255)", nullable = false, unique = true)
    private String projectName;
    @Column(columnDefinition = "text", nullable = false)
    private String projectContent;
    @Column(columnDefinition = "text", nullable = false)
    private String projectImg;
    @Column(columnDefinition = "text", nullable = false)
    private String projectDescription;
    @Column(columnDefinition = "bit(1)")
    private boolean projectStatus;
    @Column(columnDefinition = "bit(1)")
    private boolean flagDelete;
    @JsonIgnore
    @OneToMany(mappedBy = "project")
    private Set<ProgressReport> progressReportSet;
    @OneToOne(mappedBy = "project")
    private Team team;
    @JsonIgnore
    @OneToMany(mappedBy = "project")
    private Set<ProgressReview> progressReviews;

    public Project() {
    }

    public Set<ProgressReview> getProgressReviews() {
        return progressReviews;
    }

    public void setProgressReviews(Set<ProgressReview> progressReviews) {
        this.progressReviews = progressReviews;
    }

    public boolean isFlagDelete() {
        return flagDelete;
    }

    public void setFlagDelete(boolean flagDelete) {
        this.flagDelete = flagDelete;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public Set<ProgressReport> getProgressReportSet() {
        return progressReportSet;
    }

    public void setProgressReportSet(Set<ProgressReport> progressReportSet) {
        this.progressReportSet = progressReportSet;
    }

    public Long getProjectId() {
        return projectId;
    }

    public boolean isProjectStatus() {
        return projectStatus;
    }

    public void setProjectStatus(boolean status) {
        this.projectStatus = status;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String name) {
        this.projectName = name;
    }

    public String getProjectContent() {
        return projectContent;
    }

    public void setProjectContent(String content) {
        this.projectContent = content;
    }

    public String getProjectDescription() {
        return projectDescription;
    }

    public void setProjectDescription(String description) {
        this.projectDescription = description;
    }

    public String getProjectImg() {
        return projectImg;
    }

    public void setProjectImg(String img) {
        this.projectImg = img;
    }
}
