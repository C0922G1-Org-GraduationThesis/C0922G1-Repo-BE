package com.example.be.dto;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.NotBlank;

public class NotificationTeacherDto implements Validator {
    /**
     * Create by: TuanNDN
     * Date created: 29/03/2023
     */
    private Long notificationTeacherId;
    @NotBlank(message = "Không được để trống, nhập chủ đề thông báo vào. ")
    private String notificationTeacherName;
    @NotBlank(message = "Không được để trống, nhập nội dung thông báo vào. ")
    private String notificationTeacherContent;
    private TeacherNTDto teacherNTDto;

    public NotificationTeacherDto() {
    }

    public NotificationTeacherDto(String notificationTeacherName, String notificationTeacherContent) {
        this.notificationTeacherName = notificationTeacherName;
        this.notificationTeacherContent = notificationTeacherContent;
    }

    public Long getNotificationTeacherId() {
        return notificationTeacherId;
    }

    public void setNotificationTeacherId(Long notificationTeacherId) {
        this.notificationTeacherId = notificationTeacherId;
    }

    public String getNotificationTeacherName() {
        return notificationTeacherName;
    }

    public void setNotificationTeacherName(String notificationTeacherName) {
        this.notificationTeacherName = notificationTeacherName;
    }

    public String getNotificationTeacherContent() {
        return notificationTeacherContent;
    }

    public void setNotificationTeacherContent(String notificationTeacherContent) {
        this.notificationTeacherContent = notificationTeacherContent;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {

    }

    public TeacherNTDto getTeacherNTDto() {
        return teacherNTDto;
    }

    public void setTeacherNTDto(TeacherNTDto teacherNTDto) {
        this.teacherNTDto = teacherNTDto;
    }
}
