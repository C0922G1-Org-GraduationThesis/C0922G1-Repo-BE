package com.example.be.repository;

import com.example.be.dto.IFacultyDTO;
import com.example.be.model.Faculty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface IFacultyRepository extends JpaRepository<Faculty,Integer> {
    @Query(value = "select faculty_id as facultyId,faculty_name as facultyName from faculty",
    countQuery = "select faculty_id as facultyId,faculty_name as facultyName from faculty",
    nativeQuery = true)
    List<IFacultyDTO> getAllFaculty();

}
