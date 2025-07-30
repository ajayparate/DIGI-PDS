package com.digipds.fair_price_service.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.digipds.fair_price_service.dto.FairPriceShopRequest;
import com.digipds.fair_price_service.dto.FairPriceShopResponse;
import com.digipds.fair_price_service.entity.FairPriceShop;
import com.digipds.fair_price_service.repository.FairPriceShopRepository;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FairPriceServiceImpl implements FairPriceShopService {

    private final FairPriceShopRepository repository;

    @Override
    public FairPriceShopResponse createShop(FairPriceShopRequest request) {
        FairPriceShop shop = FairPriceShop.builder()
                .fpsCode(request.getFpsCode())
                .shopName(request.getShopName())
                .ownerUserId(request.getOwnerUserId())
                .licenseNumber(request.getLicenseNumber())
                .addressLine1(request.getAddressLine1())
                .addressLine2(request.getAddressLine2())
                .city(request.getCity())
                .state(request.getState())
                .pincode(request.getPincode())
                .maxDailyCustomers(request.getMaxDailyCustomers())
                .operatingHours(request.getOperatingHours())
                .assignedWarehouseId(request.getAssignedWarehouseId())
                .isOperational(request.getIsOperational())
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();

        repository.save(shop);

        return mapToResponse(shop);
    }

    @Override
    public List<FairPriceShopResponse> getAllShops() {
        return repository.findAll()
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public FairPriceShopResponse getShopById(Integer id) {
        FairPriceShop shop = repository.findById(id.longValue())
                .orElseThrow(() -> new EntityNotFoundException("FPS not found with id: " + id));
        return mapToResponse(shop);
    }

    @Override
    public FairPriceShopResponse updateShop(Integer id, FairPriceShopRequest request) {
        FairPriceShop shop = repository.findById(id.longValue())
                .orElseThrow(() -> new EntityNotFoundException("FPS not found with id: " + id));

        shop.setShopName(request.getShopName());
        shop.setLicenseNumber(request.getLicenseNumber());
        shop.setOwnerUserId(request.getOwnerUserId());
        shop.setAddressLine1(request.getAddressLine1());
        shop.setAddressLine2(request.getAddressLine2());
        shop.setCity(request.getCity());
        shop.setState(request.getState());
        shop.setPincode(request.getPincode());
        shop.setMaxDailyCustomers(request.getMaxDailyCustomers());
        shop.setOperatingHours(request.getOperatingHours());
        shop.setAssignedWarehouseId(request.getAssignedWarehouseId());
        shop.setIsOperational(request.getIsOperational());
        shop.setUpdatedAt(LocalDateTime.now());

        repository.save(shop);
        return mapToResponse(shop);
    }

    @Override
    public void deleteShop(Integer id) {
        FairPriceShop shop = repository.findById(id.longValue())
                .orElseThrow(() -> new EntityNotFoundException("FPS not found with id: " + id));
        repository.delete(shop);
    }

    private FairPriceShopResponse mapToResponse(FairPriceShop shop) {
        return FairPriceShopResponse.builder()
                .fpsId(shop.getFpsId())
                .fpsCode(shop.getFpsCode())
                .shopName(shop.getShopName())
                .ownerUserId(shop.getOwnerUserId())
                .licenseNumber(shop.getLicenseNumber())
                .addressLine1(shop.getAddressLine1())
                .addressLine2(shop.getAddressLine2())
                .city(shop.getCity())
                .state(shop.getState())
                .pincode(shop.getPincode())
                .maxDailyCustomers(shop.getMaxDailyCustomers())
                .operatingHours(shop.getOperatingHours())
                .assignedWarehouseId(shop.getAssignedWarehouseId())
                .isOperational(shop.getIsOperational())
                .createdAt(shop.getCreatedAt())
                .updatedAt(shop.getUpdatedAt())
                .build();
    }

}
