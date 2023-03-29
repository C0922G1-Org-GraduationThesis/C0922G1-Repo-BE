package com.example.be.service;

import com.example.be.model.Team;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;

public interface ITeamService {
    Page<Team> findPagePro(Pageable pageable);
}
