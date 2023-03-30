
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
public class StudentRestController_save {
    @Autowired
    private MockMvc mockMvc;


    @Autowired
    private ObjectMapper objectMapper;


    @Test
    public void save_name_13() throws Exception {

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
                        .post("/students/create")
                        .content(this.objectMapper.writeValueAsString(studentDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }



    @Test
    public void save_dateOfBirth_14() throws Exception {

        StudentDto studentDto = new StudentDto();
        studentDto.setStudentName("Nguyen Van An");
        studentDto.setStudentCode("sv-002");
        studentDto.setDateOfBirth("");
        studentDto.setStudentGender(true);
        studentDto.setStudentAddress("Huế");
        studentDto.setImg("https://tse2.mm.bing.net/th?id=OIP.13s1lAWEDFjLncZMoGvcNAHaJ7&pid=Api&P=0");
        studentDto.setFlagDelete(false);

        Clazz clazz = new Clazz();
        clazz.setClazzId(2L);
        clazz.setClazzName("C02");

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/students/create")
                        .content(this.objectMapper.writeValueAsString(studentDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }
    @Test
    public void save_dateOfBirth_15() throws Exception {

        StudentDto studentDto = new StudentDto();
        studentDto.setStudentName("Nguyen Van An");
        studentDto.setStudentCode("sv-002");
        studentDto.setDateOfBirth("19/2/2003");
        studentDto.setEmail("123123");
        studentDto.setStudentGender(true);
        studentDto.setStudentAddress("Huế");
        studentDto.setImg("https://tse2.mm.bing.net/th?id=OIP.13s1lAWEDFjLncZMoGvcNAHaJ7&pid=Api&P=0");
        studentDto.setFlagDelete(false);

        Clazz clazz = new Clazz();
        clazz.setClazzId(2L);
        clazz.setClazzName("C02");

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/students/create")
                        .content(this.objectMapper.writeValueAsString(studentDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void save_18() throws Exception {

        StudentDto studentDto = new StudentDto();
        studentDto.setStudentName("Nhat Nam");
        studentDto.setStudentCode("sv-003");
        studentDto.setDateOfBirth("19/02/2003");
        studentDto.setStudentAddress("lequocnhatnam@gmail.com");
        studentDto.setPhoneNumber("09059369245");
        studentDto.setStudentGender(true);
        studentDto.setStudentAddress("đà nẵng");
        studentDto.setImg("https://www.enwallpaper.com/wp-content/uploads/2021/05/15f56a0eb0e2e138702d9ec3bbafadf3.png");
        studentDto.setFlagDelete(false);

        Clazz clazz = new Clazz();
        clazz.setClazzId(2L);
        clazz.setClazzName("C02");

        this.mockMvc
                .perform(MockMvcRequestBuilders
                        .post("/students/create")
                        .content(this.objectMapper.writeValueAsString(studentDto))
                        .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }
}
