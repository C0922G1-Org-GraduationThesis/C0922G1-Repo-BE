package com.example.be.controller;

import com.example.be.model.Student;
import com.example.be.service.clazz.IClazzService;
import com.example.be.service.student.IStudentService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
//@RequestMapping("student")
public class StudentRestController {
    @Autowired
    private IStudentService studentService;
    @Autowired
    private IClazzService clazzService;


    /**
     * Created by: MinhLD
     * Date create: 29/03/2023
     * Function: thêm mới sinh viên
     * @param :student
     * @return HttpStatus.NOT_FOUND if result is empty or HttpStatus.OK if result is not error.
     */

    @PostMapping("/api/students")
    public ResponseEntity save(@RequestBody Student student) {
        studentService.addStudent(student.getStudentName(),student.getStudentCode(),student.getDateOfBirth(),student.getEmail(),student.getPhoneNumber(),student.isStudentGender(),student.getStudentAddress(),student.getImg(),student.getClazz().getClazzId());
        return new ResponseEntity<>( student,HttpStatus.OK);
    }


    @GetMapping("/{studentId}")
    public ResponseEntity<Student> findById(@PathVariable long studentId){
        Student student = studentService.findStudentById(studentId);
        if (student == null){
          return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else {
            return new ResponseEntity<>(student,HttpStatus.OK);
        }
    }

    @PatchMapping("/{studentId}")
    public ResponseEntity<Student> updateStudent(@RequestBody Student student, @PathVariable long studentId, BindingResult bindingResult) {
        Student student1 = studentService.findStudentById(studentId);
        if (student1 == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            if (bindingResult.hasErrors()) {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            BeanUtils.copyProperties(student,student1);
            studentService.updateStudent(studentId, student1);
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }
}
