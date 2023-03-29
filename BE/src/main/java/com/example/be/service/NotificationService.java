package com.example.be.service;

import com.example.be.repository.INotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NotificationService implements INotificationService{

    @Autowired
    private INotificationRepository notificationRepository;


    @Override
    public void addNotificationTeacher(String notificationTeacherName, String notificationTeacherTime) {
        notificationRepository.addNotificationTeacher(notificationTeacherName, notificationTeacherTime);
    }


}
