package com.example.be.repository;

import com.example.be.model.Clazz;
import com.example.be.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface IStudentRepository extends JpaRepository<Student, Long> {

    @Transactional
    @Modifying
    @Query(value = "insert into student (student_name,student_code,date_of_birth,email,phone_number,student_gender,student_address,img,clazz_id) " +
            "values(:student_name,:student_code,:date_of_birth,:email,:phone_number,:student_gender,:student_address,:img,:clazz_id)",
            nativeQuery = true)
    void addStudent(@Param("student_name") String studentName,
                    @Param("student_code") String studentCode,
                    @Param("date_of_birth") String dateOfBirth,
                    @Param("email") String email,
                    @Param("phone_number") String phoneNumber,
                    @Param("student_gender") boolean studentGender,
                    @Param("student_address") String studentAddress,
                    @Param("img") String img,
                    @Param("clazz_id") Long clazzId);

    @Query(value = "select * from student where student_id= :studentId", nativeQuery = true)
    Student findStudentById(@Param("studentId") long studentId);

    @Transactional
    @Modifying
    @Query(value = "update student set student_name = :student_name,student_code = :student_code,date_of_birth = :date_of_birth," +
            "email = :email,phone_number = :phone_number, student_gender = :student_gender," +
            "student_address = :student_address,img = :img, clazz_id = :clazz_id where student_id = :student_id", nativeQuery = true)
    void updateStudent(
                       @Param("student_name") String studentName,
                       @Param("student_code") String studentCode,
                       @Param("date_of_birth") String dateOfBirth,
                       @Param("email") String email,
                       @Param("phone_number") String phoneNumber,
                       @Param("student_gender") boolean studentGender,
                       @Param("student_address") String studentAddress,
                       @Param("img") String img,
                       @Param("clazz_id") Long clazzId,
                       @Param("student_id") long studentId);
}
