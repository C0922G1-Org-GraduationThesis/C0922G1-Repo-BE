package com.example.be.repository;

import com.example.be.model.Team;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface ITeamRepository extends JpaRepository<Team, Long> {
    /**
     * Create by: HauNN
     * Date create: 29/03/2023
     * Function: find all team by name containing
     *
     * @return list page team if result is not error else return null
     * @Param: teamName, pageable
     */
    @Query(value = "" +
            "SELECT " +
            "team_id," +
            "team_name," +
            "project_id," +
            "teacher_id " +
            "FROM team " +
            "WHERE team_name LIKE CONCAT('%',:teamName,'%')",
            nativeQuery = true)
    Page<Team> findAll(@Param("teamName") String teamName, Pageable pageable);

    /**
     * Create by: HauNN
     * Date create: 29/03/2023
     * Function: find team by id
     *
     * @return  team if result is not error else return null
     * @Param: id
     */
    @Query(value = "" +
            "SELECT " +
            "team_id," +
            "team_name," +
            "project_id," +
            "teacher_id " +
            "FROM team " +
            "WHERE team_id = :teamId;",
            nativeQuery = true)
    Optional<Team> findById(@Param("teamId") Long id);

    /**
     * Create by: HauNN
     * Date create: 29/03/2023
     * Function: save team
     *
     * @return  team if result is not error else return null
     * @Param: teamName, projectId, teacherId
     */
    @Transactional
    @Query(value = "" +
            "INSERT INTO team " +
            "(team_name, project_id, teacher_id) " +
            "VALUES (:teamName,:projectId ,:teacherId);",
            nativeQuery = true)
    Team saveTeam(@Param("teamName") String teamName,
                  @Param("projectId") Long projectId,
                  @Param("teacherId") Long teacherId);

    /**
     * Create by: HauNN
     * Date create: 29/03/2023
     * Function: find all team by name
     *
     * @return team if result is not error else return null
     * @Param: teamName
     */
    @Query(value = "" +
            "SELECT " +
            "team_id," +
            "team_name," +
            "project_id," +
            "teacher_id " +
            "FROM team " +
            "WHERE team_name = LOWER(TRIM(REGEXP_REPLACE(:teamName, '\\s+', ' ')))", nativeQuery = true)
    Optional<Team> findByName(@Param("teamName") String teamName);
}
