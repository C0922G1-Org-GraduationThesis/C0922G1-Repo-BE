package com.example.be.repository;

import com.example.be.dto.ITeacherDto;
import com.example.be.model.Teacher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;

@Repository

public interface ITeacherRepository extends JpaRepository<Teacher, Long> {
    /**
     * tên : phan văn hùng
     * nội dung: tạo phương thức hiển thị danh sách giáo viên với query thuần
     *
     */
    @Query(value = "select `teacher`.teacher_id as teacherId,`teacher`.teacher_name as teacherName\n" +
            "            ,`teacher`.teacher_code as teacherCode, `teacher`.img as teacherImg,`teacher`.phone_number as teacherPhoneNumber\n" +
            "              , `teacher`.email as teacherEmail, `faculty`.faculty_name as faculty, `degree`.degree_name as degree from teacher \n" +
            "              join `faculty` on `faculty`.faculty_id = `teacher`.faculty_id\n" +
            "               join `degree` on `degree`.degree_id = `teacher`.degree_id " +
            "             where teacher.teacher_name like concat('%',:nameSearch,'%') and teacher.flag_delete=0", nativeQuery = true)
    Page<ITeacherDto> getAllTeacher(@Param("nameSearch") String name, Pageable pageable);

    /**
     * tên : phan văn hùng
     * nội dung: tạo phương thức lấy giáo viên theo id vơi query thuần
     *
     */
    @Query(value = "select `teacher`.teacher_id as teacherId,`teacher`.teacher_name as teacherName\n" +
            "            ,`teacher`.teacher_code as teacherCode, `teacher`.img as teacherImg,`teacher`.phone_number as teacherPhoneNumber\n" +
            "              , `teacher`.email as teacherEmail, `faculty`.faculty_name as faculty, `degree`.degree_name as degree from teacher \n" +
            "              join `faculty` on `faculty`.faculty_id = `teacher`.faculty_id\n" +
            "               join `degree` on `degree`.degree_id = `teacher`.degree_id " +
            "             where teacher.teacher_id = :id", nativeQuery = true)
    Optional<ITeacherDto> findTeacherById(@Param("id") Long id);

    /**
     * tên : phan văn hùng
     * nội dung: tạo phương thức xóa giáo viên theo id vơi query thuần
     *
     */
    @Transactional
    @Modifying
    @Query(value = "update teacher set teacher.flag_delete = 1 where teacher_id = :teacherId ", nativeQuery = true)
    void deleteTeacherById(@Param("teacherId") long teacherId);

}



