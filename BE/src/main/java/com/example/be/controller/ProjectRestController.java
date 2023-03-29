package com.example.be.controller;

import com.example.be.dto.ProjectDTO;
import com.example.be.model.Project;
import com.example.be.service.IProjectService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.stream.Collectors;


@RestController
@CrossOrigin("*")
@RequestMapping("/api/projects")
public class ProjectRestController {
    @Autowired
    private IProjectService projectService;

    /**
     * Create by: HauNN
     * Date create: 29/03/2023
     * Function: find all project by name containing
     *
     * @return HttpStatus.OK if result is not error else return HttpStatus.NO_CONTENT
     */

    @GetMapping("/")
    public ResponseEntity<Page<Project>> findAll(@RequestParam(required = false, defaultValue = "") String searchName,
                                                 @RequestParam(required = false, defaultValue = "5") int size,
                                                 @RequestParam(required = false, defaultValue = "0") int page) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Project> projects = this.projectService.findAllByNameContaining(searchName, pageable);

        if (projects.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(projects, HttpStatus.OK);
    }

    /**
     * Create by: HauNN
     * Date create: 29/03/2023
     * Function: save project
     *
     * @return HttpStatus.OK if result is not error else return HttpStatus.EXPECTATION_FAILED
     */
    @PostMapping("/save")
    public ResponseEntity<?> saveProject(@Validated @RequestBody ProjectDTO projectDTO,
                                         BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            Map<String, String> map = bindingResult.getFieldErrors().stream()
                    .collect(Collectors.toMap(FieldError::getField, c -> c.getDefaultMessage()));

            ProjectDTO projectDTOError = new ProjectDTO(
                    map.get("name"),
                    map.get("content"),
                    map.get("img"),
                    map.get("description")
            );
            return new ResponseEntity<>(projectDTOError, HttpStatus.EXPECTATION_FAILED);
        }

        Project project = new Project();
        BeanUtils.copyProperties(projectDTO, project);
        Project project1 = this.projectService.save(project);

        if (project1 != null) {
            return new ResponseEntity<>(project1, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
    }

    /**
     * Create by: HauNN
     * Date create: 29/03/2023
     * Function: find project by id
     *
     * @return HttpStatus.OK if result is not error else return HttpStatus.EXPECTATION_FAILED
     */
    @GetMapping("/{id}")
    public ResponseEntity<Project> findById(@PathVariable Long id) {
        Project project = this.projectService.findById(id);

        if (project != null) {
            return new ResponseEntity<>(project, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
