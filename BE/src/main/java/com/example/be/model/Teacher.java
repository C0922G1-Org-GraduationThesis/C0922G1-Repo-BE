package com.example.be.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "teacher_id")
    private Long teacherId;
    @Column(columnDefinition = "varchar(50)", nullable = false, unique = true)
    private String teacherCode;
    @Column(columnDefinition = "varchar(50)", nullable = false)
    private String teacherName;
    @Column(columnDefinition = "varchar(50)", nullable = false)
    private String dateOfBirth;
    @Column(columnDefinition = "varchar(50)", nullable = false, unique = true)
    private String email;
    @Column(columnDefinition = "varchar(50)", nullable = false, unique = true)
    private String phoneNumber;
    @Column(columnDefinition = "bit(1)", nullable = false)
    private boolean teacherGender;
    @Column(columnDefinition = "varchar(50)", nullable = false)
    private String teacherAddress;
    @Column(columnDefinition = "text", nullable = false)
    private String img;
    @Column(columnDefinition = "bit(1)")
    private boolean flagDelete;
    @ManyToOne
    @JoinColumn(name = "faculty_id", referencedColumnName = "faculty_id")
    private Faculty faculty;
    @ManyToOne
    @JoinColumn(name = "degree_id", referencedColumnName = "degree_id")
    private Degree degree;
    @OneToOne
    @JoinColumn(name = "account_id", referencedColumnName = "account_id")
    private Account account;
    @OneToOne(mappedBy = "teacher")
    private Team team;
    @OneToMany(mappedBy = "teacher")
    @JsonIgnore
    private Set<NotificationTeacher> notificationTeacherSet;
    @OneToOne(mappedBy = "teacher")
    private Clazz clazz;
    @OneToMany(mappedBy = "teacher")
    @JsonIgnore
    private Set<Document> documentSet;

    public Teacher() {
    }

    public boolean isFlagDelete() {
        return flagDelete;
    }

    public void setFlagDelete(boolean flagDelete) {
        this.flagDelete = flagDelete;
    }


    public Clazz getClazz() {
        return clazz;
    }

    public void setClazz(Clazz clazz) {
        this.clazz = clazz;
    }

    public Set<NotificationTeacher> getNotificationTeacherSet() {
        return notificationTeacherSet;
    }

    public void setNotificationTeacherSet(Set<NotificationTeacher> notificationTeacherSet) {
        this.notificationTeacherSet = notificationTeacherSet;
    }


    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public Long getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Long teacherId) {
        this.teacherId = teacherId;
    }

    public String getTeacherCode() {
        return teacherCode;
    }

    public void setTeacherCode(String teacherCode) {
        this.teacherCode = teacherCode;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
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

    public boolean isTeacherGender() {
        return teacherGender;
    }

    public void setTeacherGender(boolean teacherGender) {
        this.teacherGender = teacherGender;
    }

    public String getTeacherAddress() {
        return teacherAddress;
    }

    public void setTeacherAddress(String teacherAddress) {
        this.teacherAddress = teacherAddress;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public Faculty getFaculty() {
        return faculty;
    }

    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }

    public Degree getDegree() {
        return degree;
    }

    public void setDegree(Degree degree) {
        this.degree = degree;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Set<Document> getDocumentSet() {
        return documentSet;
    }

    public void setDocumentSet(Set<Document> documentSet) {
        this.documentSet = documentSet;
    }
}

