package com.example.be.controller.restController;

import com.example.be.dto.*;
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

import javax.validation.Valid;
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

    /**
     * Create by: TanNN
     * Date created: 29/03/2023
     * Function: getAllDegree
     *
     * @return HttpStatus.OK When getting the list in the Database, HttpStatus.BAD_REQUEST when an error occurs
     */
    @GetMapping("degreeAll")
    public ResponseEntity getAllDegree() {
        List<IDegreeDTO> listDegree = iDegreeService.getAllDegree();
        if (listDegree == null) {
            return new ResponseEntity(listDegree, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity(listDegree, HttpStatus.OK);

    }

    /**
     * Create by: TanNN
     * Date created: 29/03/2023
     * Function: getAllFaculty
     *
     * @return HttpStatus.OK When getting the list in the Database, HttpStatus.BAD_REQUEST when an error occurs
     */
    @GetMapping("facultyAll")
    public ResponseEntity getAllFaculty() {
        List<IFacultyDTO> listDegree = iFacultyService.getAllFaculty();
        if (listDegree == null) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity(listDegree, HttpStatus.OK);
    }

    @GetMapping("allPhoneNumberAndEmail")
    public ResponseEntity getAllPhoneNumberAndEmail() {
        List<IEmailAndPhoneNumberDTO> teacherDTOS = iTeacherService.getAllPhoneNumberAndEmail();
        if (teacherDTOS == null) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity(teacherDTOS, HttpStatus.OK);

    }

    /**
     * Create by: TanNN
     * Date created: 29/03/2023
     * Function: createTeacher
     *
     * @param teacherDTO
     * @return HttpStatus.OK when the data is saved to the database, HttpStatus.BAD_REQUEST when an error occurs
     */
    @PostMapping("/createTeacher")
    public ResponseEntity createTeacher(@Validated @RequestBody TeacherDTO teacherDTO, BindingResult bindingResult) {
        teacherDTO.checkValidateCreateTeacher(iTeacherService.getAllPhoneNumberAndEmail(),
                teacherDTO, bindingResult);
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        String teacherCode = "GV-" + (iTeacherService.maxIdTeacher().getTeacherId() + 1);
        iTeacherService.addTeacher(teacherDTO.getTeacherName(), teacherDTO.getDateOfBirth(), teacherDTO.getDegree().getDegreeId(), teacherDTO.getTeacherAddress(), teacherDTO.isTeacherGender(), teacherDTO.getPhoneNumber(), teacherDTO.getFaculty().getFacultyId(), teacherDTO.getEmail(), teacherCode, teacherDTO.getImg());
        return new ResponseEntity<>(HttpStatus.OK);
    }


    /**
     * Create by: TanNN
     * Date created: 29/03/2023
     * Function: getTeacher
     *
     * @param id
     * @return HttpStatus.OK when retrieving data in the database, HttpStatus.NO_CONTENT when an error occurs
     */
    @GetMapping("detailTeacher/{id}")
    public ResponseEntity getTeacher(@PathVariable("id") Long id) {
        Teacher teacher = new Teacher();
        TeacherFindById teacherFindById = iTeacherService.getTeacher(id);
        if (teacherFindById == null) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
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

        if (teacher.getTeacherId() == null) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity(teacher, HttpStatus.OK);
    }

    /**
     * Create by: TanNN
     * Date created: 29/03/2023
     * Function: updateTeacher
     *
     * @param id
     * @return HttpStatus.OK when the data is saved to the database, HttpStatus.BAD_REQUEST when an error occurs
     */
    @PutMapping("/updateTeacher/{id}")
    public ResponseEntity updateTeacher(@PathVariable("id") Long id, @Validated @RequestBody TeacherDTO teacherDTO, BindingResult bindingResult) {
        teacherDTO.checkValidateUpdateTeacher(iTeacherService.getAllPhoneNumberAndEmail(), teacherDTO, bindingResult);
        if (bindingResult.hasErrors()) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
        iTeacherService.updateTeacher(teacherDTO.getTeacherName(), teacherDTO.getDateOfBirth(), teacherDTO.getDegree().getDegreeId(), teacherDTO.getTeacherAddress(), teacherDTO.isTeacherGender(), teacherDTO.getPhoneNumber(), teacherDTO.getFaculty().getFacultyId(), teacherDTO.getEmail(), teacherDTO.getImg(),id);
        return new ResponseEntity(teacherDTO,HttpStatus.OK);
    }
}
