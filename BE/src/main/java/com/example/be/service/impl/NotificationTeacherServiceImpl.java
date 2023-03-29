package com.example.be.service.impl;

import com.example.be.model.NotificationTeacher;
import com.example.be.repository.INotificationTeacherRepository;
import com.example.be.service.INotificationTeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class NotificationTeacherServiceImpl implements INotificationTeacherService {
    @Autowired
    private INotificationTeacherRepository notificationTeacherRepository;
    @Override
    public List<NotificationTeacher> getAll() {
        return this.notificationTeacherRepository.getAllNotificationTeacher();
    }
}
