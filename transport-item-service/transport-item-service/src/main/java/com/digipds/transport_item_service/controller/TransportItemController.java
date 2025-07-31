package com.digipds.transport_item_service.controller;

import java.time.LocalDateTime;
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

import com.digipds.transport_item_service.dto.ApiResponseDTO;
import com.digipds.transport_item_service.dto.TransportItemRequestDTO;
import com.digipds.transport_item_service.dto.TransportItemResponseDTO;
import com.digipds.transport_item_service.service.TransportItemService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/transport-items")
@RequiredArgsConstructor
public class TransportItemController {
    private final TransportItemService transportItemService;

    @PostMapping
    public ResponseEntity<ApiResponseDTO<TransportItemResponseDTO>> create(@RequestBody TransportItemRequestDTO dto) {
        TransportItemResponseDTO created = transportItemService.createTransportItem(dto);
        return ResponseEntity.ok(ApiResponseDTO.<TransportItemResponseDTO>builder()
                .statusCode(200)
                .message("Transport item created successfully.")
                .timestamp(LocalDateTime.now())
                .data(created)
                .build());
    }

    @GetMapping
    public ResponseEntity<ApiResponseDTO<List<TransportItemResponseDTO>>> getAll() {
        List<TransportItemResponseDTO> list = transportItemService.getAllTransportItems();
        return ResponseEntity.ok(ApiResponseDTO.<List<TransportItemResponseDTO>>builder()
                .statusCode(200)
                .message("List of transport items")
                .timestamp(LocalDateTime.now())
                .data(list)
                .build());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponseDTO<TransportItemResponseDTO>> getById(@PathVariable Long id) {
        TransportItemResponseDTO dto = transportItemService.getById(id);
        return ResponseEntity.ok(ApiResponseDTO.<TransportItemResponseDTO>builder()
                .statusCode(200)
                .message("Transport item retrieved successfully.")
                .timestamp(LocalDateTime.now())
                .data(dto)
                .build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponseDTO<TransportItemResponseDTO>> update(@PathVariable Long id, @RequestBody TransportItemRequestDTO dto) {
        TransportItemResponseDTO updated = transportItemService.updateTransportItem(id, dto);
        return ResponseEntity.ok(ApiResponseDTO.<TransportItemResponseDTO>builder()
                .statusCode(200)
                .message("Transport item updated successfully.")
                .timestamp(LocalDateTime.now())
                .data(updated)
                .build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponseDTO<String>> delete(@PathVariable Long id) {
        transportItemService.deleteTransportItem(id);
        return ResponseEntity.ok(ApiResponseDTO.<String>builder()
                .statusCode(200)
                .message("Transport item deleted successfully.")
                .timestamp(LocalDateTime.now())
                .data("Deleted")
                .build());
    }


}
