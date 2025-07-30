package com.digipds.stock_item_service.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.digipds.stock_item_service.entity.QualityGrade;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StockItemRequestDTO {
    private Long warehouseId;
    private Long commodityId;
    private String batchNumber;
    private BigDecimal quantityInStock;
    private QualityGrade qualityGrade;
    private LocalDate procurementDate;
    private LocalDate expiryDate;
    private BigDecimal costPerUnit;
    private Long supplierId;

}
