package com.example.be.service;

import com.example.be.model.Team;
import com.example.be.repository.ITeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamService implements ITeamService {
    @Autowired
    private ITeamRepository iProjectRepository;

//    @Override
//    public List<Team> findAllPro() {
//        return iProjectRepository.findAllPro();
//    }


    @Override
    public Page<Team> findPagePro(Pageable pageable) {
        return iProjectRepository.findPagePro(pageable);
    }



}
