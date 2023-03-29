package com.example.be.service.student;

import com.example.be.model.Student;
import org.springframework.data.repository.query.Param;

public interface IStudentService {
      Student findStudentById(long studentId);

    void addStudent(String studentName,
                String studentCode,
                String dateOfBirth,
                String email,
                String phoneNumber,
                boolean studentGender,
                String studentAddress,
                String img,
                Long clazzId);

    void updateStudent(long studentId,Student student);
}
