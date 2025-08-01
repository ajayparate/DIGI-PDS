package com.digipds.auditlog_service.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class APIResponseDTO {

    private int statusCode;
    private String message;
    private LocalDateTime timestamp;
    private Object data;

}
