package com.digipds.transaction_item_service.entity;

import java.math.BigDecimal;

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
@Table(name = "transaction_items")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TransactionItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long transactionItemId;

    @Column(nullable = false)
    private Long transactionId; // FK → TRANSACTION

    @Column(nullable = false)
    private Long commodityId;   // FK → COMMODITY

    @Column(nullable = false)
    private BigDecimal quantityPurchased;

    @Column(nullable = false)
    private BigDecimal unitPrice;

    private BigDecimal subsidizedPrice;
    private BigDecimal lineTotal;

}
