package com.digipds.entitlement_service.service;

import java.util.List;

import com.digipds.entitlement_service.dto.ApiResponseDto;
import com.digipds.entitlement_service.dto.EntitlementDto;
import com.digipds.entitlement_service.entity.Entitlement;

public interface EntitlementService {
    ApiResponseDto createEntitlement(EntitlementDto dto);
    List<Entitlement> getAll();
    public Entitlement updateEntitlement(Long id, Entitlement newDetails);
    public void deleteEntitlement(Long id);

}
