package com.digipds.procurement_agency_service.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.digipds.procurement_agency_service.dto.ProcurementAgencyRequestDTO;
import com.digipds.procurement_agency_service.dto.ProcurementAgencyResponseDTO;
import com.digipds.procurement_agency_service.entity.ProcurementAgency;
import com.digipds.procurement_agency_service.repository.ProcurementAgencyRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProcurementAgencyService {
    private final ProcurementAgencyRepository repository;

    public ProcurementAgencyResponseDTO create(ProcurementAgencyRequestDTO request) {
    ProcurementAgency agency = ProcurementAgency.builder()
        .agencyName(request.getAgencyName())
        .contactPerson(request.getContactPerson())
        .phoneNumber(request.getPhoneNumber())
        .email(request.getEmail())
        .address(request.getAddress())
        .licenseNumber(request.getLicenseNumber())
        .isApproved(request.getIsApproved())
        .createdAt(LocalDateTime.now())
        .updatedAt(LocalDateTime.now())
        .build();

    ProcurementAgency saved = repository.save(agency);
    return mapToResponse(saved);
}

    public List<ProcurementAgency> getAll() {
        return repository.findAll();
    }

    public ProcurementAgency getById(Integer id) {
        return repository.findById(id.longValue()).orElseThrow(() -> new RuntimeException("Agency not found"));
    }

    public ProcurementAgency update(Integer id, ProcurementAgency updated) {
        ProcurementAgency existing = getById(id);
        updated.setSupplierId(existing.getSupplierId());
        updated.setCreatedAt(existing.getCreatedAt());
        updated.setUpdatedAt(LocalDateTime.now());
        return repository.save(updated);
    }

    public void delete(Integer id) {
        repository.deleteById(id.longValue());
    }

    private ProcurementAgencyResponseDTO mapToResponse(ProcurementAgency agency) {
    return ProcurementAgencyResponseDTO.builder()
        .supplierId(agency.getSupplierId())
        .agencyName(agency.getAgencyName())
        .contactPerson(agency.getContactPerson())
        .phoneNumber(agency.getPhoneNumber())
        .email(agency.getEmail())
        .address(agency.getAddress())
        .licenseNumber(agency.getLicenseNumber())
        .isApproved(agency.getIsApproved())
        .createdAt(agency.getCreatedAt())
        .updatedAt(agency.getUpdatedAt())
        .build();
}


}
