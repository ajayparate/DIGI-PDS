package com.digipds.transport_order_service.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class TransportOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long transportOrderId;

    @Column(nullable = false, unique = true)
    private String orderNumber;

    @Column(nullable = false)
    private Long sourceWarehouseId; // FK to WAREHOUSE

    @Column(nullable = false)
    private Long destinationFpsId; // FK to FAIR_PRICE_SHOP

    private String vehicleNumber;
    private String driverName;
    private String driverPhone;

    private LocalDate dispatchDate;
    private LocalDate expectedDeliveryDate;
    private LocalDate actualDeliveryDate;

    @Enumerated(EnumType.STRING)
    private TransportStatus status;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

}
