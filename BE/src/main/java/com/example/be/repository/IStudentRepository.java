package com.example.be.repository;

import com.example.be.dto.StudentDto;
import com.example.be.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IStudentRepository extends JpaRepository<Student,Long> {

    /**
     * Created by: NuongHT
     * Date create: 29/03/2023
     */

    @Modifying
    @Query(value = "select s.student_id as studentId,te.team_id as teamId,p.project_id as projectId,p.name as projectName,te.team_name as teamName,s.email as email" +
            "            from student s join team te on te.team_id = s.team_id join project p on p.project_id = te.project_id join teacher t on te.teacher_id = t.teacher_id" +
            "            where te.team_id = :teamId", nativeQuery = true)
    List<StudentDto> getInfomation(@Param("teamId") Long teamId);
}
