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
    private String name;
    @Column(columnDefinition = "text", nullable = false)
    private String content;
    @Column(columnDefinition = "text", nullable = false)
    private String img;
    @Column(columnDefinition = "text", nullable = false)
    private String description;
    @Column(columnDefinition = "bit(1)")
    private boolean projectStatus;
    @JsonIgnore
    @OneToMany(mappedBy = "project")
    private Set<ProgressReport> progressReportSet;
    @OneToOne(mappedBy = "project")
    private Team team;

    public Project() {
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}
