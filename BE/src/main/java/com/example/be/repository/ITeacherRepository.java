package com.example.be.repository;

import com.example.be.dto.TeacherFindById;
import com.example.be.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface ITeacherRepository extends JpaRepository<Teacher, Long> {
    @Query(value = "select teacher_id as teacherId,img,teacher_name as teacherName, date_of_birth as dateOfBirth,d.degree_id as degreeId,d.degree_name as degreeName, teacher_address as teacherAddress,teacher_gender as teacherGender, phone_number as phoneNumber, f.faculty_id as facultyId,f.faculty_name as facultyName,email  from teacher join degree d on teacher.degree_id = d.degree_id join faculty f on teacher.faculty_id = f.faculty_id where teacher_id = :idTeacher",
            countQuery = "select teacher_id as teacherId,img,teacher_name as teacherName, date_of_birth as dateOfBirth,d.degree_id as degreeId,d.degree_name as degreeName, teacher_address as teacherAddress,teacher_gender as teacherGender, phone_number as phoneNumber, f.faculty_id as facultyId,f.faculty_name as facultyName,email  from teacher join degree d on teacher.degree_id = d.degree_id join faculty f on teacher.faculty_id = f.faculty_id where teacher_id = :idTeacher",
            nativeQuery = true)
    TeacherFindById getTeacher(@Param("idTeacher") Long idTeacher);

    @Query(value = "select MAX(teacher_id) as teacherId from teacher",
    countQuery = "select MAX(teacher_id) as teacherId from teacher",
    nativeQuery = true)
    TeacherFindById maxIdTeacher();
    @Transactional
    @Modifying
    @Query(value =
            "insert into teacher(teacher_name,date_of_birth,degree_id,teacher_address,teacher_gender,phone_number,faculty_id,email, teacher_code,img)" +
            " VALUES (:teacherName, :dateOfBirth, :idDegree, :address, :gender, :phoneNumber, :facultyId, :email, :teacherCode, :img)",
            nativeQuery = true)
    void addTeacher(@Param("teacherName") String teacherName,
                    @Param("dateOfBirth") String dateOfBirth,
                    @Param("idDegree") int idDegree,
                    @Param("address")String address,
                    @Param("gender")boolean gender,
                    @Param("phoneNumber")String phoneNumber,
                    @Param("facultyId") int facultyId,
                    @Param("email")String email,
                    @Param("teacherCode")String teacherCode,
                    @Param("img") String img);
    @Transactional
    @Modifying
    @Query(value = "update teacher " +
            "set teacher_name    = :teacherName, " +
            "    date_of_birth   = :dateOfBirth, " +
            "    degree_id       = :degreeId, " +
            "    teacher_address = :teacherAddress, " +
            "    teacher_gender  = :teacherGender, " +
            "    phone_number    = :phoneNumber, " +
            "    faculty_id      = :facultyId, " +
            "    email           = :email, " +
            "    img             = :img " +
            "    where teacher_id = :teacherId",
    nativeQuery = true)
    void updateTeacher(@Param("teacherName") String teacherName,
                       @Param("dateOfBirth") String dateOfBirth,
                       @Param("degreeId")int degreeId,
                       @Param("teacherAddress") String teacherAddress,
                       @Param("teacherGender") boolean teacherGender,
                       @Param("phoneNumber") String phoneNumber,
                       @Param("facultyId") int facultyId,
                       @Param("email") String email,
                       @Param("img") String img,
                       @Param("teacherId") Long teacherId);

}
