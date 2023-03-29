package com.example.be.service.teacher;

import com.example.be.dto.TeacherFindById;
import com.example.be.repository.ITeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class TeacherServiceImpl implements ITeacherService {
    @Autowired
    private ITeacherRepository iTeacherRepository;
    @Override
    public TeacherFindById getTeacher(Long idTeacher) {
        return iTeacherRepository.getTeacher(idTeacher);
    }

    @Override
    public void addTeacher(String teacherName, String dateOfBirth, int idDegree, String address, boolean gender, String phoneNumber, int facultyId, String email, String teacherCode, String img) {
        iTeacherRepository.addTeacher(teacherName,dateOfBirth,idDegree,address,gender,phoneNumber,facultyId,email,teacherCode,img);
    }

    @Override
    public TeacherFindById maxIdTeacher() {
        return iTeacherRepository.maxIdTeacher();
    }

    @Override
    public void updateTeacher(String teacherName, String dateOfBirth, int degreeId, String teacherAddress, boolean teacherGender, String phoneNumber, int facultyId, String email, String img, Long teacherId) {
        iTeacherRepository.updateTeacher(teacherName,dateOfBirth,degreeId,teacherAddress,teacherGender,phoneNumber,facultyId,email,img,teacherId);
    }
}
