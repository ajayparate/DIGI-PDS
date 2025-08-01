package com.digipds.transaction_item_service.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.digipds.transaction_item_service.dto.APIResponseDTO;
import com.digipds.transaction_item_service.dto.TransactionItemRequestDTO;
import com.digipds.transaction_item_service.dto.TransactionItemResponseDTO;
import com.digipds.transaction_item_service.service.TransactionItemService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/transaction-items")
@RequiredArgsConstructor
public class TransactionItemController {
    private final TransactionItemService service;

    @PostMapping
    public ResponseEntity<TransactionItemResponseDTO> create(@RequestBody TransactionItemRequestDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<TransactionItemResponseDTO> getById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<TransactionItemResponseDTO>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<TransactionItemResponseDTO> update(@PathVariable Long id, @RequestBody TransactionItemRequestDTO dto) {
        return ResponseEntity.ok(service.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<APIResponseDTO> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.ok(
                APIResponseDTO.builder()
                        .statusCode(200)
                        .message("Transaction item deleted successfully")
                        .timestamp(LocalDateTime.now())
                        .build()
        );
    }

}
