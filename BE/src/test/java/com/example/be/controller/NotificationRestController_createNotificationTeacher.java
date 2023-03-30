package com.example.be.controller;

import com.example.be.dto.NotificationTeacherDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class NotificationRestController_createNotificationTeacher {
    /**
     * Create by: TuanNDN
     * Date created: 30/03/2023
     */
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;


    @Test
    public void createNotificationTeacher_notificationTeacherName_13() throws Exception {

        NotificationTeacherDto notificationTeacherDto = new NotificationTeacherDto();
        notificationTeacherDto.setNotificationTeacherName(null);
        notificationTeacherDto.setNotificationTeacherContent("abc");

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/notification-teacher/create-notification-teacher")
                        .content(this.objectMapper.writeValueAsString(notificationTeacherDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void createNotificationTeacher_notificationTeacherContent_13() throws Exception {

        NotificationTeacherDto notificationTeacherDto = new NotificationTeacherDto();
        notificationTeacherDto.setNotificationTeacherName("abc");
        notificationTeacherDto.setNotificationTeacherContent(null);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/notification-teacher/create-notification-teacher")
                        .content(this.objectMapper.writeValueAsString(notificationTeacherDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void createNotificationTeacher_notificationTeacherName_14() throws Exception {

        NotificationTeacherDto notificationTeacherDto = new NotificationTeacherDto();
        notificationTeacherDto.setNotificationTeacherName("");
        notificationTeacherDto.setNotificationTeacherContent("abc");

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/notification-teacher/create-notification-teacher")
                        .content(this.objectMapper.writeValueAsString(notificationTeacherDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }




    @Test
    public void createNotificationTeacher_notificationTeacherContent_14() throws Exception {

        NotificationTeacherDto notificationTeacherDto = new NotificationTeacherDto();
        notificationTeacherDto.setNotificationTeacherName("abc");
        notificationTeacherDto.setNotificationTeacherContent("");

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/notification-teacher/create-notification-teacher")
                        .content(this.objectMapper.writeValueAsString(notificationTeacherDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void createNotificationTeacher_20() throws Exception {

        NotificationTeacherDto notificationTeacherDto = new NotificationTeacherDto();
        notificationTeacherDto.setNotificationTeacherName("abc1");
        notificationTeacherDto.setNotificationTeacherContent("abc2");

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/notification-teacher/create-notification-teacher")
                        .content(this.objectMapper.writeValueAsString(notificationTeacherDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }



}
