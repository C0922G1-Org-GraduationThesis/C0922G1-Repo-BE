package com.example.be.service.impl;

import com.example.be.model.Project;
import com.example.be.repository.IProjectRepository;
import com.example.be.service.IProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ProjectServiceImpl implements IProjectService {
    @Autowired
    private IProjectRepository projectRepository;
    @Override
    public Page<Project> getAllProject(Pageable pageable, String name) {
        return this.projectRepository.getAllProject(pageable, name);
    }
}
