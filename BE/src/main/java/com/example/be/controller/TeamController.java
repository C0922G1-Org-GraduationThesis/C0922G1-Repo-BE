package com.example.be.controller;

import com.example.be.dto.TeacherDto;
import com.example.be.dto.TeamDto;
import com.example.be.model.Team;
import com.example.be.service.ITeamService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
public class TeamController {
    @Autowired
    private ITeamService teamService;

    /**
     * Created by: DucND
     * Date create: 29/03/2023
     * Function: tạo api get all and paging information teacher
     * @param: pageable
     * @return HttpStatus.NOT_FOUND if result is empty or HttpStatus.OK if result is not error.
     */
    @GetMapping("/instructor")
    public ResponseEntity<Page<TeacherDto>> getAllInstructor(@PageableDefault(size = 5) Pageable pageable) {
        Page<TeacherDto> instructorList = teamService.getAllInstructor(pageable);
        if (instructorList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(instructorList, HttpStatus.OK);
        }
    }

    /**
     * Created by: DucND
     * Date create: 29/03/2023
     * Function: create api find team by id
     * @param: teamId
     * @return HttpStatus.NOT_FOUND if result is null or HttpStatus.OK if result is not error.
     */
    @GetMapping("/team/{teamId}")
    public ResponseEntity<Team> findTeamById(@PathVariable Long teamId) {
        Team team = teamService.findTeamById(teamId);
        if (team == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(team, HttpStatus.OK);
        }
    }

    /**
     * Created by: DucND
     * Date create: 29/03/2023
     * Function: create api edit,add instructor team
     * @param: teamId, teamDto
     * @return HttpStatus.NOT_FOUND if result team is null, not found or HttpStatus.OK if result is edit success.
     */
    @PatchMapping("/edit/{teamId}")
    public ResponseEntity<?> updateTeam(@RequestBody TeamDto teamDto, @PathVariable Long teamId) {
        Team team = teamService.findTeamById(teamId);
        if (team == null){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        } else {
            teamService.updateTeam(teamDto.getTeacherId(),teamId);
            return new ResponseEntity(teamDto,HttpStatus.OK);
        }
    }

}

