package com.digipds.stock_item_service.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.digipds.stock_item_service.dto.StockItemRequestDTO;
import com.digipds.stock_item_service.dto.StockItemResponseDTO;
import com.digipds.stock_item_service.entity.StockItem;
import com.digipds.stock_item_service.repository.StockItemRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class StockItemServiceImpl implements StockItemService {

    private final StockItemRepository repository;

    @Override
    public StockItemResponseDTO createStockItem(StockItemRequestDTO dto) {
        StockItem stockItem = StockItem.builder()
                .warehouseId(dto.getWarehouseId())
                .commodityId(dto.getCommodityId())
                .batchNumber(dto.getBatchNumber())
                .quantityInStock(dto.getQuantityInStock())
                .qualityGrade(dto.getQualityGrade())
                .procurementDate(dto.getProcurementDate())
                .expiryDate(dto.getExpiryDate())
                .costPerUnit(dto.getCostPerUnit())
                .supplierId(dto.getSupplierId())
                .lastUpdated(LocalDateTime.now())
                .build();

        StockItem saved = repository.save(stockItem);
        return mapToResponse(saved);
    }

    @Override
    public List<StockItemResponseDTO> getAll() {
        return repository.findAll().stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public StockItemResponseDTO getById(Long id) {
        StockItem stockItem = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Stock item not found with id: " + id));
        return mapToResponse(stockItem);
    }
    
    @Override
    public StockItemResponseDTO update(Long id, StockItemRequestDTO dto) {
        StockItem stockItem = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Stock item not found with id: " + id));

        stockItem.setWarehouseId(dto.getWarehouseId());
        stockItem.setCommodityId(dto.getCommodityId());
        stockItem.setBatchNumber(dto.getBatchNumber());
        stockItem.setQuantityInStock(dto.getQuantityInStock());
        stockItem.setQualityGrade(dto.getQualityGrade());
        stockItem.setProcurementDate(dto.getProcurementDate());
        stockItem.setExpiryDate(dto.getExpiryDate());
        stockItem.setCostPerUnit(dto.getCostPerUnit());
        stockItem.setSupplierId(dto.getSupplierId());
        stockItem.setLastUpdated(LocalDateTime.now());

        return mapToResponse(repository.save(stockItem));
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    private StockItemResponseDTO mapToResponse(StockItem stockItem) {
        return StockItemResponseDTO.builder()
                .stockItemId(stockItem.getStockItemId())
                .warehouseId(stockItem.getWarehouseId())
                .commodityId(stockItem.getCommodityId())
                .batchNumber(stockItem.getBatchNumber())
                .quantityInStock(stockItem.getQuantityInStock())
                .qualityGrade(stockItem.getQualityGrade())
                .procurementDate(stockItem.getProcurementDate())
                .expiryDate(stockItem.getExpiryDate())
                .costPerUnit(stockItem.getCostPerUnit())
                .supplierId(stockItem.getSupplierId())
                .lastUpdated(stockItem.getLastUpdated())
                .build();
    }
}
