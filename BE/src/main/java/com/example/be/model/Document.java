package com.example.be.model;

import javax.persistence.*;

@Entity
public class Document {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long documentId;
    private String documentName;
    private String documentDescribe;
    private boolean flag = true;
    @ManyToOne
    @JoinColumn(name = "teacher_id",referencedColumnName = "teacher_id")
    private Teacher teacher;

    public Document() {
    }

    public Long getDocumentId() {
        return documentId;
    }

    public void setDocumentId(Long documentId) {
        this.documentId = documentId;
    }

    public String getDocumentName() {
        return documentName;
    }

    public void setDocumentName(String documentName) {
        this.documentName = documentName;
    }

    public String getDocumentDescribe() {
        return documentDescribe;
    }

    public void setDocumentDescribe(String documentDescribe) {
        this.documentDescribe = documentDescribe;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }
}
