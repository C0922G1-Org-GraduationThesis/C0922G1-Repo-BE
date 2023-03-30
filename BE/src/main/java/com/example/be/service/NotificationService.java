package com.example.be.service;

import com.example.be.dto.NotificationTeacherDto;
import com.example.be.model.NotificationTeacher;
import com.example.be.repository.INotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NotificationService implements INotificationService{

    @Autowired
    private INotificationRepository notificationRepository;

    /**
     * Create by: TuanNDN
     * Date created: 29/03/2023
     * Function: show List NotificationTeacher
     *
     * @param 'notificationTeacherName'
     * @param 'notificationTeacherContent'
     */
    @Override
    public void addNotificationTeacher(String notificationTeacherName, String notificationTeacherContent) {
        notificationRepository.addNotificationTeacher(notificationTeacherName, notificationTeacherContent);
    }




}
