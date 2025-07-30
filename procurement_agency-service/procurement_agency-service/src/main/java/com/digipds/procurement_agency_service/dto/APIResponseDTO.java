package com.digipds.procurement_agency_service.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class APIResponseDTO<T> {
    private int statusCode;
    private String message;
    private LocalDateTime timestamp;
    private T data;

}
