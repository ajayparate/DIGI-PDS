package com.digipds.notificationlog_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.digipds.notificationlog_service.entity.NotificationLog;

public interface NotificationLogRepository extends JpaRepository<NotificationLog,Long> {

}
