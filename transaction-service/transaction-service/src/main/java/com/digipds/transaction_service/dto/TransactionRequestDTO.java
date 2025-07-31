package com.digipds.transaction_service.dto;

import java.math.BigDecimal;

import com.digipds.transaction_service.entity.TransactionStatus;
import com.digipds.transaction_service.entity.TransactionType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TransactionRequestDTO {
    private String transactionNumber;
    private Long fpsId;
    private Long rationCardId;
    private Long servedByUserId;
    private TransactionType transactionType;

    private BigDecimal totalAmount;
    private BigDecimal subsidyAmount;
    private BigDecimal netPayable;
    private TransactionStatus status;

}
