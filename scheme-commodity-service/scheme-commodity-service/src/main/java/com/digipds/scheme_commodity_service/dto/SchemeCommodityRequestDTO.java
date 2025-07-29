package com.digipds.scheme_commodity_service.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class SchemeCommodityRequestDTO {
    private Long schemeId;
    private Long commodityId;
    private Double quantityPerPerson;
    private Double subsidizedRate;
    private Double marketRate;
    private Boolean isActive;
    private LocalDate effectiveFrom;
    private LocalDate effectiveTo;
}
