package com.example.be.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.websocket.ClientEndpoint;
import java.util.List;
import java.util.Set;

@Entity
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "account_id")
    private Long accountId;
    @Column(columnDefinition = "varchar(120)", nullable = false)
    private String password;
    @Column(columnDefinition = "varchar(50)", unique = true, nullable = false)
    private String email;
    @OneToMany(mappedBy = "account")
    @JsonIgnore
    private Set<AccountRole> accountRoleList;
    @OneToOne(mappedBy = "account")
    private Teacher teacher;
    @OneToOne(mappedBy = "account")
    private Student student;

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Set<AccountRole> getAccountRoleList() {
        return accountRoleList;
    }

    public void setAccountRoleList(Set<AccountRole> accountRoleList) {
        this.accountRoleList = accountRoleList;
    }

    public Account() {
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
