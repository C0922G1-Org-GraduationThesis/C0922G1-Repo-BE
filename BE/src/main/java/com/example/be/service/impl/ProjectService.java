package com.example.be.service.impl;

import com.example.be.model.Project;
import com.example.be.repository.IProjectRepository;
import com.example.be.service.IProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class ProjectService implements IProjectService {
    @Autowired
    private IProjectRepository projectRepository;

    /**
     * Create by: HauNN
     * Date create: 29/03/2023
     * Function: save project
     *
     * @return  project if result is not error else return null
     * @Param: project
     */
    @Transactional
    @Override
    public Project save(Project project) {
        Project projectOptional = this.projectRepository.findByName(project.getName()).orElse(null);

        if (projectOptional != null) {
            return null;
        }

        return this.projectRepository.saveProject(
                project.getName(),
                project.getContent(),
                project.getDescription(),
                project.getImg());
    }

    /**
     * Create by: HauNN
     * Date create: 29/03/2023
     * Function: find by id project
     *
     * @return project if result is not error else return null
     * @Param: id
     */
    @Override
    public Project findById(Long id) {
        return this.projectRepository.findById(id).orElse(null);
    }

    /**
     * Create by: HauNN
     * Date create: 29/03/2023
     * Function: find all by name project containing
     *
     * @return list page project if result is not error else return null
     * @Param: searchName
     */
    @Override
    public Page<Project> findAllByNameContaining(String searchName, Pageable pageable) {
        return this.projectRepository.findAllByNameContaining(searchName, pageable);
    }
}
