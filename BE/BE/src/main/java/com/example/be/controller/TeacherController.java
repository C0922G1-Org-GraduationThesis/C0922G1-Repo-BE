package com.example.be.controller;

import com.example.be.model.Teacher;
import com.example.be.service.ITeacherService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/api")
public class TeacherController {
    @Autowired
    private ITeacherService teacherService;

    @RequestMapping(value = "/get-teacher/{email}", method = RequestMethod.GET)
    public ResponseEntity<Teacher> findStudentById(@PathVariable String email) {
        Teacher teacher = teacherService.findTeacherByEmail(email);
        if (teacher == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(teacher, HttpStatus.OK);
    }

    @RequestMapping(value = "/update-teacher", method = RequestMethod.PATCH)
    public ResponseEntity<Teacher> updateTeacherRoleAdmin(@RequestBody Teacher teacher, BindingResult bindingResult) {
        Teacher teacherUpdate = teacherService.findTeacherById(teacher.getTeacherId());
        if (teacherUpdate == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            if (bindingResult.hasErrors()) {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            BeanUtils.copyProperties(teacher, teacherUpdate);
            teacherService.updateTeacherRoleAdmin(teacherUpdate);
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }
}