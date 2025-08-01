package com.digipds.notificationlog_service.service;

import java.util.List;

import com.digipds.notificationlog_service.dto.APIResponseDTO;
import com.digipds.notificationlog_service.dto.NotificationLogDTO;
import com.digipds.notificationlog_service.entity.NotificationLog;

public interface NotificationLogService {
    APIResponseDTO createNotification(NotificationLogDTO dto);
    List<NotificationLog> getAll();
    NotificationLog getById(Long id);
    APIResponseDTO delete(Long id);

}
