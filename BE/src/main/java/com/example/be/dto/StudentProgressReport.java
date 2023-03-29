package com.example.be.dto;



public class StudentProgressReport {
    private String progress_report_content;
    private String progress_report_file;
    private String progress_report_date;
    private String leader_name;

    public StudentProgressReport() {
    }

    public StudentProgressReport(String progress_report_content, String progress_report_file, String progress_report_date, String leader_name) {
        this.progress_report_content = progress_report_content;
        this.progress_report_file = progress_report_file;
        this.progress_report_date = progress_report_date;
        this.leader_name = leader_name;
    }

    public String getProgress_report_content() {
        return progress_report_content;
    }

    public void setProgress_report_content(String progress_report_content) {
        this.progress_report_content = progress_report_content;
    }

    public String getProgress_report_file() {
        return progress_report_file;
    }

    public void setProgress_report_file(String progress_report_file) {
        this.progress_report_file = progress_report_file;
    }

    public String getProgress_report_date() {
        return progress_report_date;
    }

    public void setProgress_report_date(String progress_report_date) {
        this.progress_report_date = progress_report_date;
    }

    public String getLeader_name() {
        return leader_name;
    }

    public void setLeader_name(String leader_name) {
        this.leader_name = leader_name;
    }
}
