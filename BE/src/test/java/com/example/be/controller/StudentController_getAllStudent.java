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
public class StudentController_getAllStudent {

    @Autowired
    private MockMvc mockMvc;

    /**
     * This function use to test list student of field search is "null", page = 0
     *
     * @Author: VinhLD
     * @Date: 30/3/2023
     */
    @Test
    public void getAllStudent_7() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/student?nameSearch=null&page=0"))
                .andDo(print())
                .andExpect(status().is4xxClientError());

    }

    /**
     * This function use to test list student of field search is "", page = 0
     *
     * @Author: VinhLD
     * @Date: 30/3/2023
     */
    @Test
    public void getAllStudent_8() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/students?nameSearch=&page=0"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("totalPages").value(2))
                .andExpect(jsonPath("totalElements").value(10))
                .andExpect(jsonPath("content[0].studentId").value(1))
                .andExpect(jsonPath("content[0].studentCode").value("MSV-100"))
                .andExpect(jsonPath("content[0].studentName").value("Phạm Thị Vi"))
                .andExpect(jsonPath("content[0].studentImg").value("anh_the_cua_vi.png"))
                .andExpect(jsonPath("content[0].studentEmail").value("phamthivi2003@gmail.com"))
                .andExpect(jsonPath("content[0].studentPhoneNumber").value("0968584584"))
                .andExpect(jsonPath("content[0].nameClazz").value("C0722G1"))
                .andExpect(jsonPath("content[4].studentId").value(6))
                .andExpect(jsonPath("content[4].studentCode").value("MSV-009"))
                .andExpect(jsonPath("content[4].studentName").value("Mai Thị Hồng"))
                .andExpect(jsonPath("content[4].studentImg").value("anh_the_cua_hong.png"))
                .andExpect(jsonPath("content[4].studentEmail").value("maithihong@gmail.com"))
                .andExpect(jsonPath("content[4].studentPhoneNumber").value("0494723647"))
                .andExpect(jsonPath("content[4].nameClazz").value("C0822G1"));
    }


    /**
     * This function use to test list student of field search is "abcdef", page = 0
     *
     * @Author: VinhLD
     * @Date: 30/3/2023
     */

    @Test
    public void getAllStudent_9() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/students?nameSearch=abcdef&page=0"))
                .andDo(print())
                .andExpect(status().is4xxClientError());

    }
/**
 * This function use to test list student of field search is "@@@@@@@@@", page = 0
 *
 * @Author: VinhLD
 * @Date: 30/3/2023
 */

@Test
public void getAllStudent_nameSearch_9() throws Exception {
    this.mockMvc.perform(MockMvcRequestBuilders.get("/students?nameSearch=@@@@@@@@@&page=0"))
            .andDo(print())
            .andExpect(status().is4xxClientError());

}

    /**
     * This function use to test list student of field search is "Nguyễn Mai Anh" but flag_delete=true, page = 0
     *
     * @Author: VinhLD
     * @Date: 30/3/2023
     */

    @Test
    public void getAllStudent_10() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/students?nameSearch=Nguyễn Mai Anh&page=0"))
                .andDo(print())
                .andExpect(status().is4xxClientError());

    }


    /**
     * This function use to test list student of field search is "V", page = 0
     *
     * @Author: VinhLD
     * @Date: 30/3/2023
     */

    @Test
    public void getAllStudent_11() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/students?nameSearch=V&page=0"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("totalPages").value(1))
                .andExpect(jsonPath("totalElements").value(2))
                .andExpect(jsonPath("content[0].studentId").value(1))
                .andExpect(jsonPath("content[0].studentCode").value("MSV-100"))
                .andExpect(jsonPath("content[0].studentName").value("Phạm Thị Vi"))
                .andExpect(jsonPath("content[0].studentImg").value("anh_the_cua_vi.png"))
                .andExpect(jsonPath("content[0].studentEmail").value("phamthivi2003@gmail.com"))
                .andExpect(jsonPath("content[0].studentPhoneNumber").value("0968584584"))
                .andExpect(jsonPath("content[0].nameClazz").value("C0722G1"))
                .andExpect(jsonPath("content[1].studentId").value(10))
                .andExpect(jsonPath("content[1].studentCode").value("MSV-123"))
                .andExpect(jsonPath("content[1].studentName").value("Phan Thị Hồng Vy"))
                .andExpect(jsonPath("content[1].studentImg").value("anh_the_cua_hong_vi.png"))
                .andExpect(jsonPath("content[1].studentEmail").value("phanthihongvi@gmail.com"))
                .andExpect(jsonPath("content[1].studentPhoneNumber").value("0474793937"))
                .andExpect(jsonPath("content[1].nameClazz").value("C0722G1"));
    }


}
