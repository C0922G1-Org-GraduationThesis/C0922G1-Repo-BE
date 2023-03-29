package com.example.be.repository;

import com.example.be.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IProjectRepository extends JpaRepository<Project,Long> {
    /**
     * Created by: NuongHT
     * Date create: 29/03/2023
     */

    @Modifying
    @Query(value = "update `project` set project_status = true where project_Id = :projectId",nativeQuery = true)
    void updatePro(@Param("projectId") Long projectId);
    /**
     * Created by: NuongHT
     * Date create: 29/03/2023
     */

    @Modifying
    @Query(value = "update `project` set project_status = false where project_Id = :projectId",nativeQuery = true)
    void updatePro2(@Param("projectId") Long projectId);

    /**
     * Created by: NuongHT
     * Date create: 29/03/2023
     */

    @Query(value = "select * from `project` where project_id = :projectId", nativeQuery = true)
    Project findProById(@Param("projectId") Long projectId);
}
