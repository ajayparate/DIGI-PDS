package com.digipds.auditlog_service.service;

import java.util.List;

import com.digipds.auditlog_service.dto.AuditLogDTO;
import com.digipds.auditlog_service.entity.AuditLog;

public interface AuditLogService {
    AuditLog createLog(AuditLogDTO dto);
    AuditLog getById(Long id);
    List<AuditLog> getAll();
    void deleteById(Long id);

}
