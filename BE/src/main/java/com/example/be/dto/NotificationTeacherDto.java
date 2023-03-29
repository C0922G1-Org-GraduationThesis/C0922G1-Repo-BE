package com.example.be.dto;

public class NotificationTeacherDto {

    private Long notificationTeacherId;
    private String notificationTeacherName;
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
