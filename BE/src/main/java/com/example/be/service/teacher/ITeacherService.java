package com.example.be.service.teacher;

import com.example.be.dto.TeacherFindById;
import org.springframework.data.repository.query.Param;


public interface ITeacherService {
    TeacherFindById getTeacher(Long idTeacher);

    void addTeacher(String teacherName, String dateOfBirth, int idDegree, String address, boolean gender, String phoneNumber, int facultyId, String email, String teacherCode, String img);

    TeacherFindById maxIdTeacher();

    void updateTeacher(String teacherName,
                       String dateOfBirth,
                       int degreeId,
                       String teacherAddress,
                       boolean teacherGender,
                       String phoneNumber,
                       int facultyId,
                       String email,
                       String img,
                       Long teacherId);
}
