package com.example.be.controller;

import com.example.be.dto.StudentDto;
import com.example.be.model.Project;

import com.example.be.model.Team;
import com.example.be.service.ProjectService;
import com.example.be.service.TeamService;
import com.example.be.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import javax.mail.internet.AddressException;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/pro")
public class MailRestController {
    @Autowired
    private StudentService studentService;

    @Autowired
    private TeamService teamService;

    @Autowired
    private ProjectService projectService;

    //    @Autowired
//    private NotificationService notificationService;
//
//    public void sendNotification() {
//        Notification notification = new Notification();
//        notification.setTitle("Thông báo mới");
//        notification.setContent("Có một thông báo mới từ ứng dụng của bạn.");
//        notificationService.send(notification);
//    }

    /**
     * Created by: NuongHT
     * Date create: 29/03/2023
     * Function: tạo api send mail
     * @param teamId
     * @throws AddressException
     */

    @GetMapping("/send/{teamId}")
    public void sendEMail(@PathVariable("teamId") Long teamId) throws AddressException {
        List<StudentDto> list = studentService.getInfomation(teamId);
        studentService.sendSimpleMessage(list, "Bạn có mail mới", "Đề tài của bạn quá ô kê được duyệt.",1);
    }

    /**
     * Created by: NuongHT
     * Date create: 29/03/2023
     * Function: tạo api get all information student
     * @param teamId
     * @return HttpStatus.NOT_FOUND if result is error or HttpStatus.OK if result is not error.
     */

    @GetMapping("/test/{teamId}")
    public ResponseEntity<List<StudentDto>> getAllStudentByIdTeacher(@PathVariable("teamId") Long teamId) {
        List<StudentDto> showAllStudent = studentService.getInfomation(teamId);
        if (showAllStudent.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(showAllStudent, HttpStatus.OK);
    }

    /**
     * Created by: NuongHT
     * Date create: 29/03/2023
     * Function: tạo api browser topic set status for project,browser successfull will send mail for group student.
     * @param projectId
     * @return HttpStatus.NO_CONTENT if result is null or HttpStatus.OK if result is not null.
     */

    @PutMapping("/browser/{projectId}")
    public ResponseEntity<?> updateProject(@PathVariable("projectId") Long projectId) {
        Project project = projectService.findProById(projectId);
        if (project == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
//
        projectService.updatePro(projectId);
        List<StudentDto> list = studentService.getInfomation(projectId);
        studentService.sendSimpleMessage(list, "", "",1);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * Created by: NuongHT
     * Date create: 29/03/2023
     * Function: tạo api cancel browser topic set status for project,cancel successfull will send mail for group student.
     * @param projectId
     * @return HttpStatus.NO_CONTENT if result is null or HttpStatus.OK if result is not null.
     */

    @PutMapping("/cancel/{projectId}")
    public ResponseEntity<?> updateProject2(@PathVariable("projectId") Long projectId) {
        Project project = projectService.findProById(projectId);
        if (project == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        projectService.updatePro2(projectId);
        List<StudentDto> list = studentService.getInfomation(projectId);
        studentService.sendSimpleMessage2(list, "", "",1);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/{projectId}")
    public ResponseEntity<Project> getProjectList(@PathVariable("projectId") Long projectId) {
        Project project = projectService.findProById(projectId);
        if (project == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(project, HttpStatus.OK);
    }

    /**
     * Created by: NuongHT
     * Date create: 29/03/2023
     * Function: tạo api get all topic value -> browser/cancel topic
     * @return HttpStatus.NO_CONTENT if result is isEmty or HttpStatus.OK if result is Emty.
     */

    @GetMapping("/listPage")
    public ResponseEntity<Page<Team>> getStudentList(@PageableDefault(size = 2) Pageable pageable) {
        Page<Team> teamPage = teamService.findPagePro(pageable);
        if (teamPage.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(teamPage, HttpStatus.OK);
    }


//    @GetMapping("/listPro")
//    public ResponseEntity<List<Team>> getProjectList() {
//        List<Team> teams = projectService.findAllPro();
//        if (teams.isEmpty()) {
//            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//        }
//        return new ResponseEntity<>(teams, HttpStatus.OK);
//    }
}
