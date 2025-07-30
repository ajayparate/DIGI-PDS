package com.digipds.stock_item_service.entity;

import java.math.BigDecimal;
import java.time.LocalDate;
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
@Table(name = "stock_items")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StockItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long stockItemId;

    @Column(nullable = false)
    private Long warehouseId; // FK to WAREHOUSE (microservice call or manual validation)

    @Column(nullable = false)
    private Long commodityId; // FK to COMMODITY (microservice call or manual validation)

    private String batchNumber;

    @Column(nullable = false)
    private BigDecimal quantityInStock;

    @Enumerated(EnumType.STRING)
    private QualityGrade qualityGrade;

    private LocalDate procurementDate;
    private LocalDate expiryDate;

    private BigDecimal costPerUnit;

    private Long supplierId; // FK to PROCUREMENT_AGENCY

    private LocalDateTime lastUpdated;

}
