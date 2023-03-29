package com.example.be.service;

import com.example.be.model.Project;

public interface IProjectService {
    void updatePro(Long projectId);

    void updatePro2(Long projectId);

    Project findProById(Long projectId);
}
