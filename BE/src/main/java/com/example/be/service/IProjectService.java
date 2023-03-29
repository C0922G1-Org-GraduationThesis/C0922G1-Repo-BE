package com.example.be.service;


import com.example.be.model.Project;

import java.util.List;

public interface IProjectService {
    List<Project> findAll();

    Project findById(Long id);

    void save(Project project);

    void delete(Long id);
}
