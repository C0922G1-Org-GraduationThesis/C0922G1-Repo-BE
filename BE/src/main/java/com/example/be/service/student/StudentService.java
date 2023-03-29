package com.example.be.service.student;

import com.example.be.model.Student;
import com.example.be.repository.IStudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService implements IStudentService{


    @Autowired
    private IStudentRepository studentRepository;
    /**
     * Created by: MinhLD
     * Date create: 29/03/2023
     * Function: tìm kiếm theo id
     * @param: studentId
     * @return HttpStatus.NOT_FOUND if result is empty or HttpStatus.OK if result is not error.
     */
    @Override
    public Student findStudentById(long studentId) {
        return studentRepository.findStudentById(studentId);
    }

    /**
     * Created by: MinhLD
     * Date create: 29/03/2023
     * Function: thêm mới sinh viên
     * @param: studentName,studentCode,dateOfBirth,email,phoneNumber,studentGender,studentAddress,img,clazzID
     * @return HttpStatus.NOT_FOUND if result is empty or HttpStatus.OK if result is not error.
     */
    @Override
    public void addStudent(String studentName, String studentCode, String dateOfBirth, String email, String phoneNumber, boolean studentGender, String studentAddress, String img, Long clazzId) {
        studentRepository.addStudent(studentName,studentCode,dateOfBirth,email,phoneNumber,studentGender,studentAddress,img,clazzId);
    }

    @Override
    public void updateStudent(long studentId, Student student) {
        studentRepository.updateStudent(student.getStudentName(),student.getStudentCode(),student.getDateOfBirth(),student.getEmail(),
                student.getPhoneNumber(),student.isStudentGender(),student.getStudentAddress(),student.getImg(),student.getClazz().getClazzId(),studentId);
    }
}
