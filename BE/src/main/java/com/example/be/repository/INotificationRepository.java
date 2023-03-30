package com.example.be.repository;

import com.example.be.model.NotificationTeacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;

public interface INotificationRepository extends JpaRepository<NotificationTeacher, Long> {

    /**
     * Create by: TuanNDN
     * Date created: 29/03/2023
     * Function: show List NotificationTeacher
     *
     * @param 'notificationTeacherName'
     * @param 'notificationTeacherContent'
     * @return HttpStatus.BAD_REQUEST if result is error or HttpStatus. OK if result is not error
     */
    @Transactional
    @Modifying
    @Query(value =
            "insert into notification_teacher (notification_teacher_name, notification_teacher_content) " +
                    "    value (:notificationTeacherName,:notificationTeacherContent);",
            nativeQuery = true)
    void addNotificationTeacher(@Param("notificationTeacherName") String notificationTeacherName, @Param("notificationTeacherContent") String notificationTeacherContent);


}
