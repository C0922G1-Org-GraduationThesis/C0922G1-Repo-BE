package com.example.be.service;

import com.example.be.model.Project;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IProjectService {
    Page<Project> getAllProject(Pageable pageable, String name);
}
