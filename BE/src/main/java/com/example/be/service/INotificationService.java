package com.example.be.service;

import org.springframework.data.repository.query.Param;

public interface INotificationService {

    void addNotificationTeacher(String notificationTeacherName, String notificationTeacherTime);
}
