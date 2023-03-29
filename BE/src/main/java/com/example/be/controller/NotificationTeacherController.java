package com.example.be.controller;

import com.example.be.model.NotificationTeacher;
import com.example.be.service.INotificationTeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("api/notification")
public class NotificationTeacherController {
    @Autowired
    private INotificationTeacherService notificationTeacherService;

    @GetMapping("")
    public ResponseEntity<List<NotificationTeacher>> getAllNotificationTeacher() {
        List<NotificationTeacher> notificationTeacherList = this.notificationTeacherService.getAll();
        if (notificationTeacherList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(notificationTeacherList, HttpStatus.OK);
    }
}
