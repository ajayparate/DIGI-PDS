package com.digipds.transport_order_service.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class APIResponseDTO {
    private int statusCode;
    private String message;
    private LocalDateTime timestamp;
    private Object data;
}