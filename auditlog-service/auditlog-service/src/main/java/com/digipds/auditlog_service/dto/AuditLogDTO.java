package com.digipds.auditlog_service.dto;

import java.time.LocalDateTime;

import com.digipds.auditlog_service.entity.ActionType;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuditLogDTO {
    // @Column(unique = trues)
    private Long userId;
    private String tableName;
    private Long recordId;
    private ActionType action;
    private String oldValues;
    private String newValues;
    private String ipAddress;
    private String userAgent;
    private LocalDateTime timestamp;

}
