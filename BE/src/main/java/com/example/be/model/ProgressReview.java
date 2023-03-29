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
    @JoinColumn(name = "project_id", referencedColumnName = "project_id")
    private Project project;

    @ManyToOne
    @JoinColumn(name = "teacher_id", referencedColumnName = "teacher_id")
    private Teacher teacher;

}
