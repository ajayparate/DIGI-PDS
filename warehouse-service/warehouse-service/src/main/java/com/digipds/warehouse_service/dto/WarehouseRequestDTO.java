package com.digipds.warehouse_service.dto;

import java.math.BigDecimal;

import com.digipds.warehouse_service.entity.WarehouseType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class WarehouseRequestDTO {
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

}
