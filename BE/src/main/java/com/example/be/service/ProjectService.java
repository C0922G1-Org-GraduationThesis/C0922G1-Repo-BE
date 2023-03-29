package com.example.be.service;

import com.example.be.model.Project;
import com.example.be.repository.IProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class ProjectService implements IProjectService {
    @Autowired
    private IProjectRepository iProjectRepository;

    /**
     * Created by: NuongHT
     * Date create: 29/03/2023
     */
    @Override
    @Transactional
    public void updatePro(Long projectId) {
        iProjectRepository.updatePro(projectId);
    }

    /**
     * Created by: NuongHT
     * Date create: 29/03/2023
     */
    @Override
    @Transactional
    public void updatePro2(Long projectId) {
        iProjectRepository.updatePro2(projectId);
    }

    /**
     * Created by: NuongHT
     * Date create: 29/03/2023
     */
    @Override
    public Project findProById(Long projectId) {
        return iProjectRepository.findProById(projectId);
    }
}
