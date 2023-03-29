package com.example.be.service.Impl;

import com.example.be.dto.ProgressDto;
import com.example.be.dto.ProgressStudentDto;
import com.example.be.model.Project;
import com.example.be.model.Student;
import com.example.be.model.Team;
import com.example.be.repository.IStudentRepository;
import com.example.be.service.IProgressService;
import com.example.be.service.IProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class ProgressServiceImpl implements IProgressService {
    @Autowired
    private IProjectService projectService;
    @Autowired
    private IStudentRepository studentRepository;

    /**
     * Created by: VuLX
     * Date created: 29/3/2023
     * Function: create  list-progress
     */

    @Override
    public List<ProgressDto> findAll() {
        List<Project>projectList = projectService.findAll();
        List<ProgressDto>progressDtos = new ArrayList<>();
        for (Project project: projectList) {
            progressDtos.add(new ProgressDto(project.getProjectId(),project.getTeam().getTeamName(), project.getName(),project.getTeam().getMemberOfTeam()));
        }
        return progressDtos;
    }

    /**
     * Created by: VuLX
     * Date created: 29/3/2023
     *
     * Function: find list progress-student by projectId
     */

    @Override
    public List<ProgressStudentDto> findAllStudentOfTeam(Long projectId) {
        List<ProgressStudentDto>progressStudentDtos = new ArrayList<>();
        Project project = projectService.findById(projectId);
        Team team = project.getTeam();
        List<Student>students = studentRepository.findAll();
        for (Student student: students){
            progressStudentDtos.add(new ProgressStudentDto(student.getStudentName(),student.getEmail(),student.getPhoneNumber(),student.getImg()));
        }
        return progressStudentDtos;
    }

    public Project findByProject(Long projectId) {
        return projectService.findById(projectId);
    }
}
