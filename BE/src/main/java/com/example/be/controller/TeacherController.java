package com.example.be.controller;

import com.example.be.dto.ITeacherDto;
import com.example.be.service.impl.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/teacher")
public class TeacherController {
    @Autowired
    private TeacherService teacherService;

    /**
     * tên : phan văn hùng
     * nội dung: đổ list có phân trang và tìm kiếm theo tên
     * tham số truyền vào : tên tìm kiếm và pageable
     * return : Page teacher
     */
    @GetMapping("/list")
    public ResponseEntity<Page<ITeacherDto>> getAllTeacher(@RequestParam(defaultValue = "") String name,
                                                           @PageableDefault(size = 2, page = 0) Pageable pageable) {
        Page<ITeacherDto> teacherPage = teacherService.getAllTeacher(name, pageable);
        if (teacherPage.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(teacherPage, HttpStatus.OK);
    }

    /**
     * tên : phan văn hùng
     * nội dung: tìm kiếm theo id
     * tham số truyền vào : id cần tìm kiếm
     * return : teacher
     */
    @GetMapping("/list/{id}")
    public ResponseEntity<ITeacherDto> getTeacherById(@PathVariable Long id) {
        Optional<ITeacherDto> categoryOptional = teacherService.findTeacherById(id);
        return categoryOptional.map(teacher -> new ResponseEntity<>(teacher, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    /**
     * tên : phan văn hùng
     * nội dung: xóa 1 giáo viên theo id
     * tham số truyền vào : id cần xóa
     * return : trạng thái
     */
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ITeacherDto> deleteTeacherById(@PathVariable Long id) {
        Optional<ITeacherDto> teacher = teacherService.findTeacherById(id);

        if (!teacher.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        teacherService.deleteTeacherById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
