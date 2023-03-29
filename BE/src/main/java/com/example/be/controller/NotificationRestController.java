package com.example.be.controller;


import com.example.be.dto.DocumentDto;
import com.example.be.dto.NotificationTeacherDto;
import com.example.be.repository.INotificationRepository;
import com.example.be.service.IDocumentService;
import com.example.be.service.INotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/notification-teacher")
public class NotificationRestController {

    @Autowired
    private INotificationService notificationService;

    @PostMapping("/create-notification-teacher")
    public ResponseEntity createNotificationTeacher(@RequestBody NotificationTeacherDto notificationTeacherDto) {
        if (notificationTeacherDto == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        notificationService.addNotificationTeacher(notificationTeacherDto.getNotificationTeacherName(), notificationTeacherDto.getNotificationTeacherContent());
        return new ResponseEntity<>(HttpStatus.OK);

    }

}
