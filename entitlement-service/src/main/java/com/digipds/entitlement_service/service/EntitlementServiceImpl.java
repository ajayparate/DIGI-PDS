package com.digipds.entitlement_service.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.digipds.entitlement_service.dto.ApiResponseDto;
import com.digipds.entitlement_service.dto.EntitlementDto;
import com.digipds.entitlement_service.entity.Entitlement;
import com.digipds.entitlement_service.exception.ResourceNotFoundException;
import com.digipds.entitlement_service.repository.EntitlementRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EntitlementServiceImpl implements EntitlementService {

    private final EntitlementRepository entitlementRepository;

    @Override
    public ApiResponseDto createEntitlement(EntitlementDto dto) {
        Entitlement entitlement = Entitlement.builder()
                .rationCardId(dto.getRationCardId())
                .schemeCommodityId(dto.getSchemeCommodityId())
                .monthlyQuota(dto.getMonthlyQuota())
                .consumedQuantity(dto.getConsumedQuantity() == null ? 0.0 : dto.getConsumedQuantity())
                .remainingQuota(dto.getRemainingQuota())
                .resetDate(dto.getResetDate())
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();

        entitlementRepository.save(entitlement);

        return ApiResponseDto.builder()
                .statusCode(201)
                .message("Entitlement created successfully.")
                .timestamp(LocalDateTime.now())
                .data(entitlement)
                .build();
    }

    @Override
    public List<Entitlement> getAll() {
         return entitlementRepository.findAll();
        
    }

    @Override
    public Entitlement updateEntitlement(Long id, Entitlement newDetails) {
        Entitlement entitlement = entitlementRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Entitlement not found"));
        
        entitlement.setMonthlyQuota(newDetails.getMonthlyQuota());
        entitlement.setConsumedQuantity(newDetails.getConsumedQuantity());
        entitlement.setRemainingQuota(newDetails.getRemainingQuota());
        entitlement.setResetDate(newDetails.getResetDate());

        return entitlementRepository.save(entitlement);
    }

    @Override
    public void deleteEntitlement(Long id) {
        Entitlement entitlement = entitlementRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Entitlement not found"));
        entitlementRepository.delete(entitlement);
    }
    
}
