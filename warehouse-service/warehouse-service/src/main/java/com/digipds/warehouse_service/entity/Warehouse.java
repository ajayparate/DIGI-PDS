package com.digipds.warehouse_service.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "warehouses")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Warehouse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer warehouseId;

    @Column(nullable = false, unique = true)
    private String warehouseCode;

    @Column(nullable = false)
    private String warehouseName;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private WarehouseType warehouseType;

    private String addressLine1;
    private String addressLine2;
    private String city;
    private String state;
    private String pincode;

    private BigDecimal capacityInTons;

    @Column(nullable = false)
    private Long managerUserId; // FK to USER service

    
    private Boolean isOperational = true;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

}
