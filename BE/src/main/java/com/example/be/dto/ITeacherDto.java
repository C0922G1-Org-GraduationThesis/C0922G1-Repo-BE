package com.example.be.dto;
/**
 * tên : phan văn hùng
 * nội dung: tạo interface để lấy các trường cần hiển thị
 *
 */
public interface ITeacherDto {
    String getTeacherId();
    String getTeacherName();
    String getTeacherCode();
    String getTeacherImg();
    String getTeacherPhoneNumber();
    String getTeacherEmail();
    String getFaculty();
    String getDegree();
}
