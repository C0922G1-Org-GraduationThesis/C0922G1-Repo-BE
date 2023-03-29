package com.example.be.controller;

import com.example.be.dto.StudentDto;
import com.example.be.dto.StudentInfo;
import com.example.be.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/students")
public class StudentController {
    @Autowired
    private IStudentService studentService;

    @GetMapping("")
    public ResponseEntity<Page<StudentDto>> getAllStudent(@RequestParam(value = "nameSearch",defaultValue = "") String nameSearch,
                                                          @PageableDefault(size = 5) Pageable pageable) {
        Page<StudentDto> studentDtos = studentService.getStudentList(pageable, nameSearch);
        if (studentDtos.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return  new ResponseEntity<>(studentDtos, HttpStatus.OK);

    }

    @GetMapping("/list-id-teacher/{teacherId}")
    public ResponseEntity<Page<StudentInfo>>getStudentListIdTeacher(@RequestParam(value = "nameSearch",defaultValue = "") String nameSearch,
                                                                    @PageableDefault(size = 5) Pageable pageable,
                                                                    @PathVariable Long teacherId){
        Page<StudentInfo> studentInfos= studentService.findAllStudent(pageable,nameSearch,teacherId);
        if (studentInfos.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(studentInfos,HttpStatus.OK);
    }


}
