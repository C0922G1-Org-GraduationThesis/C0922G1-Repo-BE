package com.example.be.dto;

import com.example.be.model.Answers;
import com.example.be.model.Student;

import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;
import java.util.Set;

public class QuestionDto {
    private Long questionId;
    @NotBlank
    private String questionTopic;
    @NotBlank
    private String questionContent;
    private LocalDateTime dateTime;
    private Set<Student> studentSet;
    private Set<Answers> answers;

    public QuestionDto() {
    }

    public Set<Student> getStudentSet() {
        return studentSet;
    }

    public void setStudentSet(Set<Student> studentSet) {
        this.studentSet = studentSet;
    }

    public Set<Answers> getAnswers() {
        return answers;
    }

    public void setAnswers(Set<Answers> answers) {
        this.answers = answers;
    }

    public Long getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Long questionId) {
        this.questionId = questionId;
    }

    public String getQuestionTopic() {
        return questionTopic;
    }

    public void setQuestionTopic(String questionTopic) {
        this.questionTopic = questionTopic;
    }

    public String getQuestionContent() {
        return questionContent;
    }

    public void setQuestionContent(String questionContent) {
        this.questionContent = questionContent;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }
}
