package com.example.be.repository;

import com.example.be.model.NotificationTeacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface INotificationRepository extends JpaRepository<NotificationTeacher, Long> {

    @Transactional
    @Modifying
    @Query(value =
            "insert into notification_teacher (notification_teacher_name, notification_teacher_content) " +
                    "    value (:notificationTeacherName,:notificationTeacherTime);",
            nativeQuery = true)
    void addNotificationTeacher(@Param("notificationTeacherName") String notificationTeacherName, @Param("notificationTeacherTime") String notificationTeacherTime);


}
