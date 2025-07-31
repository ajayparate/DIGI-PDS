package com.digipds.transaction_service.entity;

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
@Table(name = "transactions")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long transactionId;

    @Column(unique = true, nullable = false)
    private String transactionNumber;

    @Column(nullable = false)
    private Long fpsId; // FK to FairPriceShop (external)

    @Column(nullable = false)
    private Long rationCardId; // FK to RationCard (external)

    @Column(nullable = false)
    private Long servedByUserId; // FK to USER (FPS owner)

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TransactionType transactionType;

    private BigDecimal totalAmount;
    private BigDecimal subsidyAmount;
    private BigDecimal netPayable;

    @Enumerated(EnumType.STRING)
    private TransactionStatus status;

    private LocalDateTime transactionDate;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

}
