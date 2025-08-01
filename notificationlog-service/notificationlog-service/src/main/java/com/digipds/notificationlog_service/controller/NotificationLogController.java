package com.digipds.notificationlog_service.controller;

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

import com.digipds.notificationlog_service.dto.APIResponseDTO;
import com.digipds.notificationlog_service.dto.NotificationLogDTO;
import com.digipds.notificationlog_service.entity.NotificationLog;
import com.digipds.notificationlog_service.service.NotificationLogService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/notifications")
@RequiredArgsConstructor
public class NotificationLogController {
    private final NotificationLogService service;

    @PostMapping
    public ResponseEntity<APIResponseDTO> create(@RequestBody NotificationLogDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.createNotification(dto));
    }

    @GetMapping
    public ResponseEntity<List<NotificationLog>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<NotificationLog> getById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<APIResponseDTO> delete(@PathVariable Long id) {
        return ResponseEntity.ok(service.delete(id));
    }

}
