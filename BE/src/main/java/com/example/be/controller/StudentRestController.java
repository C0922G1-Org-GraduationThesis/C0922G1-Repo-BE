package com.example.be.controller;

import com.example.be.model.Student;
import com.example.be.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/students")
public class StudentRestController {
    @Autowired
    private IStudentService studentService;

    /**
     * Create by: HauNN
     * Date create: 29/03/2023
     * Function: find all student by name containing or code containing
     *
     * @return HttpStatus.OK if result is not error else return HttpStatus.NO_CONTENT
     */
    @GetMapping("/")
    public ResponseEntity<Page<Student>> findAllByNameOrStudentCode
    (@RequestParam(required = false, defaultValue = "") String searchStr,
     @RequestParam(required = false, defaultValue = "5") int size,
     @RequestParam(required = false, defaultValue = "0") int page) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Student> students = this.studentService.findAllByNameOrStudentCode(searchStr, pageable);

        if (students.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(students, HttpStatus.OK);
    }

    /**
     * Create by: HauNN
     * Date create: 29/03/2023
     * Function: find all student by team id
     *
     * @return HttpStatus.OK if result is not error else return HttpStatus.NO_CONTENT
     */
    @GetMapping("/{teamId}")
    public ResponseEntity<Page<Student>> findAllByTeamId
    (@PathVariable Long teamId,
     @RequestParam(required = false, defaultValue = "5") int size,
     @RequestParam(required = false, defaultValue = "0") int page) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Student> students = this.studentService.findAllByTeamId(teamId, pageable);

        if (students.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(students, HttpStatus.OK);
    }
}
