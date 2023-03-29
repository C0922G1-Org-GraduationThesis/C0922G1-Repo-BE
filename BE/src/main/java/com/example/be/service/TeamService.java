package com.example.be.service;

import com.example.be.model.Team;
import com.example.be.repository.ITeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class TeamService implements ITeamService {
    @Autowired
    private ITeamRepository teamRepository;

    @Override
    public List<Team> findAll() {
        return teamRepository.findAll();
    }

    @Override
    public Team findById(Long id) {
        return teamRepository.findById(id).get();
    }

    @Override
    public void save(Team team) {
        teamRepository.save(team);
    }

    @Override
    public void delete(Long id) {

    }
}
