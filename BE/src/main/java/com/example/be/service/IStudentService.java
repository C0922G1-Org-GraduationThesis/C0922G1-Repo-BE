package com.example.be.service;

import com.example.be.dto.StudentDto;

import java.util.List;

public interface IStudentService {
    /**
     * Created by: NuongHT
     * Date create: 29/03/2023
     */
    List<StudentDto> getInfomation(Long teamId);
}
