package com.example.be.service;

import com.example.be.model.Project;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface IProjectService {
    /**
     * Create by: HauNN
     * Date create: 29/03/2023
     * Function: save project
     *
     * @return  project if result is not error else return null
     * @Param: project
     */
    Project save(Project project);

    /**
     * Create by: HauNN
     * Date create: 29/03/2023
     * Function: find by id project
     *
     * @return project if result is not error else return null
     * @Param: id
     */
    Project findById(Long id);

    /**
     * Create by: HauNN
     * Date create: 29/03/2023
     * Function: find all by name project containing
     *
     * @return list page project if result is not error else return null
     * @Param: searchName
     */
    Page<Project> findAllByNameContaining(String searchName, Pageable pageable);
}
