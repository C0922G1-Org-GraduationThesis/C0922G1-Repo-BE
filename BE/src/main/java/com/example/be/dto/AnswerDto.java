package com.example.be.dto;

import com.example.be.model.Question;
import com.example.be.model.Teacher;

import javax.validation.constraints.NotBlank;

public class AnswerDto {
    private Long answerId;
    @NotBlank
    private String answerContent;
    private Teacher teacher;
    private Question question;

    public AnswerDto() {
    }

    public Long getAnswerId() {
        return answerId;
    }

    public void setAnswerId(Long answerId) {
        this.answerId = answerId;
    }

    public String getAnswerContent() {
        return answerContent;
    }

    public void setAnswerContent(String answerContent) {
        this.answerContent = answerContent;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }
}
