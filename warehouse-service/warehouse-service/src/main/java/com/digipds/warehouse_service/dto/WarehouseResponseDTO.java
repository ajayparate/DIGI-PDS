package com.digipds.warehouse_service.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.digipds.warehouse_service.entity.WarehouseType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class WarehouseResponseDTO {
    private Integer warehouseId;
    private String warehouseCode;
    private String warehouseName;
    private WarehouseType warehouseType;
    private String addressLine1;
    private String addressLine2;
    private String city;
    private String state;
    private String pincode;
    private BigDecimal capacityInTons;
    private Long managerUserId;
    private Boolean isOperational;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

}
