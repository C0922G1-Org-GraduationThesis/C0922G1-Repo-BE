package com.example.be.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "team_id")
    private Long teamId;
    @Column(columnDefinition = "varchar(50)", nullable = false, unique = true)
    private String teamName;
    @Column( nullable = false)
    private int memberOfTeam;
    @OneToOne
    @JoinColumn(name = "teacher_id", referencedColumnName = "teacher_id")
    private Teacher teacher;
    @OneToOne(mappedBy = "team")
    private Project project;
    @OneToMany(mappedBy = "team")
    private Set<Student> studentSet;

    public Team() {
    }

    public int getMemberOfTeam() {
        return memberOfTeam;
    }

    public void setMemberOfTeam(int memberOfTeam) {
        this.memberOfTeam = memberOfTeam;
    }

    public Long getTeamId() {
        return teamId;
    }

    public Set<Student> getStudentSet() {
        return studentSet;
    }

    public void setStudentSet(Set<Student> studentSet) {
        this.studentSet = studentSet;
    }

    public void setTeamId(Long teamId) {
        this.teamId = teamId;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }
}
