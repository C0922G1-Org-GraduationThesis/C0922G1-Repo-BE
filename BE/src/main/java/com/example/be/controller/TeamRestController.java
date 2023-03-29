package com.example.be.controller;

import com.example.be.dto.TeamDTO;
import com.example.be.model.Team;
import com.example.be.service.ITeamService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.stream.Collectors;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/teams")
public class TeamRestController {
    @Autowired
    private ITeamService teamService;

    /**
     * Create by: HauNN
     * Date create: 29/03/2023
     * Function: find all team by name containing
     *
     * @return HttpStatus.OK if result is not error else return HttpStatus.NO_CONTENT
     */
    @GetMapping("/")
    public ResponseEntity<Page<Team>> findAll(@RequestParam(required = false, defaultValue = "") String teamName,
                                              @RequestParam(required = false, defaultValue = "5") int size,
                                              @RequestParam(required = false, defaultValue = "0") int page) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Team> teams = this.teamService.findAll(teamName, pageable);

        if (teams.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(teams, HttpStatus.OK);
    }

    /**
     * Create by: HauNN
     * Date create: 29/03/2023
     * Function: save team
     *
     * @return HttpStatus.OK if result is not error else return HttpStatus.EXPECTATION_FAILED
     */
    @PostMapping("/save")
    public ResponseEntity<?> saveTeam(@Validated @RequestBody TeamDTO teamDTO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            Map<String, String> map = bindingResult.getFieldErrors().stream()
                    .collect(Collectors.toMap(FieldError::getField, c -> c.getDefaultMessage()));

            TeamDTO teamDTOError = new TeamDTO(
                    map.get("teamName")
            );

            return new ResponseEntity<>(teamDTOError, HttpStatus.EXPECTATION_FAILED);
        }

        Team team = new Team();
        BeanUtils.copyProperties(teamDTO, team);
        Team team1 = this.teamService.saveTeam(team);

        if (team1 != null) {
            return new ResponseEntity<>(team1, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
    }

    /**
     * Create by: HauNN
     * Date create: 29/03/2023
     * Function: find team by id
     *
     * @return HttpStatus.OK if result is not error else return HttpStatus.NO_CONTENT
     */
    @GetMapping("/{id}")
    public ResponseEntity<Team> findById(@PathVariable Long id) {
        Team team = this.teamService.findById(id);

        if (team != null) {
            return new ResponseEntity<>(team, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
