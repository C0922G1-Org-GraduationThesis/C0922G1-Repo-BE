package com.example.be.service;

import com.example.be.model.Project;
import com.example.be.repository.IProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
/**
 * SyVT
 */
@Service
public class ProjectService implements IProjectService {
    @Autowired
    private IProjectRepository projectRepository;

    @Override
    public List<Project> findAll() {
        return projectRepository.findAll();
    }

    @Override
    public Project findById(Long id) {
        return projectRepository.findById(id).get();
    }

    @Override
    public void save(Project project) {
        projectRepository.save(project);
    }

    @Override
    public void delete(Long id) {
        projectRepository.deleteById(id);
    }
}
