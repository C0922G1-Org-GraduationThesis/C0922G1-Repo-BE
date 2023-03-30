package com.example.be.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
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
public class DocumentRestController_deleteDocument {
    /**
     * Create by: TuanNDN
     * Date created: 30/03/2023
     */
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;


    @Test
    public void deleteDocument_25() throws Exception {

        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .delete("/api/document/delete{id}","null"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void deleteDocument_26() throws Exception {

        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .delete("/api/document/delete{id}",""))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void deleteDocument_27() throws Exception {

        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .delete("/api/document/delete{id}","100"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void deleteDocument_28() throws Exception {

        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .delete("/api/document/delete/{id}","3"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

}
