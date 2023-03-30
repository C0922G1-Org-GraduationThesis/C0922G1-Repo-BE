package com.example.be.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class StudentRestController_findById {
    @Autowired
    private MockMvc mockMvc;

//    @Test
//    public void findById_1() throws  Exception {
//        this.mockMvc.perform(
//                        MockMvcRequestBuilders.get(
//                                "students/{studentId}", "null"))
//                .andDo(print())
//                .andExpect(status().is4xxClientError());
//
//    }
@Test
public void findById_1() throws Exception {

    this.mockMvc.perform(
                    MockMvcRequestBuilders
                            .get("/students/{studentId}","null"))
            .andDo(print())
            .andExpect(status().is4xxClientError());
}


    @Test
    public void findById_2() throws Exception {

        this.mockMvc.perform(
                        MockMvcRequestBuilders.get(
                                "/students/{studentId}", ""))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void findById_3() throws Exception {

        this.mockMvc.perform(
                        MockMvcRequestBuilders.get(
                                "/students/{studentId}", "9999999"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void findById_4() throws Exception {

        this.mockMvc.perform(
                        MockMvcRequestBuilders.get(
                                "/students/{studentId}", "1"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpectAll(jsonPath("studentId").value(1))
                .andExpectAll(jsonPath("studentName").value("Lê Đức Minh"))
                .andExpectAll(jsonPath("studentCode").value("sv-001"))
                .andExpectAll(jsonPath("dateOfBirth").value("19/2/2003"))
                .andExpectAll(jsonPath("email").value("leducminh22003@gmail"))
                .andExpectAll(jsonPath("phoneNumber").value("09059469245"))
                .andExpectAll(jsonPath("studentGender").value(true))
                .andExpectAll(jsonPath("studentAddress").value("đà nẵng"))
                .andExpectAll(jsonPath("img").value("http://www.cartoonbucket.com/wp-content/uploads/2015/03/Smiling-Picture-Of-Nobita.jpg"))
                .andExpectAll(jsonPath("flagDelete").value(false));
    }
}
