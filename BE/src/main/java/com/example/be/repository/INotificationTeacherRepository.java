package com.example.be.repository;

import com.example.be.model.NotificationTeacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface INotificationTeacherRepository extends JpaRepository<NotificationTeacher, Long> {
    @Query(value = "select * from notification_teacher", nativeQuery = true)
    List<NotificationTeacher> getAllNotificationTeacher();
}
