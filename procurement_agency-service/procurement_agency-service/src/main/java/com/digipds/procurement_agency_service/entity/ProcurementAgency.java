package com.digipds.procurement_agency_service.entity;

import java.time.LocalDateTime;

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
@Table(name = "procurement_agencies")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProcurementAgency {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer supplierId;

    @Column(nullable = false)
    private String agencyName;

    private String contactPerson;
    private String phoneNumber;
    private String email;

    @Column(columnDefinition = "TEXT")
    private String address;

    private String licenseNumber;

    private Boolean isApproved = false;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

}
