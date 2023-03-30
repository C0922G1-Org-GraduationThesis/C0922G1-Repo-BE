package com.example.be.controller;

import com.example.be.dto.StudentDto;
import com.example.be.model.Student;
import com.example.be.service.clazz.IClazzService;
import com.example.be.service.student.IStudentService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/students")
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
     * @return HttpStatus.BAD_REQUEST if result is empty or HttpStatus.OK if result is not error.
     */

    @PostMapping("/create")
    public ResponseEntity save( @Validated @RequestBody StudentDto studentDto,BindingResult bindingResult) {
        if (bindingResult.hasErrors()){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Student student = new Student();
        BeanUtils.copyProperties(studentDto,student);
        studentService.addStudent(student.getStudentName(),student.getStudentCode(),student.getDateOfBirth(),student.getEmail(),student.getPhoneNumber(),student.isStudentGender(),student.getStudentAddress(),student.getImg(),student.getClazz().getClazzId());
        return new ResponseEntity<>( student,HttpStatus.OK);
//        studentService.addStudent(student.getStudentName(),student.getStudentCode(),student.getDateOfBirth(),student.getEmail(),student.getPhoneNumber(),student.isStudentGender(),student.getStudentAddress(),student.getImg(),student.getClazz().getClazzId());
//        return new ResponseEntity<>(student,HttpStatus.OK);
    }

    /**
     * Created by: MinhLD
     * Date create: 29/03/2023
     * Function: tìm sinh viên theo id
     * @param :studentId
     * @return HttpStatus.NOT_FOUND if result is empty or HttpStatus.OK if result is not error.
     */
    @GetMapping("/{studentId}")
    public ResponseEntity<Student> findById(@PathVariable long studentId){
        Student student = studentService.findStudentById(studentId);
        if (student == null){
          return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }else {
            return new ResponseEntity<>(student,HttpStatus.OK);
        }
    }

    /**
     * Created by: MinhLD
     * Date create: 29/03/2023
     * Function: chỉnh sửa sinh viên
     * @param :studentId,student
     * @return HttpStatus.NOT_FOUND  if result is empty or HttpStatus.OK if result is not error.
     */

    @PatchMapping("/{studentId}")
    public ResponseEntity<Student> updateStudent(@RequestBody StudentDto studentDto, @PathVariable long studentId, BindingResult bindingResult) {
        Student student1 = studentService.findStudentById(studentId);
        if (student1 == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            if (bindingResult.hasErrors()) {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            BeanUtils.copyProperties(studentDto,student1);
            studentService.updateStudent(studentId, student1);
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }
}
