package com.digipds.entitlement_service.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EntitlementDto {
    private Long rationCardId;
    private Long schemeCommodityId;
    private Double monthlyQuota;
    private Double consumedQuantity;
    private Double remainingQuota;
    private Date resetDate;

}
