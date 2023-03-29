package com.example.be.service;

import com.example.be.dto.StudentDto;
import com.example.be.model.Project;
import com.example.be.repository.IProjectRepository;
import com.example.be.repository.IStudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class StudentService implements IStudentService {

    @Autowired
    private JavaMailSender emailSender;

    @Autowired
    private IStudentRepository iStudentRepository;

    @Autowired
    private IProjectRepository iProjectRepository;

    /**
     * Created by: NuongHT
     * Date create: 29/03/2023
     */

    public String getProjectTitle(long projectId) {
        // Thực hiện truy vấn cơ sở dữ liệu để lấy thông tin về đề tài
        Project project = iProjectRepository.findProById(projectId);
        if (project != null) {
            // Trả về tên của đề tài
            return project.getName();
        } else {
            return null;
        }
    }

    /**
     * Created by: NuongHT
     * Date create: 29/03/2023
     */
    public String getTeam(long projectId) {
        // Thực hiện truy vấn cơ sở dữ liệu để lấy thông tin về đề tài
        Project project = iProjectRepository.findProById(projectId);
        if (project != null) {
            // Trả về tên của đề tài
            return project.getTeam().getTeamName();
        } else {
            return null;
        }
    }

    /**
     * Created by: NuongHT
     * Date create: 29/03/2023
     */
    public void sendSimpleMessage(
            List<StudentDto> mailList, String subject, String text,long projectId) {
        String[] arrayEmail = new String[mailList.size()];
        for (int i = 0; i < mailList.size(); i++) {
            arrayEmail[i] = mailList.get(i).getEmail();
        }
//        SimpleMailMessage message = new SimpleMailMessage();
//        message.setFrom("nuongho.160304@gmail.com");
//        message.setTo(arrayEmail);
//        message.setSubject(subject);
//        message.setText(text);
//        emailSender.send(message);

        // Lấy tên của đề tài
        String projectTitle = getProjectTitle(projectId);
        String teamName = getTeam(projectId);
        if (projectTitle != null) {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom("nuongho.160304@gmail.com");
            message.setTo(arrayEmail);
            message.setSubject(subject);
//            message.setText(text);
//            emailSender.send(message);
            message.setText("Xin chào các thành viên " + teamName
                    + "\nĐề tài " + projectTitle +"của các bạn"
                    + "\nquá ok được duyệt.");
            // ...
            emailSender.send(message);

        }
    }

    /**
     * Created by: NuongHT
     * Date create: 29/03/2023
     */
    public void sendSimpleMessage2(
            List<StudentDto> mailList, String subject, String text,long projectId) {
        String[] arrayEmail = new String[mailList.size()];
        for (int i = 0; i < mailList.size(); i++) {
            arrayEmail[i] = mailList.get(i).getEmail();
        }


//        SimpleMailMessage message = new SimpleMailMessage();
//        message.setFrom("nuongho.160304@gmail.com");
//        message.setTo(arrayEmail);
//        message.setSubject(subject);
//        message.setText(text);
//        emailSender.send(message);

        // Lấy team, tên của đề tài.
        String projectTitle = getProjectTitle(projectId);
        String teamName = getTeam(projectId);
        if (projectTitle != null) {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom("nuongho.160304@gmail.com");
            message.setTo(arrayEmail);
            message.setSubject(subject);
//            message.setText(text);
//            emailSender.send(message);
            message.setText("Xin chào các thành viên " + teamName
                    + "\nĐề tài " + projectTitle +"của các bạn"
                    + "\nbị từ chối duyệt. ");
            // ...
            emailSender.send(message);

        }
    }

    /**
     * Created by: NuongHT
     * Date create: 29/03/2023
     */

    @Override
    public List<StudentDto> getInfomation(Long teamId) {
        return iStudentRepository.getInfomation(teamId);
    }
}
