package com.digipds.notificationlog_service.dto;

import java.time.LocalDateTime;

import com.digipds.notificationlog_service.entity.DeliveryStatus;
import com.digipds.notificationlog_service.entity.NotificationType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class NotificationLogDTO {
    private Long userId;
    private NotificationType notificationType;
    private String title;
    private String message;
    private DeliveryStatus deliveryStatus;
    private LocalDateTime sentAt;
    private LocalDateTime deliveredAt;
    private Long relatedTransactionId;
    private Long relatedGrievanceId;

}
