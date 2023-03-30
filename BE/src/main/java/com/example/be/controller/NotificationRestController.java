package com.example.be.controller;


import com.example.be.dto.DocumentDto;
import com.example.be.dto.NotificationTeacherDto;
import com.example.be.model.NotificationTeacher;
import com.example.be.model.Teacher;
import com.example.be.repository.INotificationRepository;
import com.example.be.service.IDocumentService;
import com.example.be.service.INotificationService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/notification-teacher")
public class NotificationRestController {

    @Autowired
    private INotificationService notificationService;


    /**
     * Create by: TuanNDN
     * Date created: 29/03/2023
     * Function: show List NotificationTeacher
     *
     * @param 'notificationTeacherName'
     * @param 'notificationTeacherContent'
     * @return HttpStatus.BAD_REQUEST if result is error or HttpStatus. OK if result is not error
     */
    @PostMapping("/create-notification-teacher")
    public ResponseEntity createNotificationTeacher(@RequestBody @Valid  NotificationTeacherDto notificationTeacherDto) {
        if (notificationTeacherDto == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        notificationService.addNotificationTeacher(notificationTeacherDto.getNotificationTeacherName(), notificationTeacherDto.getNotificationTeacherContent());
        return new ResponseEntity<>(HttpStatus.OK);
    }


}

