package com.example.be.repository;

import com.example.be.dto.StudentDto;
import com.example.be.dto.StudentInfo;
import com.example.be.model.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IStudentRepository extends JpaRepository<Student, Long> {

@Query(value = "select `student`.student_id as studentId, `student`.student_code as studentCode,`student`.img as studentImg, `student`.student_name as studentName, `student`.email as studentEmail, `student`.phone_number as studentPhoneNumber, `clazz`.clazz_name as nameClazz from `student` join `clazz` on `student`.clazz_id = `clazz`.clazz_id where `student`.student_name like %:nameSearch% and `student`.flag_delete= false",
countQuery = "select `student`.student_id as studentId, `student`.student_code as studentCode,`student`.img as studentImg, `student`.email as studentEmail, `student`.phone_number as studentPhoneNumber, `clazz`.clazz_name as nameClazz from `student` join `clazz` on `student`.clazz_id = `clazz`.clazz_id where `student`.student_name like %:nameSearch% and `student`.flag_delete= false", nativeQuery = true)
    Page<StudentDto> getStudentList(Pageable pageable, @Param("nameSearch") String nameSearch);



@Query(value = "select `student`.student_id as idStudent, `student`.student_code as codeStudent,`student`.student_name as nameStudent,`student`.email as emailStudent, `student`.phone_number as phoneNumberStudent,`student`.img as imgStudent, `clazz`.clazz_name as nameClazz, `teacher`.teacher_name as nameTeacher from `student` join `clazz` on `student`.clazz_id=`clazz`.clazz_id join `team` on `student`.team_id= `team`.team_id join `teacher` on `team`.teacher_id= teacher.teacher_id where `student`.student_name like %:nameSearch% and `student`.flag_delete =false and `teacher`.teacher_id= :idTeacher",
countQuery = "select `student`.student_id as idStudent, `student`.student_code as codeStudent,`student`.student_name as nameStudent,`student`.email as emailStudent, `student`.phone_number as phoneNumberStudent,`student`.img as imgStudent, `clazz`.clazz_name as nameClazz, `teacher`.teacher_name as nameTeacher from `student` join `clazz` on `student`.clazz_id=`clazz`.clazz_id join `team` on `student`.team_id= `team`.team_id join `teacher` on `team`.teacher_id= teacher.teacher_id where `student`.student_name like %:nameSearch% and `student`.flag_delete =false and `teacher`.teacher_id= :idTeacher", nativeQuery = true)
Page<StudentInfo>findAllStudent(Pageable pageable, @Param("nameSearch") String nameSearch, @Param("idTeacher") Long idTeacher);





}
