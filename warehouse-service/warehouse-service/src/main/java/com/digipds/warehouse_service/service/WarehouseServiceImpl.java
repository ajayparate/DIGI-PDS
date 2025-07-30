package com.digipds.warehouse_service.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.digipds.warehouse_service.dto.ApiResponseDTO;
import com.digipds.warehouse_service.dto.WarehouseRequestDTO;
import com.digipds.warehouse_service.dto.WarehouseResponseDTO;
import com.digipds.warehouse_service.entity.Warehouse;
import com.digipds.warehouse_service.repository.WarehouseRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class WarehouseServiceImpl implements WarehouseService {

    private final WarehouseRepository warehouseRepository;

    @Override
    public ApiResponseDTO<WarehouseResponseDTO> createWarehouse(WarehouseRequestDTO dto) {
        Warehouse warehouse = Warehouse.builder()
            .warehouseCode(dto.getWarehouseCode())
            .warehouseName(dto.getWarehouseName())
            .warehouseType(dto.getWarehouseType())
            .addressLine1(dto.getAddressLine1())
            .addressLine2(dto.getAddressLine2())
            .city(dto.getCity())
            .state(dto.getState())
            .pincode(dto.getPincode())
            .capacityInTons(dto.getCapacityInTons())
            .managerUserId(dto.getManagerUserId())
            .isOperational(true)
            .createdAt(LocalDateTime.now())
            .updatedAt(LocalDateTime.now())
            .build();

        Warehouse saved = warehouseRepository.save(warehouse);
        return buildSuccessResponse(toResponseDTO(saved), "Warehouse created successfully.");
    }

    @Override
    public ApiResponseDTO<WarehouseResponseDTO> getWarehouseById(Integer id) {
        Warehouse warehouse = warehouseRepository.findById(id.longValue())
                .orElseThrow(() -> new RuntimeException("Warehouse not found with ID: " + id));
        return buildSuccessResponse(toResponseDTO(warehouse), "Warehouse fetched successfully.");
    }

    @Override
    public ApiResponseDTO<List<WarehouseResponseDTO>> getAllWarehouses() {
        List<WarehouseResponseDTO> list = warehouseRepository.findAll().stream()
            .map(this::toResponseDTO)
            .toList();
        return buildSuccessResponse(list, "All warehouses fetched.");
    }

    @Override
    public ApiResponseDTO<WarehouseResponseDTO> updateWarehouse(Integer id, WarehouseRequestDTO dto) {
        Warehouse warehouse = warehouseRepository.findById(id.longValue())
                .orElseThrow(() -> new RuntimeException("Warehouse not found"));

        warehouse.setWarehouseName(dto.getWarehouseName());
        warehouse.setWarehouseType(dto.getWarehouseType());
        warehouse.setAddressLine1(dto.getAddressLine1());
        warehouse.setAddressLine2(dto.getAddressLine2());
        warehouse.setCity(dto.getCity());
        warehouse.setState(dto.getState());
        warehouse.setPincode(dto.getPincode());
        warehouse.setCapacityInTons(dto.getCapacityInTons());
        warehouse.setManagerUserId(dto.getManagerUserId());
        warehouse.setUpdatedAt(LocalDateTime.now());

        Warehouse updated = warehouseRepository.save(warehouse);
        return buildSuccessResponse(toResponseDTO(updated), "Warehouse updated.");
    }

    @Override
    public ApiResponseDTO<String> deleteWarehouse(Integer id) {
        warehouseRepository.deleteById(id.longValue());
        return buildSuccessResponse("Warehouse deleted successfully", "Deleted");
    }

    private WarehouseResponseDTO toResponseDTO(Warehouse w) {
        return WarehouseResponseDTO.builder()
            .warehouseId(w.getWarehouseId())
            .warehouseCode(w.getWarehouseCode())
            .warehouseName(w.getWarehouseName())
            .warehouseType(w.getWarehouseType())
            .addressLine1(w.getAddressLine1())
            .addressLine2(w.getAddressLine2())
            .city(w.getCity())
            .state(w.getState())
            .pincode(w.getPincode())
            .capacityInTons(w.getCapacityInTons())
            .managerUserId(w.getManagerUserId())
            .isOperational(w.getIsOperational())
            .createdAt(w.getCreatedAt())
            .updatedAt(w.getUpdatedAt())
            .build();
    }

    private <T> ApiResponseDTO<T> buildSuccessResponse(T data, String message) {
        return ApiResponseDTO.<T>builder()
            .statusCode(HttpStatus.OK.value())
            .message(message)
            .timestamp(LocalDateTime.now())
            .data(data)
            .build();
    }

}
