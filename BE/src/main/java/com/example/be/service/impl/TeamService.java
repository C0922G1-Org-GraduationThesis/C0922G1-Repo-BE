package com.example.be.service.impl;

import com.example.be.dto.TeacherDto;
import com.example.be.model.Team;
import com.example.be.repository.ITeamRepository;
import com.example.be.service.ITeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class TeamService implements ITeamService {
    @Autowired
    private ITeamRepository teamRepository;

    /**
     * Created by: DucND
     * Date create: 29/03/2023
     * Function: get all teacher and paging
     * @param pageable
     * @return list instructor and paging
     */

    @Override
    public Page<TeacherDto> getAllInstructor(Pageable pageable) {
        return teamRepository.getAllInstructor(pageable);
    }

    /**
     * Created by: DucND
     * Date create: 29/03/2023
     * Function: find team by id
     * @param id
     * @return the team you looking for
     */

    @Override
    public Team findTeamById(Long id) {
        return teamRepository.findTeamById(id);
    }

//    @Override
//    public Teacher findTeacherById(Long id) {
//        return teamRepository.findTeacherById(id);
//    }

    /**
     * Created by: DucND
     * Date create: 29/03/2023
     * Function: add or edit instructor for team
     * @param teacherId, teamId
     * @result team with parameter need to be changed
     */

    @Override
    public void updateTeam(Long teacherId, Long teamId) {
        teamRepository.updateTeam(teacherId,teamId);
    }
}
