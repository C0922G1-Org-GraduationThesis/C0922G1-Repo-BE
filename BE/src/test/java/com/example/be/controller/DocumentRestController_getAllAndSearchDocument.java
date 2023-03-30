package com.example.be.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
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
public class DocumentRestController_getAllAndSearchDocument {
    /**
     * Create by: TuanNDN
     * Date created: 30/03/2023
     */
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void getAllAndSearchDocument_5() throws Exception {

        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/document?keySearch1=9999"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void getAllAndSearchDocument_6() throws Exception {

        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/api/document?page=0"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("content[0].documentName").value("Kho đồ án tốt nghiệp-khóa luận tốt nghiệp-Đồ án môn học.pdf "))
                .andExpect(jsonPath("content[0].documentDescribe").value("Kho đồ án tốt nghiệp-khóa luận tốt nghiệp-Đồ án môn học.pdf "))
                .andExpect(jsonPath("content[0].documentId").value(1))
        ;

    }


}
