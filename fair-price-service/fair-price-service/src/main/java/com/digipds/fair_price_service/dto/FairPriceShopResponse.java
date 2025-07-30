package com.digipds.fair_price_service.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FairPriceShopResponse {
    private Integer fpsId;
    private String fpsCode;
    private String shopName;
    private Long ownerUserId;
    private String licenseNumber;
    private String addressLine1;
    private String addressLine2;
    private String city;
    private String state;
    private String pincode;
    private Integer maxDailyCustomers;
    private String operatingHours;
    private Long assignedWarehouseId;
    private Boolean isOperational;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

}
