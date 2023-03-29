package com.example.be.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.websocket.ClientEndpoint;
import java.util.Set;

@Entity
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "account_id")
    private Long accountId;
    @Column(columnDefinition = "varchar(50)",nullable = false)
    private String password;
    @Column(columnDefinition = "varchar(50)", unique = true,nullable = false)
    private String email;
    @OneToMany(mappedBy = "account")
    @JsonIgnore
    private Set<AccountRole> accountRoleSet;
    @OneToOne(mappedBy = "account")
    private Teacher teacher;
//    @OneToOne(mappedBy = "account")
//    private Student student;
    @OneToOne(mappedBy = "account")
    private Admin admin;

    public Account() {
    }

    public Account(Long accountId, String password, String email, Set<AccountRole> accountRoleSet, Teacher teacher, Admin admin) {
        this.accountId = accountId;
        this.password = password;
        this.email = email;
        this.accountRoleSet = accountRoleSet;
        this.teacher = teacher;
        this.admin = admin;
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

    public Set<AccountRole> getAccountRoleSet() {
        return accountRoleSet;
    }

    public void setAccountRoleSet(Set<AccountRole> accountRoleSet) {
        this.accountRoleSet = accountRoleSet;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }
}
