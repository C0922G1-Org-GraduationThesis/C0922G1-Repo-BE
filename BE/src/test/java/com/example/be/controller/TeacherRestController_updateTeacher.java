package com.example.be.controller;

import com.example.be.dto.TeacherDTO;
import com.example.be.model.Degree;
import com.example.be.model.Faculty;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class TeacherRestController_updateTeacher {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;

    //[item]dateOfBirth = null
    @Test
    public void updateTeacher_19() {
        TeacherDTO teacherDTO = new TeacherDTO();
        teacherDTO.setTeacherName("Kiều Phong");
        teacherDTO.setDateOfBirth(null);
        teacherDTO.setEmail("Kiều Phong phong");
        teacherDTO.setPhoneNumber("0992877338");
        teacherDTO.setTeacherGender(false);
        teacherDTO.setTeacherAddress("Đà Nẵng");
        teacherDTO.setImg("https://bathanh.com.vn/wp-content/uploads/2017/08/default_avatar.png");
        teacherDTO.setDegree(new Degree(2, "Tiến sĩ"));
        teacherDTO.setFaculty(new Faculty(1, "CNTT"));
        try {
            this.mockMvc
                    .perform(MockMvcRequestBuilders
                            .put("/api-teacher/updateTeacher/1")
                            .content(this.objectMapper.writeValueAsString(teacherDTO))
                            .contentType(MediaType.APPLICATION_JSON_VALUE))
                    .andDo(print())
                    .andExpect(status().is4xxClientError());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //    [item]dateOfBirth =  rỗng ("")
    @Test
    public void updateTeacher_20() {
        TeacherDTO teacherDTO = new TeacherDTO();
        teacherDTO.setTeacherName("Kiều Phong");
        teacherDTO.setDateOfBirth("");
        teacherDTO.setEmail("Kiều Phong phong");
        teacherDTO.setPhoneNumber("0992877338");
        teacherDTO.setTeacherGender(false);
        teacherDTO.setTeacherAddress("Đà Nẵng");
        teacherDTO.setImg("https://bathanh.com.vn/wp-content/uploads/2017/08/default_avatar.png");
        teacherDTO.setDegree(new Degree(2, "Tiến sĩ"));
        teacherDTO.setFaculty(new Faculty(1, "CNTT"));
        try {
            this.mockMvc
                    .perform(MockMvcRequestBuilders
                            .put("/api-teacher/updateTeacher/{id}","1")
                            .content(this.objectMapper.writeValueAsString(teacherDTO))
                            .contentType(MediaType.APPLICATION_JSON_VALUE))
                    .andDo(print())
                    .andExpect(status().is4xxClientError());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //[item]phoneNumber sai format
    @Test
    public void updateTeacher_21() {
        TeacherDTO teacherDTO = new TeacherDTO();
        teacherDTO.setTeacherName("Kiều Phong");
        teacherDTO.setDateOfBirth("");
        teacherDTO.setEmail("Kiều Phong phong");
        teacherDTO.setPhoneNumber("0192877338");
        teacherDTO.setTeacherGender(false);
        teacherDTO.setTeacherAddress("Đà Nẵng");
        teacherDTO.setImg("https://bathanh.com.vn/wp-content/uploads/2017/08/default_avatar.png");
        teacherDTO.setDegree(new Degree(2, "Tiến sĩ"));
        teacherDTO.setFaculty(new Faculty(1, "CNTT"));
        try {
            this.mockMvc
                    .perform(MockMvcRequestBuilders
                            .put("/api-teacher/updateTeacher/{id}","1")
                            .content(this.objectMapper.writeValueAsString(teacherDTO))
                            .contentType(MediaType.APPLICATION_JSON_VALUE))
                    .andDo(print())
                    .andExpect(status().is4xxClientError());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //[item] phoneNumber <= minlength (minlength =9)
    @Test
    public void updateTeacher_22() {
        TeacherDTO teacherDTO = new TeacherDTO();
        teacherDTO.setTeacherCode("GV-999");
        teacherDTO.setTeacherName("Đường Bá Hổ");
        teacherDTO.setDateOfBirth("2002-10-10");
        teacherDTO.setEmail("ho@gmail.com");
        teacherDTO.setPhoneNumber("099999999"); //lúc này sdt có 11 số
        teacherDTO.setTeacherGender(true);
        teacherDTO.setTeacherAddress("Quảng Nam");
        teacherDTO.setImg("data:image/jpeg;base64,/9j/4AAQSkZJRgABAQAAAQABAAD/2wCEABsbGxscGx4hIR4qLSgtKj04MzM4PV1CR0JHQl2NWGdYWGdYjX2Xe3N7l33gsJycsOD/2c7Z//////////////8BGxsbGxwbHiEhHiotKC0qPTgzMzg9XUJHQkdCXY1YZ1hYZ1iNfZd7c3uXfeCwnJyw4P/Zztn////////////////CABEIALsBTQMBIgACEQEDEQH/xAAaAAACAwEBAAAAAAAAAAAAAAADBAECBQAG/9oACAEBAAAAAFL3tMzFa9VSkXjuM9RhtvKjpmZmZ6K16beRs0ZknQOvTIKn6euWrzL2Wr09NrVFCKQibtfN8+VbpmIiTHBYlbQZhx82TiR0RxisN5uUJn00+L5tsCVurFptsLjiIsdt3QJl+YpEzezemTLyxO+lnxfMvgWKvXmCRpDW4p7NMXtw/OUkGhJVNWiGbR30k+M5hlMnD6GTnOuS/X6bsvhywUjL1tKuQ3RfNo96KfGz0mm3TToG8e4zM24p275N1AZeo/TKoxGaF/0PeQhsLw6RXmnKLMniTsDyNtk+eueiFzxikMTMA9v95DngsUCOJ0HuqF1IxnQC0SkUxnGpUiuZRs2WB7cjyHNULK1JnTdGGXLdUmkrzJs/Mh5iFRY/PkyBv7VfK9fiEBTp1GwTzlupbSBLVl8cc6d+TxBGsrzLsY8TJrLR3aZidDZeXYapLVZQzQN6NQ52bPDkxu6pgzOd3c+3bi1ckFmTWPEgxE6bJOFmmC3e81QmAEnM7ra5LUOI5V6nYOzFlw5GZstXnKi9rk6qV+XEfNjmNWOkijTFOK8UipFArnUOzOfa9rk6PLd0d1e57RiRCo3DJJeMkYUKUsZWjWUvebkuTD7umadfWPNFZqwG+kRk2Q2c+UG1xlHmR3cTSTzK9MWXLvBmVCRSp+O9qL5jknUQOsUWp2UOZm5/Od3EIrrXFcFyxWzNO1DZ0mYsqhelX9CyuNE8yktbombNgDSzFo6x4qZ/NY5hjOUky2uVoWbmd3QSZ6VZZCGhy91ZLbh1avx4opd3L0zNyphi5cGvaZ5Mt4KoQlJirXRQbnFlR0FjZmrGjTPRRquN289IdRcrSNCU61GbVAe95GvpTSVNEGmvjt5AQ1D09JNlZthKk06xBmlUpDQDnijoJkTwMzS853U//8QAFwEBAQEBAAAAAAAAAAAAAAAAAAECA//aAAoCAhADEAAAAFgFM6FlQ3lAAsjcxbKDG5VXNTpi5QllrWc61mWwrLO87zqajWdY1jUgl1NTnreSCpZcdM6zvWKTOt89YsVNTF6TJbDGprO4zuw1m5xuzryQ0y1KioxvG5c7LZN41zzvN1OvIrKwKOXaW4x0tmmdYud549jrxsCygl5dSyazqXWLCUl68rA1kDn0ztLCVFlrKyt4sI1CJrOlkVFSaohLLNZsM6LM6WJaEUWEQ3I3ioU57BUVFQAjUNZr/8QANxAAAgECBQMCBAMIAQUAAAAAAQIAAxEEEiExURATQSJhFDJScSBygQUjM0JikaGxJENjk8HR/9oACAEBAAE/AA6QMkBWC0sOJYcSw4hA4htxNOJpxDbiHDgA+okcQjTLsOIq6wEKRfSFFZywBInbAS259toSFJFrREJ9JbUzKMpBA1gW2wERfYSiq510EqU1dGFhtCo4lhxLDiWHEsOBLLxLLxAF4ll4ll4ll4ELIOIalMcQ16Q4gr0vaCtS9pmT2mZuTA7/AFGI1SCuwOsWspE7gncENUQ1BO4JnEziBg1xGm2stfUa35jFUtoYvq24iWBKgGIMtzzzGfQIDpFveLciUEbOCemKAp1TwwvO4J3FncWdxZnEDgzMBDVUTv5jYSr3LemP3vLGOXvqxlzKIzVFEGEQgT4Phj0EpG4hUGPembifEz4ifECd8TvLO+IKwlGqO6kqqoOkMV8otMyt/MAfeZ1A1hqL4uZndtyIoJ8xAYgMpDp+1Gy9k+xjYgCDEgz4kQ4mfFT4siU8V3GtKmkw9MWvCBaVzqZUOpl5hNaywbfgomCYgemWMKWEG3XKZYyiclamTsGEdbwqBLQiwudBPfKf9f7l1+pP8tBf+r9KcTuHZX/8cR6o3T+6sJRxCncH/cR1IuCDAwn7YW9GieGaMDCCIFa8YQKTDSNwAN4aT0SrQHOlzMNpTEdrCVTe8qHU9MDrXWDb8FPS0XaYggLER8ugi0Wb5o65WIm0VSxsIKT2gpNadknxEuyLfe0amRvGYeP/AL/YQUqrG4GX33aLhF3YFvuYKaroCB9oEF9SZSCgTN7xEVzqAY1Jt0YX4bURMQAwSoMj8HY/Yz9pa4ZfapGpkmGk5MKFBciZgTeYSmtRTGw9VW9MGGepq8N6bMko6U1lV48qfN0wH8YQfgBAAgroF3lSoXa8XEMotafFVIc7G8yvxFLIb2gxXKxcRSPmBlbYxDYGVHLEINzEQJtv5Jl+WMCqfJMtYwiLUAFr2i1EP8xMp10UgZTEYOLiYmgK1JhbUaiCqz0Wpu3BQmVKL07Zl3ijWYkfujFXSYDY9CbCYkeovKNUMgjmNrKg9R6YD+N+HWBSYMOxW94lHNfWCgvM7YHmZT9UKk+YtBnOhjYeoviAuh8iYbEMS4bwhMw93L1TuTYfYR6qqbWvMznZYgeWgQtpEocwpSS2YgH3MpZPFoLDbphUBDXFym0q65QRfS/94aRNyolYFkK+YBbSYH5TLxjoZXNwVlEMrWG0aAXlcWc9MB/F6m0vAoyTUtF0SYc3LxmsxEzTNM0wupPRqSNusOFKFmTUWN5g9aIHBMFMFto1WlT03iVVaAiUxKtTIGIlQ1hUFra6i/mfDqoQqSrt4lMm1m6IMleoPDG8WqtRmvuTp0emr7j9ZXwv6cNMNTNNLHodpiL5zMPVI9JEMUaSupzmWmAH77pfqNUifPKh0AlD0uRKptUaZpeXmC2fq1UIbbmYU2aqvveOSENo9FKtIjOFddgfMVKVGllDZjwNbRCcqlhYyg4NxK9MtmEpK4sM7C0pKqgncncmA3Ok8TEEIjvb1N6QYZRr3sr/AKHpoRYx0NPVdVl7xjKxHcET+LANZayyq3qMuJgP4v4UqemBrPeNUBZZmtUvKhu7dRMF8r9HfLoPmMAlMZawPItDAqkbTKI8w988KBhGQA7QEynt0xpJCjwDD0oVc3obfoY69s3AuplT0/Y7Su13lFvXcxaixqq5TKhJY2ljMCctQkzuLzO4vPVYN5liixF4/wA56iYH5X+8dwi38+BAp1J3Mt0UBwDLW6VGUaSj84j1clha947WaKLxR0QCuK4bYuQP0lRGR2VhqOl8pBlN86BumUEEGOmS6N8h88TEoUdgdxEgh2hOsvMONelplPEsRAG4guDtCGABjNexhNyfwYDRKhMuXbMf0HXLmIEQgNlm/RqYJYkyiFusqFwqhEBPJ8SoCwHMpwSpolvJIUfqZStlYjyzGYxM6d0bqbGCV3sswVbNb3hYCZySbGw5js7XXQiYpM1MN5Tf3WBrTNC8tLSnUyT4ifEQFJUKRChAlcKNpSBcazEKAn4cPft5eTBBr0pDcyqxUq0Rw6hhsYYTrAxGt5Qe4h3i2gj6LfjUffYRRlpgDiKpZnpuNHUxwUYqdwbTENpMI5V7QetcxOsayp7CU9ix0G0cDRyPTs32Mp0QlSojfysRDTSIlM1DBSpQUqUFClwIaFKDD0oKaztLDSXxKqWG8oHSV9UP4FUsQBKSgC00B0lgV03hvbWJoglZly3I+0pm1k9odRHdV3vBVQ+DEqgCyAwGudARERl+ZrmCPYsic+oxyFWLUAOm99bzFUsOXBcMC/kTFYCqRno2qr7bxFYMPBBlB7gofMKs9t8o/wAx1XIoseLCOl6RFgNNpUUtUVh5QX+40naY7mDDgeYKP9UFA/VBQP1RqDfVBRf6oGEzCFhKzArKTWjkFD+DDrd78CItoB9QgBU2PmNqbCVnCAKN5iH9aLwREa7KbXOaZ1LECMoaCkJTCqdou0EFgCTsJh2NarUreDosrm0XUzHP6aHs9oCym6sQY+Wsi95FJI0YaNGosmqNe0pYsPa/Ezi2kLXB+0OhT7GAiCC0EBjGCZ25md+ZnbmFidzLmZm5/BhBo56W13hO8DhWDQsWcE8xrtWUcmU8yvU5tM+QgjeB1a3v0XeUyLRZja+1FfO8w4enTsLX95V77H1L/aIptciY/wDhJ+cdCdEPtaIAbGVKKVCSPS48iLVekctRYaqmmSDMVUKuqjwgvO/UgxFSDEvBi3gxrQYmo+ymB630dbS0tCLDqlN6jBUUkxMMcOoBNyYJrxKhAFp8xv48QCbVQeBKban0/rCIp0sZQtWQG9mGhhTti7MJQps92bRfEq5l2E075c62P+YueobnaAAaC5MtcaiftAehPziDYQgmmw41mHcZrcyr6KhIlJUxCkEX5Eq4Nk9VL1qN18iNQZ2ZmbUm5nw3vPhj9U+FP1T4VuYmGsyltQCCRMZX7zo1JLWEzv7w0xMsAmUWiLcyqll6UaL13CIJRp0sKoVdWO5j1TVY8DaKYzhYzF2lujb/AKRLhxMh3gpygTTqDhtDEpGvV9XyLvLgC0xNbt0i3nZZSUeTtMx0ttEq019IJJi1QZjwTTEWUiM1jATSqW4Mxds4I8iUHKVVIlS91qJK2FFUZgMryoj02KuLH8IBBBIME7hmczMZnMo6mVh6YFJIAlFTRplRud5VNrD2imxgdQNd4zlzYRB1YaiJTBbe0bYDxLdMNVXsqB43hqcTEMXq5SflEQMBr58RWObwAICDudIWOmRbjSxExrE3HFhE+YQHK8xQtUDcgGVTmWm36TCU1Wk1XKCxNheUwrqrASpm0AlZBWUod/5TGBBIO4/BicQa6rpYgWi1Kii1iZ2J2BOxOxEoFTKibXlGkpcESoLVGHBEqasTCYSTALRR0EfaLFtaxhGvSg+WqFOzx2SkjOfAlK7ks27G5l76S4WIbjXzvFyKC0JNUVG/qEGjRzZjMRTbsUydx/7iG62iKFo08uwOv6yg3qZeRfoyZ9tOTMdR2rLsd+l+l4WEtLS0tLTFelJgTmLH3Eb1VKn5ow1MKwDWAQCw6eZV0VpT2msBuOlQHKbbjaPiWxRprsAPVKYtHPEF2VYotfWV3yUj9TaCYcXoP+dZUXK5lZfSjciVvWHXlP8AQvKe5Epk/D1B7rKZy1V+9o5ssUWUSnZgaTaqwMrIaTsh8GXhMeoYXN5b8ONH7qYJMlBD9TExNWrezmAXaVaHpDCFNYJ4nnpVF0f8plPQj3EAlpaMdDeYdN25M2Gm8VTe5gAAsJ5ldy7+y6CYQXoN+eYhbPAuejl8iAf8lFPlF/yLRAVqETDrenVHtL2JPBBhF7Qt++twkzKFzMfTrMbqaLEb05YQgRxLQYqDEifFLPil4gxSTE1VqoFXcmMoQKg2VQJfLXqjmzSkmZjCpysORGXWWnjqdYEOQEeIhzKDBY7Riw2sRK+uVBoWMWyrAby/So+VSYFsJgh+6f8APMQl9ZTFqd/eVtMUjf8AaB/sZXXLinHvMNsw9puT+WIfQD7RDmrufaFs/bpe5YzH4Tu0qBDBcmkOAq+Kyw4PEjyIcNiBuJ2a3EOjMBzLmXMuZcyj/GpfnEdmzHWVGPdT8glBjrCzcxmN5cwMbS5lzMxgY5G18ymxynXzAxmY3Mue+32mY8ymxudYWPMLNzKjEldYWNt5hXYUjr/NGdrHWKzdp9ZVds9HX/pNMQxNdD/QJhnbNvMzZjr4gdxS38Sg7Z218SgT3WmOYnCVP0hZuTA7/UZ3H+owu/1Gf//EAB8RAAICAgMBAQEAAAAAAAAAAAABEBECICEwMUFREv/aAAgBAgEBPwCuiy+qtEUiikZaNicUUcDhaPTkcPJlsoSPBMWi1ubHTH6NwrZ4PwXAsoULpbGf1HktQnQuRi6G+nJfYwdPqbtuENao4aKi9KKKjLxyhyi4tl3CTpFTemWV6sSGVqnpaLUZP5FdD1Wq9H72/kJ8zRRXTUIqfwUWf//EACARAAICAgMBAQEBAAAAAAAAAAABEBECMCAhMVFBEnH/2gAIAQMBAT8AvRSKl78Z6+lL6PFj4LXiULFHRaGx9jQ+D0ULpiuhf7DpHqF6Myw+a1CX6I/nuxHUrKGrH1qSuPBQhjjF/kZK1erxJCH2xOKHDR2mOGqb0Y+oYoQmWNy0meCMvXoxVOHwbMfrL5WXFFRiob4v2KFxfFi81PjlN7EN8Po5/9k=");
        teacherDTO.setDegree(new Degree(1, "Thạc sĩ"));
        teacherDTO.setFaculty(new Faculty(2, "QTKD"));

        try {
            this.mockMvc
                    .perform(MockMvcRequestBuilders
                            .post("/api-teacher/createTeacher")
                            .content(this.objectMapper.writeValueAsString(teacherDTO))
                            .contentType(MediaType.APPLICATION_JSON_VALUE))
                    .andDo(print())
                    .andExpect(status().is4xxClientError());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //[item] không >= maxlength (maxlength =11)
    @Test
    public void updateTeacher_23() {
        TeacherDTO teacherDTO = new TeacherDTO();
        teacherDTO.setTeacherName("Đường Bá Hổ");
        teacherDTO.setDateOfBirth("2002-10-10");
        teacherDTO.setEmail("ho@gmail.com");
        teacherDTO.setPhoneNumber("09999999999"); //lúc này sdt có 11 số
        teacherDTO.setTeacherGender(true);
        teacherDTO.setTeacherAddress("Quảng Nam");
        teacherDTO.setImg("data:image/jpeg;base64,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");
        teacherDTO.setDegree(new Degree(1, "Thạc sĩ"));
        teacherDTO.setFaculty(new Faculty(2, "QTKD"));

        try {
            this.mockMvc
                    .perform(MockMvcRequestBuilders
                            .post("/api-teacher/createTeacher")
                            .content(this.objectMapper.writeValueAsString(teacherDTO))
                            .contentType(MediaType.APPLICATION_JSON_VALUE))
                    .andDo(print())
                    .andExpect(status().is4xxClientError());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //All [item] đều hợp lệ
    @Test
    public void updateTeacher_24() {
        TeacherDTO teacherDTO = new TeacherDTO();
        teacherDTO.setTeacherName("Kiều Phong phong");
        teacherDTO.setDateOfBirth("2023-03-10");
        teacherDTO.setEmail("Kiều Phong phong");
        teacherDTO.setPhoneNumber("0992877338");
        teacherDTO.setTeacherGender(false);
        teacherDTO.setTeacherAddress("Đà Nẵng");
        teacherDTO.setImg("https://bathanh.com.vn/wp-content/uploads/2017/08/default_avatar.png");
        teacherDTO.setDegree(new Degree(2, "Tiến sĩ"));
        teacherDTO.setFaculty(new Faculty(1, "CNTT"));
        try {
            this.mockMvc
                    .perform(MockMvcRequestBuilders
                            .put("/api-teacher/updateTeacher/1")
                            .content(this.objectMapper.writeValueAsString(teacherDTO))
                            .contentType(MediaType.APPLICATION_JSON_VALUE))
                    .andDo(print())
                    .andExpect(status().is2xxSuccessful());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
