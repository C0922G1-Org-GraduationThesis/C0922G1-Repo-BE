package com.example.be.service;

import com.example.be.model.Team;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface ITeamService {
    /**
     * Create by: HauNN
     * Date create: 29/03/2023
     * Function: find all team by name containing
     *
     * @return list page team if result is not error else return null
     * @Param: teamName, pageable
     */
    Page<Team> findAll(String teamName, Pageable pageable);

    /**
     * Create by: HauNN
     * Date create: 29/03/2023
     * Function: find by team id
     *
     * @return team if result is not error else return null
     * @Param: id
     */
    Team findById(Long id);

    /**
     * Create by: HauNN
     * Date create: 29/03/2023
     * Function: save team
     *
     * @return team if result is not error else return null
     * @Param: team
     */
    Team saveTeam(Team team);
}
