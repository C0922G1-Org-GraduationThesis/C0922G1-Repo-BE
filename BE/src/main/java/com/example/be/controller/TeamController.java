package com.example.be.controller;

import com.example.be.dto.TeacherDto;
import com.example.be.dto.TeamDto;
import com.example.be.model.Team;
import com.example.be.service.ITeamService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
public class TeamController {

    /**
     * Created by: DucND
     * Date create: 29/03/2023
     * Function: tạo api get all and paging information teacher
     * @param page,size
     * @return HttpStatus.NOT_FOUND if result is empty or HttpStatus.OK if result is not error.
     */

    @Autowired
    private ITeamService teamService;

    @GetMapping("/instructor")
    public ResponseEntity<Page<TeacherDto>> getAllInstructor(@RequestParam(defaultValue = "0") int page,
                                                             @RequestParam(defaultValue = "5") int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("teacher"));
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
     * @param teamId
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

//    @GetMapping("/teacher/{id}")
//    public ResponseEntity<Teacher> findTeacherById(@PathVariable Long id) {
//        Teacher teacher = teamService.findTeacherById(id);
//        if (teacher == null) {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        } else {
//            return new ResponseEntity<>(teacher, HttpStatus.OK);
//        }
//    }

    /**
     * Created by: DucND
     * Date create: 29/03/2023
     * Function: create api edit,add instructor team
     * @param teamId, teamDto
     * @return HttpStatus.NOT_FOUND if result team is null, not found or HttpStatus.OK if result is edit success.
     */

    @PatchMapping("/edit/{teamId}")
    public ResponseEntity<?> updateTeam(@RequestBody TeamDto teamDto, @PathVariable Long teamId) {
        Team team = teamService.findTeamById(teamId);
        if (team == null){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        } else {
            teamService.updateTeam(teamDto.getTeacherId(),teamId);
            BeanUtils.copyProperties(team,teamDto);
            return new ResponseEntity(teamDto,HttpStatus.OK);
        }
    }

}

