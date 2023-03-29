package com.example.be.controller;

import com.example.be.model.Student;
import com.example.be.repository.IStudentRepository;
import com.example.be.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/api")
public class StudentController {
    @Autowired
    private IStudentService studentService;

    /**
     * Created by: Phạm Tiến
     * Date: 29/03/2023
     * Function: findStudentById(email)
     *
     * @Return: new ResponseEntity<>(HttpStatus.BAD_REQUEST) if result is error,
     * else new ResponseEntity<>(student, HttpStatus.OK)
     */
    @RequestMapping(value = "/get-student/{email}", method = RequestMethod.GET)
    public ResponseEntity<Student> findStudentById(@PathVariable String email){
        Student student = studentService.findStudentByEmail(email);
        if (student == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(student, HttpStatus.OK);
    }
}
