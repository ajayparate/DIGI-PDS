package com.digipds.stock_item_service.service;

import java.util.List;

import com.digipds.stock_item_service.dto.StockItemRequestDTO;
import com.digipds.stock_item_service.dto.StockItemResponseDTO;

public interface StockItemService {
    StockItemResponseDTO createStockItem(StockItemRequestDTO dto);
    List<StockItemResponseDTO> getAll();
    StockItemResponseDTO getById(Long id);
    StockItemResponseDTO update(Long id, StockItemRequestDTO dto);
    void delete(Long id);

}
