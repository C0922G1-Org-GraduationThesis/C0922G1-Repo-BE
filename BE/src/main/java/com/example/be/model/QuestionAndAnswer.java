package com.example.be.model;

import javax.persistence.*;

@Entity
public class QuestionAndAnswer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long questionAndAnswerId;
    @Column(columnDefinition = "varchar(50)" ,nullable = false)
    private String questionAndAnswerTitle;
    @Column(columnDefinition = "text" ,nullable = false)
    private String questionAndAnswerContent;
    @Column(columnDefinition = "text" ,nullable = false)
    private String questionAndAnswerReply;
    @ManyToOne
    @JoinColumn(name = "student_id", referencedColumnName = "student_id")
    private Student student;

    public QuestionAndAnswer() {
    }

    public Long getQuestionAndAnswerId() {
        return questionAndAnswerId;
    }

    public void setQuestionAndAnswerId(Long questionAndAnswerId) {
        this.questionAndAnswerId = questionAndAnswerId;
    }

    public String getQuestionAndAnswerTitle() {
        return questionAndAnswerTitle;
    }

    public void setQuestionAndAnswerTitle(String questionAndAnswerTitle) {
        this.questionAndAnswerTitle = questionAndAnswerTitle;
    }

    public String getQuestionAndAnswerContent() {
        return questionAndAnswerContent;
    }

    public void setQuestionAndAnswerContent(String questionAndAnswerContent) {
        this.questionAndAnswerContent = questionAndAnswerContent;
    }

    public String getQuestionAndAnswerReply() {
        return questionAndAnswerReply;
    }

    public void setQuestionAndAnswerReply(String questionAndAnswerReply) {
        this.questionAndAnswerReply = questionAndAnswerReply;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
