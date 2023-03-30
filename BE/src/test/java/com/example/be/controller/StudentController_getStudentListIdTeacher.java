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
public class StudentController_getStudentListIdTeacher {


    @Autowired
    private MockMvc mockMvc;

    /**
     * This function use to test the instructor's student list of teacherId=null
     *
     * @Author: VinhLD
     * @Date: 30/3/2023
     */
    @Test
    public void getStudentListIdTeacher_1() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/student/list-id-teacher/null"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }


    /**
     * This function use to test the instructor's student list of teacherId=""
     *
     * @Author: VinhLD
     * @Date: 30/3/2023
     */
    @Test
    public void getStudentListIdTeacher_2() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/student/list-id-teacher/"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * This function use to test the instructor's student list of teacherId="287263"
     *
     * @Author: VinhLD
     * @Date: 30/3/2023
     */
    @Test
    public void getStudentListIdTeacher_3() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/student/list-id-teacher/287263"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }


    /**
     * This function use to test the instructor's student list of teacherId="1" or field search is "null", page = 0
     *
     * @Author: VinhLD
     * @Date: 30/3/2023
     */
    @Test
    public void getStudentListIdTeacher_4_7() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("http://localhost:8080/students/list-id-teacher/1?nameSearch=null&page=0"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }



    /**
     * This function use to test the instructor's student list of teacherId="1" or field search is "", page = 0
     *
     * @Author: VinhLD
     * @Date: 30/3/2023
     */
    @Test
    public void getStudentListIdTeacher_4_8() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("http://localhost:8080/students/list-id-teacher/1?nameSearch=&page=0"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("totalPages").value(2))
                .andExpect(jsonPath("totalElements").value(7))
                .andExpect(jsonPath("content[0].idStudent").value(1))
                .andExpect(jsonPath("content[0].codeStudent").value("MSV-100"))
                .andExpect(jsonPath("content[0].nameStudent").value("Phạm Thị Vi"))
                .andExpect(jsonPath("content[0].imgStudent").value("anh_the_cua_vi.png"))
                .andExpect(jsonPath("content[0].emailStudent").value("phamthivi2003@gmail.com"))
                .andExpect(jsonPath("content[0].phoneNumberStudent").value("0968584584"))
                .andExpect(jsonPath("content[0].nameClazz").value("C0722G1"))
                .andExpect(jsonPath("content[0].nameTeacher").value("Lê Thị Thu Minh"))
                .andExpect(jsonPath("content[4].idStudent").value(7))
                .andExpect(jsonPath("content[4].codeStudent").value("MSV-019"))
                .andExpect(jsonPath("content[4].nameStudent").value("Nguyễn Thị Mai"))
                .andExpect(jsonPath("content[4].imgStudent").value("anh_the_cua_mai.png"))
                .andExpect(jsonPath("content[4].emailStudent").value("nguyenthimai@gmail.com"))
                .andExpect(jsonPath("content[4].phoneNumberStudent").value("0494725647"))
                .andExpect(jsonPath("content[4].nameClazz").value("C0722G1"))
                .andExpect(jsonPath("content[4].nameTeacher").value("Lê Thị Thu Minh"));
    }


    /**
     * This function use to test the instructor's student list of teacherId="1" or field search is "abcdef", page = 0
     *
     * @Author: VinhLD
     * @Date: 30/3/2023
     */

    @Test
    public void getStudentListIdTeacher_4_9() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("http://localhost:8080/students/list-id-teacher/1?nameSearch=abcdef&page=0"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }


    /**
     * This function use to test the instructor's student list of teacherId="1" or field search is "@@@@@@@", page = 0
     *
     * @Author: VinhLD
     * @Date: 30/3/2023
     */

    @Test
    public void getStudentListIdTeacher_4_9_1() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("http://localhost:8080/students/list-id-teacher/1?nameSearch=@@@@@@@&page=0"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }


    /**
     * This function use to test the instructor's student list of teacherId="3" or field search is "Nguyễn Mai Anh" but flag_delete= true, page = 0
     *
     * @Author: VinhLD
     * @Date: 30/3/2023
     */

    @Test
    public void getStudentListIdTeacher_4_10() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("http://localhost:8080/students/list-id-teacher/3?nameSearch=Nguyễn Mai Anh&page=0"))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    /**
     * This function use to test the instructor's student list of teacherId="1" or field search is "Lan", page = 0
     *
     * @Author: VinhLD
     * @Date: 30/3/2023
     */


    @Test
    public void getStudentListIdTeacher_4_11() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("http://localhost:8080/students/list-id-teacher/1?nameSearch=Lan&page=0"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("totalPages").value(1))
                .andExpect(jsonPath("totalElements").value(2))
                .andExpect(jsonPath("content[0].idStudent").value(3))
                .andExpect(jsonPath("content[0].codeStudent").value("MSV-101"))
                .andExpect(jsonPath("content[0].nameStudent").value("Lê Thị Lan Anh"))
                .andExpect(jsonPath("content[0].imgStudent").value("anh_the_cua_lan_anh.png"))
                .andExpect(jsonPath("content[0].emailStudent").value("lananh2002@gmail.com"))
                .andExpect(jsonPath("content[0].phoneNumberStudent").value("0968584576"))
                .andExpect(jsonPath("content[0].nameClazz").value("C0822G1"))
                .andExpect(jsonPath("content[0].nameTeacher").value("Lê Thị Thu Minh"))
                .andExpect(jsonPath("content[1].idStudent").value(11))
                .andExpect(jsonPath("content[1].codeStudent").value("MSV-089"))
                .andExpect(jsonPath("content[1].nameStudent").value("Nguyễn Thị Lan"))
                .andExpect(jsonPath("content[1].imgStudent").value("anh_the_cua_lan.png"))
                .andExpect(jsonPath("content[1].emailStudent").value("nguyenthilan@gmail.com"))
                .andExpect(jsonPath("content[1].phoneNumberStudent").value("0936372536"))
                .andExpect(jsonPath("content[1].nameClazz").value("C0822G1"))
                .andExpect(jsonPath("content[1].nameTeacher").value("Lê Thị Thu Minh"));
    }

}
