package com.digipds.auditlog_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.digipds.auditlog_service.entity.AuditLog;

public interface AuditLogRepository extends JpaRepository<AuditLog, Long> {

}
