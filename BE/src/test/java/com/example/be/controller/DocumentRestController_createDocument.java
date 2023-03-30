package com.example.be.controller;

import com.example.be.dto.DocumentDto;
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
public class DocumentRestController_createDocument {
    /**
     * Create by: TuanNDN
     * Date created: 30/03/2023
     */
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void createDocument_documentDescribe_13() throws Exception {

        DocumentDto documentDto = new DocumentDto();
        documentDto.setDocumentDescribe(null);
        documentDto.setDocumentFile("abc");
        documentDto.setDocumentName("abc");

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/document/create-document")
                        .content(this.objectMapper.writeValueAsString(documentDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void createDocument_documentName_13() throws Exception {

        DocumentDto documentDto = new DocumentDto();
        documentDto.setDocumentDescribe("abc");
        documentDto.setDocumentFile("abc");
        documentDto.setDocumentName(null);

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/document/create-document")
                        .content(this.objectMapper.writeValueAsString(documentDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void createDocument_documentDescribe_14() throws Exception {

        DocumentDto documentDto = new DocumentDto();
        documentDto.setDocumentDescribe("");
        documentDto.setDocumentFile("abc");
        documentDto.setDocumentName("abc");

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/document/create-document")
                        .content(this.objectMapper.writeValueAsString(documentDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void createDocument_documentName_14() throws Exception {

        DocumentDto documentDto = new DocumentDto();
        documentDto.setDocumentDescribe("abc");
        documentDto.setDocumentFile("abc");
        documentDto.setDocumentName("");

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/document/create-document")
                        .content(this.objectMapper.writeValueAsString(documentDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void createDocument_20() throws Exception {

        DocumentDto documentDto = new DocumentDto();
        documentDto.setDocumentDescribe("abc");
        documentDto.setDocumentFile("abc");
        documentDto.setDocumentName("abc");

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/api/document/create-document")
                        .content(this.objectMapper.writeValueAsString(documentDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }


}
