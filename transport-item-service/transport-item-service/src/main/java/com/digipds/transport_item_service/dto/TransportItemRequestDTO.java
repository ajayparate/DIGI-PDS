package com.digipds.transport_item_service.dto;

import java.math.BigDecimal;

import com.digipds.transport_item_service.entity.ConditionOnDelivery;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TransportItemRequestDTO {
    private Long transportOrderId;
    private Long commodityId;
    private BigDecimal quantityDispatched;
    private BigDecimal quantityReceived;
    private String batchNumber;
    private ConditionOnDelivery conditionOnDelivery;

}
