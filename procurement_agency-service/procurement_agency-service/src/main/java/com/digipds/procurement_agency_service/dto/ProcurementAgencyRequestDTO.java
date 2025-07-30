package com.digipds.procurement_agency_service.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProcurementAgencyRequestDTO {
    @NotBlank(message = "Agency name is required")
    private String agencyName;

    private String contactPerson;
    private String phoneNumber;

    @Email(message = "Invalid email format")
    private String email;

    private String address;
    private String licenseNumber;
    private Boolean isApproved = false;

}
