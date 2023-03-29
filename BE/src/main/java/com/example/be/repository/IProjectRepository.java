package com.example.be.repository;

import com.example.be.model.Project;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IProjectRepository extends JpaRepository<Project, Long> {
    @Query(value = "select * from `project` " +
            "where `name` like concat('%', :name, '%')" +
            "and `project_status` = true ", nativeQuery = true)
    Page<Project> getAllProject(Pageable pageable, @Param("name") String name);
}
