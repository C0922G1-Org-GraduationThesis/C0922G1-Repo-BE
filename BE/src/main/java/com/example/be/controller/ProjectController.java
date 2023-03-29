package com.example.be.controller;

import com.example.be.model.Project;
import com.example.be.service.IProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("api/project")
public class ProjectController {
    @Autowired
    private IProjectService projectService;

    @GetMapping("")
    public ResponseEntity<Page<Project>> pagingAndGetAllProject(
            @RequestParam(defaultValue = "", required = false) String name) {
        Pageable pageable = PageRequest.of(0, 3);
        Page<Project> projectPage = this.projectService.getAllProject(pageable, name);
        if (!projectPage.hasContent()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(projectPage, HttpStatus.OK);
    }
}
