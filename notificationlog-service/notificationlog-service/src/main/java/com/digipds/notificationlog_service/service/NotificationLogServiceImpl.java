package com.digipds.notificationlog_service.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.digipds.notificationlog_service.dto.APIResponseDTO;
import com.digipds.notificationlog_service.dto.NotificationLogDTO;
import com.digipds.notificationlog_service.entity.NotificationLog;
import com.digipds.notificationlog_service.exception.ResourceNotFoundException;
import com.digipds.notificationlog_service.repository.NotificationLogRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class NotificationLogServiceImpl implements NotificationLogService{
    private final NotificationLogRepository repository;

    @Override
    public APIResponseDTO createNotification(NotificationLogDTO dto) {
        NotificationLog log = NotificationLog.builder()
                .userId(dto.getUserId())
                .notificationType(dto.getNotificationType())
                .title(dto.getTitle())
                .message(dto.getMessage())
                .deliveryStatus(dto.getDeliveryStatus())
                .sentAt(dto.getSentAt())
                .deliveredAt(dto.getDeliveredAt())
                .relatedTransactionId(dto.getRelatedTransactionId())
                .relatedGrievanceId(dto.getRelatedGrievanceId())
                .createdAt(LocalDateTime.now())
                .build();

        repository.save(log);

        return APIResponseDTO.builder()
                .statusCode(HttpStatus.CREATED.value())
                .message("Notification Log Created")
                .timestamp(LocalDateTime.now())
                .build();
    }

    @Override
    public List<NotificationLog> getAll() {
        return repository.findAll();
    }

    @Override
    public NotificationLog getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Notification not found with id " + id));
    }

    @Override
    public APIResponseDTO delete(Long id) {
        repository.deleteById(id);
        return new APIResponseDTO(HttpStatus.OK.value(), "Notification deleted", LocalDateTime.now(),delete(id));
    }


}
