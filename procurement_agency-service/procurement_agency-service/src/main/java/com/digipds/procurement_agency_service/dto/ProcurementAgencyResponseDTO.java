package com.digipds.procurement_agency_service.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProcurementAgencyResponseDTO {

    private Integer supplierId;
    private String agencyName;
    private String contactPerson;
    private String phoneNumber;
    private String email;
    private String address;
    private String licenseNumber;
    private Boolean isApproved;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

}
