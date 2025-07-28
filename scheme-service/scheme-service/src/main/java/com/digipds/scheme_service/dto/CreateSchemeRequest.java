package com.digipds.scheme_service.dto;

import java.time.LocalDate;

import com.digipds.scheme_service.entity.SchemeType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateSchemeRequest {
    private String schemeName;
    private String description;
    private SchemeType schemeType;
    private LocalDate startDate;
    private LocalDate endDate;
    private Boolean isActive;
    private String eligibilityCriteria;

}
