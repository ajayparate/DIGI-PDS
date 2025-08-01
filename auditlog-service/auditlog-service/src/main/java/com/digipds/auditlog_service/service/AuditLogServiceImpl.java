package com.digipds.auditlog_service.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.digipds.auditlog_service.dto.AuditLogDTO;
import com.digipds.auditlog_service.entity.AuditLog;
import com.digipds.auditlog_service.exception.ResourceNotFoundException;
import com.digipds.auditlog_service.repository.AuditLogRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuditLogServiceImpl implements AuditLogService {
    private final AuditLogRepository repository;

    @Override
    public AuditLog createLog(AuditLogDTO dto) {
        AuditLog log = AuditLog.builder()
                .userId(dto.getUserId())
                .tableName(dto.getTableName())
                .recordId(dto.getRecordId())
                .action(dto.getAction())
                .oldValues(dto.getOldValues())
                .newValues(dto.getNewValues())
                .ipAddress(dto.getIpAddress())
                .userAgent(dto.getUserAgent())
                .timestamp(dto.getTimestamp())
                .build();
        return repository.save(log);
    }

    @Override
    public AuditLog getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Audit Log not found with ID: " + id));
    }

    @Override
    public List<AuditLog> getAll() {
        return repository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Audit Log not found with ID: " + id);
        }
        repository.deleteById(id);
    }

}
