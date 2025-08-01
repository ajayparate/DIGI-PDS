package com.digipds.fair_price_service.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "fair_price_shops")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FairPriceShop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer fpsId;

    @Column(nullable = false, unique = true)
    private String fpsCode;

    @Column(nullable = false)
    private String shopName;

    @Column(nullable = false)
    private Long ownerUserId; // FK to USER service

    private String licenseNumber;

    private String addressLine1;
    private String addressLine2;
    private String city;
    private String state;
    private String pincode;

    private Integer maxDailyCustomers;
    private String operatingHours;
     @Column(nullable = false)
    private Long assignedWarehouseId; // FK to Warehouse

    @Builder.Default
    private Boolean isOperational = true;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

}
