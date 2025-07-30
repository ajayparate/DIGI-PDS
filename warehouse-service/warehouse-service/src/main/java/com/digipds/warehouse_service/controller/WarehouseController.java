package com.digipds.warehouse_service.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.digipds.warehouse_service.dto.ApiResponseDTO;
import com.digipds.warehouse_service.dto.WarehouseRequestDTO;
import com.digipds.warehouse_service.dto.WarehouseResponseDTO;
import com.digipds.warehouse_service.service.WarehouseService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/warehouses")
@RequiredArgsConstructor
public class WarehouseController {

    private final WarehouseService warehouseService;

    @PostMapping
    public ResponseEntity<ApiResponseDTO<WarehouseResponseDTO>> create(@RequestBody WarehouseRequestDTO dto) {
        return ResponseEntity.ok(warehouseService.createWarehouse(dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponseDTO<WarehouseResponseDTO>> getById(@PathVariable Integer id) {
        return ResponseEntity.ok(warehouseService.getWarehouseById(id));
    }

    @GetMapping
    public ResponseEntity<ApiResponseDTO<List<WarehouseResponseDTO>>> getAll() {
        return ResponseEntity.ok(warehouseService.getAllWarehouses());
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponseDTO<WarehouseResponseDTO>> update(
        @PathVariable Integer id, @RequestBody WarehouseRequestDTO dto) {
        return ResponseEntity.ok(warehouseService.updateWarehouse(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponseDTO<String>> delete(@PathVariable Integer id) {
        return ResponseEntity.ok(warehouseService.deleteWarehouse(id));
    }
}

