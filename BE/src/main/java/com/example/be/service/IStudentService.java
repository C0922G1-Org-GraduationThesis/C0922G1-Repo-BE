package com.example.be.service;


import com.example.be.dto.StudentDto;
import com.example.be.model.Student;
import com.example.be.model.Team;

import java.util.List;

public interface IStudentService {

    /**
     * Created by: NuongHT
     * Date create: 29/03/2023
     */
    List<StudentDto> getInfomation(Long teamId);
}
