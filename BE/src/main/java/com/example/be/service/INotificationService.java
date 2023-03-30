package com.example.be.service;

import com.example.be.dto.NotificationTeacherDto;
import com.example.be.model.NotificationTeacher;
import org.springframework.data.repository.query.Param;

public interface INotificationService {

    /**
     * Create by: TuanNDN
     * Date created: 29/03/2023
     * Function: show List NotificationTeacher
     *
     * @param 'notificationTeacherName'
     * @param 'notificationTeacherContent'
     */
    void addNotificationTeacher(String notificationTeacherName, String notificationTeacherContent);


}
