package com.digipds.auditlog_service.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.digipds.auditlog_service.dto.APIResponseDTO;
import com.digipds.auditlog_service.dto.AuditLogDTO;
import com.digipds.auditlog_service.entity.AuditLog;
import com.digipds.auditlog_service.service.AuditLogService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/audit-logs")
@RequiredArgsConstructor
public class AuditLogController {
     private final AuditLogService auditLogService;

    @PostMapping
    public ResponseEntity<APIResponseDTO> create(@RequestBody AuditLogDTO dto) {
        auditLogService.createLog(dto);
        return new ResponseEntity<>(
                APIResponseDTO.builder()
                        .statusCode(HttpStatus.CREATED.value())
                        .message("Audit Log created")
                        .timestamp(LocalDateTime.now())
                        .data(dto)
                        .build(),
                HttpStatus.CREATED
        );
    }

    @GetMapping
    public ResponseEntity<List<AuditLog>> getAll() {
        return ResponseEntity.ok(auditLogService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AuditLog> getById(@PathVariable Long id) {
        return ResponseEntity.ok(auditLogService.getById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<APIResponseDTO> delete(@PathVariable Long id) {
        auditLogService.deleteById(id);
        return ResponseEntity.ok(
                APIResponseDTO.builder()
                        .statusCode(HttpStatus.OK.value())
                        .message("Audit Log deleted")
                        .timestamp(LocalDateTime.now())
                        .build()
        );
    }

}
