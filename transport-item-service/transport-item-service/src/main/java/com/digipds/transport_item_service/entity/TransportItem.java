package com.digipds.transport_item_service.entity;

import java.math.BigDecimal;

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
@Table(name = "transport_items")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TransportItem {
     @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long transportItemId;

    @Column(nullable = false)
    private Long transportOrderId;  // FK to TRANSPORT_ORDER

    @Column(nullable = false)
    private Long commodityId;       // FK to COMMODITY

    private BigDecimal quantityDispatched;

    private BigDecimal quantityReceived;

    private String batchNumber;

    @Enumerated(EnumType.STRING)
    private ConditionOnDelivery conditionOnDelivery;

}
