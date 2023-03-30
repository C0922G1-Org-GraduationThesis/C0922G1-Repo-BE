package com.example.be.controller;

import com.example.be.dto.StudentDto;
import com.example.be.model.Clazz;
import com.example.be.model.Student;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class StudentRestController_updateStudent {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;
    @Test
    public void updateStudent_name_19() throws Exception {
        StudentDto studentDto = new StudentDto();
        studentDto.setStudentName(null);
        studentDto.setStudentCode("sv-002");
        studentDto.setDateOfBirth("2000-10-05");
        studentDto.setStudentGender(true);
        studentDto.setStudentAddress("Huế");
        studentDto.setImg("https://tse2.mm.bing.net/th?id=OIP.13s1lAWEDFjLncZMoGvcNAHaJ7&pid=Api&P=0");
        studentDto.setFlagDelete(false);
        Clazz clazz = new Clazz();
        clazz.setClazzId(1L);
        clazz.setClazzName("C01");
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/students/updateStudent")
                        .content(this.objectMapper.writeValueAsString(studentDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void updateStudent_name_20() throws Exception {
        StudentDto studentDto = new StudentDto();
        studentDto.setStudentName("");
        studentDto.setStudentCode("sv-002");
        studentDto.setDateOfBirth("2000-10-05");
        studentDto.setStudentGender(true);
        studentDto.setStudentAddress("Huế");
        studentDto.setImg("https://tse2.mm.bing.net/th?id=OIP.13s1lAWEDFjLncZMoGvcNAHaJ7&pid=Api&P=0");
        studentDto.setFlagDelete(false);
        Clazz clazz = new Clazz();
        clazz.setClazzId(1L);
        clazz.setClazzName("C01");
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/students/updateStudent")
                        .content(this.objectMapper.writeValueAsString(studentDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void updateStudent_name_21() throws Exception {
        StudentDto studentDto = new StudentDto();
        studentDto.setStudentName("Lê Đức Minh");
        studentDto.setStudentCode("sv-002");
        studentDto.setDateOfBirth("2000-10-05");
        studentDto.setPhoneNumber("09059469245");
        studentDto.setEmail("leducminh");
        studentDto.setStudentGender(true);
        studentDto.setStudentAddress("Huế");
        studentDto.setImg("https://tse2.mm.bing.net/th?id=OIP.13s1lAWEDFjLncZMoGvcNAHaJ7&pid=Api&P=0");
        studentDto.setFlagDelete(false);
        Clazz clazz = new Clazz();
        clazz.setClazzId(1L);
        clazz.setClazzName("C01");
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/students/updateStudent")
                        .content(this.objectMapper.writeValueAsString(studentDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void updateStudent_name_24() throws Exception {
        StudentDto studentDto = new StudentDto();
        studentDto.setStudentName("Lê Nhật Nam");
        studentDto.setStudentCode("sv-002");
        studentDto.setDateOfBirth("2000-10-05");
        studentDto.setPhoneNumber("09059469245");
        studentDto.setEmail("lenhatnam@gmail.com");
        studentDto.setStudentGender(true);
        studentDto.setStudentAddress("Huế");
        studentDto.setImg("https://tse2.mm.bing.net/th?id=OIP.13s1lAWEDFjLncZMoGvcNAHaJ7&pid=Api&P=0");
        studentDto.setFlagDelete(false);
        Clazz clazz = new Clazz();
        clazz.setClazzId(1L);
        clazz.setClazzName("C01");
        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/students/updateStudent")
                        .content(this.objectMapper.writeValueAsString(studentDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }



}
