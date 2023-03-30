package com.example.be.controller;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.test.web.servlet.MockMvc;

import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class TeacherRestController_getTeacher {
    @Autowired
    private MockMvc mockMvc;
//[id] = null
    @Test
    public void getTeacher_1() throws Exception{
        this.mockMvc.perform(
                MockMvcRequestBuilders.get("/api-teacher/detailTeacher/{id}","null"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    //[id] = rỗng ("")
    @Test
    public void getTeacher_2() throws Exception{
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/api-teacher/detailTeacher/{id}",""))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    //[id] không tồn tại trong DB
    @Test
    public void getTeacher_3() throws Exception{
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/api-teacher/detailTeacher/{id}","123"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
//[id] tồn tại trong DB
    @Test
    public void getTeacher_4() throws Exception{
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/api-teacher/detailTeacher/{id}","2"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }


}
