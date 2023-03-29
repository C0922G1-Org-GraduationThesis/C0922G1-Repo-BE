package com.example.be.repository;

import com.example.be.model.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITeamRepository extends JpaRepository<Team, Long> {


}
