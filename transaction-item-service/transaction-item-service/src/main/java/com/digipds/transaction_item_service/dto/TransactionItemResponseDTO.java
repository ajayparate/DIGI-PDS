package com.digipds.transaction_item_service.dto;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TransactionItemResponseDTO {
    private Long transactionItemId;
    private Long transactionId;
    private Long commodityId;
    private BigDecimal quantityPurchased;
    private BigDecimal unitPrice;
    private BigDecimal subsidizedPrice;
    private BigDecimal lineTotal;

}
