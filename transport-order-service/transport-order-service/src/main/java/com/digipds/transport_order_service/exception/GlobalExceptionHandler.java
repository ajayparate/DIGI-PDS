package com.digipds.transport_order_service.exception;

import java.time.LocalDateTime;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.digipds.transport_order_service.dto.APIResponseDTO;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<APIResponseDTO> handleNotFound(ResourceNotFoundException ex) {
        return ResponseEntity.status(404).body(
                APIResponseDTO.builder()
                        .statusCode(404)
                        .message(ex.getMessage())
                        .timestamp(LocalDateTime.now())
                        .build()
        );
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<APIResponseDTO> handleAll(Exception ex) {
        return ResponseEntity.status(500).body(
                APIResponseDTO.builder()
                        .statusCode(500)
                        .message("Internal server error: " + ex.getMessage())
                        .timestamp(LocalDateTime.now())
                        .build()
        );
    }

}
