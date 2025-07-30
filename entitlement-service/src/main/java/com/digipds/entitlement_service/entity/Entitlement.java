package com.digipds.entitlement_service.entity;

import java.time.LocalDateTime;
import java.util.Date;

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
@Table(name = "entitlement")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Entitlement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long entitlementId;

    @Column(nullable = false)
    private Long rationCardId; // FK → RATION_CARD

    @Column(nullable = false)
    private Long schemeCommodityId; // FK → SCHEME_COMMODITY

    @Column(nullable = false)
    private Double monthlyQuota;

    @Column(nullable = false)
    private Double consumedQuantity;

    @Column(nullable = false)
    private Double remainingQuota;

    private Date resetDate;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

}
