package com.example.be.controller.restController;

import com.example.be.dto.IDegreeDTO;
import com.example.be.dto.IFacultyDTO;
import com.example.be.dto.TeacherDTO;
import com.example.be.dto.TeacherFindById;
import com.example.be.model.Degree;
import com.example.be.model.Faculty;
import com.example.be.model.Teacher;
import com.example.be.service.teacher.IDegreeService;
import com.example.be.service.teacher.IFacultyService;
import com.example.be.service.teacher.ITeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api-teacher")
@CrossOrigin("*")
public class TeacherRestController {
    @Autowired
    private ITeacherService iTeacherService;

    @Autowired
    private IDegreeService iDegreeService;

    @Autowired
    private IFacultyService iFacultyService;

    @GetMapping("degreeAll")
    public ResponseEntity getAllDegree() {
        List<IDegreeDTO> listDegree = iDegreeService.getAllDegree();
        if (listDegree == null) {
            return new ResponseEntity(listDegree, HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity(listDegree, HttpStatus.OK);

    }

    @GetMapping("facultyAll")
    public ResponseEntity getAllFaculty() {
        List<IFacultyDTO> listDegree = iFacultyService.getAllFaculty();
        if (listDegree == null) {
            return new ResponseEntity(listDegree, HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity(listDegree, HttpStatus.OK);

    }

    @PostMapping("/createTeacher")
    public ResponseEntity createTeacher(@Validated @RequestBody TeacherDTO teacher,
                                        BindingResult bindingResult) {
        if (bindingResult.hasErrors()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        String teacherCode = "GV-" + (iTeacherService.maxIdTeacher().getTeacherId() + 1);
        iTeacherService.addTeacher(teacher.getTeacherName(), teacher.getDateOfBirth(), teacher.getDegree().getDegreeId(), teacher.getTeacherAddress(), teacher.isTeacherGender(), teacher.getPhoneNumber(), teacher.getFaculty().getFacultyId(), teacher.getEmail(), teacherCode, teacher.getImg());
        return new ResponseEntity<>(HttpStatus.OK);
    }


    @GetMapping("detailTeacher/{id}")
    public ResponseEntity getTeacher(@PathVariable("id") Long id) {
        Teacher teacher = new Teacher();
        TeacherFindById teacherFindById = iTeacherService.getTeacher(id);
        teacher.setTeacherId(teacherFindById.getTeacherId());
        teacher.setImg(teacherFindById.getImg());
        teacher.setTeacherName(teacherFindById.getTeacherName());
        teacher.setDateOfBirth(teacherFindById.getDateOfBirth());
        teacher.setDegree(new Degree(teacherFindById.getDegreeId(), teacherFindById.getDegreeName()));
        teacher.setTeacherAddress(teacherFindById.getTeacherAddress());
        if (teacherFindById.getTeacherGender().equals("1")) {
            teacher.setTeacherGender(true);
        } else {
            teacher.setTeacherGender(false);
        }
        teacher.setPhoneNumber(teacherFindById.getPhoneNumber());
        teacher.setFaculty(new Faculty(teacherFindById.getFacultyId(), teacherFindById.getFacultyName()));
        teacher.setEmail(teacherFindById.getEmail());

        if (teacher == null) {
            return new ResponseEntity(teacher, HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity(teacher, HttpStatus.OK);
    }

    @PatchMapping("/updateTeacher/{id}")
    public ResponseEntity updateTeacher(@PathVariable("id") Long id,@Validated @RequestBody TeacherDTO teacherDTO,BindingResult bindingResult) {
        if (bindingResult.hasErrors()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        iTeacherService.updateTeacher(teacherDTO.getTeacherName(), teacherDTO.getDateOfBirth(), teacherDTO.getDegree().getDegreeId(), teacherDTO.getTeacherAddress(), teacherDTO.isTeacherGender(), teacherDTO.getPhoneNumber(), teacherDTO.getFaculty().getFacultyId(), teacherDTO.getEmail(), teacherDTO.getImg(), id);
        return new ResponseEntity(HttpStatus.OK);
    }
}
