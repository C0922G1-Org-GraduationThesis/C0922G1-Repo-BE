package com.example.be.service;

import com.example.be.model.ProgressReport;
import com.example.be.model.Team;

import java.util.List;
/**
 * SyVT
 */
public interface ITeamService {
    List<Team> findAll();

    Team findById(Long id);

    void save(Team team);

    void delete(Long id);
}
