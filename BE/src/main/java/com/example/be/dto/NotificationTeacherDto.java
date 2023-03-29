package com.example.be.dto;

import javax.validation.constraints.NotBlank;

public class NotificationTeacherDto {

    private Long notificationTeacherId;
    @NotBlank(message = "Không được để trống, nhập chủ đề thông báo vào. ")
    private String notificationTeacherName;
    @NotBlank(message = "Không được để trống, nhập nội dung thông báo vào. ")
    private String notificationTeacherContent;

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
}
