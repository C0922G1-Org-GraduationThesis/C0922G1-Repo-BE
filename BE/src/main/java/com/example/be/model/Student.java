package com.example.be.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_id")
    private Long studentId;
    @Column(columnDefinition = "varchar(50)", nullable = false)
    private String studentName;
    @Column(columnDefinition = "varchar(50)", nullable = false, unique = true)
    private String studentCode;
    @Column(columnDefinition = "varchar(50)", nullable = false)
    private String dateOfBirth;
    @Column(columnDefinition = "varchar(50)", nullable = false, unique = true)
    private String email;
    @Column(columnDefinition = "varchar(50)", nullable = false, unique = true)
    private String phoneNumber;
    @Column(columnDefinition = "bit(1)", nullable = false)
    private boolean studentGender;
    @Column(columnDefinition = "varchar(50)", nullable = false)
    private String studentAddress;
    @Column(columnDefinition = "text", nullable = false)
    private String img;
    @Column(columnDefinition = "bit(1)")
    private boolean flagDelete;
    @OneToOne
    @JoinColumn(name = "account_id", referencedColumnName = "account_id")
    private Account account;
    @ManyToOne
    @JoinColumn(name = "clazz_id", referencedColumnName = "clazz_id")
    private Clazz clazz;
    @ManyToOne
    @JoinColumn(name = "team_id", referencedColumnName = "team_id")
    private Team team;
    @OneToMany(mappedBy = "student")
    @JsonIgnore
    private Set<StudentAnnouncement> studentAnnouncementSet;
    @OneToMany(mappedBy = "student")
    @JsonIgnore
    private Set<QuestionAndAnswer> questionAndAnswerSet;

    public Student() {
    }

    public Set<QuestionAndAnswer> getQuestionAndAnswerSet() {
        return questionAndAnswerSet;
    }

    public void setQuestionAndAnswerSet(Set<QuestionAndAnswer> questionAndAnswerSet) {
        this.questionAndAnswerSet = questionAndAnswerSet;
    }

    public Set<StudentAnnouncement> getStudentAnnouncementSet() {
        return studentAnnouncementSet;
    }

    public void setStudentAnnouncementSet(Set<StudentAnnouncement> studentAnnouncementSet) {
        this.studentAnnouncementSet = studentAnnouncementSet;
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentCode() {
        return studentCode;
    }

    public void setStudentCode(String studentCode) {
        this.studentCode = studentCode;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public boolean isStudentGender() {
        return studentGender;
    }

    public void setStudentGender(boolean studentGender) {
        this.studentGender = studentGender;
    }

    public String getStudentAddress() {
        return studentAddress;
    }

    public void setStudentAddress(String studentAddress) {
        this.studentAddress = studentAddress;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public boolean isFlagDelete() {
        return flagDelete;
    }

    public void setFlagDelete(boolean flagDelete) {
        this.flagDelete = flagDelete;
    }


    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Clazz getClazz() {
        return clazz;
    }

    public void setClazz(Clazz clazz) {
        this.clazz = clazz;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }
}
