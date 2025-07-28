package com.digipds.rationcard_service.service;

import java.util.List;

import com.digipds.rationcard_service.dto.RationCardRequest;
import com.digipds.rationcard_service.dto.RationCardResponse;

public interface RationCardService {
    RationCardResponse createRationCard(RationCardRequest request);
    RationCardResponse getById(Long id);
    List<RationCardResponse> getAll();
    void deleteById(Long id);

}
