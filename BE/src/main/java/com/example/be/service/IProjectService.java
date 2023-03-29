package com.example.be.service;

import com.example.be.model.Project;
import org.springframework.data.repository.query.Param;

public interface IProjectService {

    void updatePro(Long projectId);

    void updatePro2(Long projectId);

    Project findProById(Long projectId);
}
