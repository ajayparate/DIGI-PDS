package com.digipds.warehouse_service.service;

import java.util.List;

import com.digipds.warehouse_service.dto.ApiResponseDTO;
import com.digipds.warehouse_service.dto.WarehouseRequestDTO;
import com.digipds.warehouse_service.dto.WarehouseResponseDTO;

public interface WarehouseService {
    ApiResponseDTO<WarehouseResponseDTO> createWarehouse(WarehouseRequestDTO dto);
    ApiResponseDTO<WarehouseResponseDTO> getWarehouseById(Integer id);
    ApiResponseDTO<List<WarehouseResponseDTO>> getAllWarehouses();
    ApiResponseDTO<WarehouseResponseDTO> updateWarehouse(Integer id, WarehouseRequestDTO dto);
    ApiResponseDTO<String> deleteWarehouse(Integer id);

}
