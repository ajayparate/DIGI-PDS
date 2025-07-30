package com.digipds.stock_item_service.controller;

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

import com.digipds.stock_item_service.dto.StockItemRequestDTO;
import com.digipds.stock_item_service.dto.StockItemResponseDTO;
import com.digipds.stock_item_service.service.StockItemService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/stock-items")
@RequiredArgsConstructor
public class StockItemController {
    private final StockItemService service;

    @PostMapping
    public ResponseEntity<StockItemResponseDTO> create(@RequestBody StockItemRequestDTO dto) {
        return ResponseEntity.ok(service.createStockItem(dto));
    }

    @GetMapping
    public ResponseEntity<List<StockItemResponseDTO>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<StockItemResponseDTO> getById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<StockItemResponseDTO> update(@PathVariable Long id, @RequestBody StockItemRequestDTO dto) {
        return ResponseEntity.ok(service.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.ok("Stock item deleted successfully");
    }

}
