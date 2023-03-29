package com.example.be.repository;

import com.example.be.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IProjectRepository extends JpaRepository<Project,Long> {

}
