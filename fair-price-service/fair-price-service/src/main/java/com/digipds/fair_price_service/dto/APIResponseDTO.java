package com.digipds.fair_price_service.dto;

import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class APIResponseDTO {
    private int statusCode;
    private String message;
    private LocalDateTime timestamp;

}
