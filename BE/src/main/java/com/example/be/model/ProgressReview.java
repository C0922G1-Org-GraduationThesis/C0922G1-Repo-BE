package com.example.be.model;

import javax.persistence.*;

@Entity
public class ProgressReview {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long progressReviewId;
    private String progressReviewTitle;
    private String progressReviewContent;
    private String progressReviewPercent;
    private String progressReviewDateCreate;

    @ManyToOne
    @JoinColumn(name = "teacher_id", referencedColumnName = "teacher_id")
    private Teacher teacher;
    @ManyToOne
    @JoinColumn(name = "project_id", referencedColumnName = "project_id")
    private Project project;

    public ProgressReview() {
    }

    public Long getProgressReviewId() {
        return progressReviewId;
    }

    public void setProgressReviewId(Long progressReviewId) {
        this.progressReviewId = progressReviewId;
    }

    public String getProgressReviewTitle() {
        return progressReviewTitle;
    }

    public void setProgressReviewTitle(String progressReviewTitle) {
        this.progressReviewTitle = progressReviewTitle;
    }

    public String getProgressReviewContent() {
        return progressReviewContent;
    }

    public void setProgressReviewContent(String progressReviewContent) {
        this.progressReviewContent = progressReviewContent;
    }

    public String getProgressReviewPercent() {
        return progressReviewPercent;
    }

    public void setProgressReviewPercent(String progressReviewPercent) {
        this.progressReviewPercent = progressReviewPercent;
    }

    public String getProgressReviewDateCreate() {
        return progressReviewDateCreate;
    }

    public void setProgressReviewDateCreate(String progressReviewDateCreate) {
        this.progressReviewDateCreate = progressReviewDateCreate;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }
}
