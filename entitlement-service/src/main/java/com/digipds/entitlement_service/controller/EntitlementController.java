package com.digipds.entitlement_service.controller;

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

import com.digipds.entitlement_service.dto.ApiResponseDto;
import com.digipds.entitlement_service.dto.EntitlementDto;
import com.digipds.entitlement_service.entity.Entitlement;
import com.digipds.entitlement_service.service.EntitlementService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/entitlements")
@RequiredArgsConstructor
public class EntitlementController {
    private final EntitlementService entitlementService;

    @PostMapping
    public ResponseEntity<ApiResponseDto> createEntitlement(@RequestBody EntitlementDto dto) {
        return ResponseEntity.ok(entitlementService.createEntitlement(dto));
    }

    @GetMapping
    public ResponseEntity<List<Entitlement>> getAll(){
        return ResponseEntity.ok(entitlementService.getAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponseDto> updateEntitlement(
            @PathVariable Long id,
            @RequestBody Entitlement entitlementDetails) {
        Entitlement updated = entitlementService.updateEntitlement(id, entitlementDetails);
        return ResponseEntity.ok(
            ApiResponseDto.builder()
                .statusCode(HttpStatus.OK.value())
                .message("Entitlement updated successfully.")
                .timestamp(LocalDateTime.now())
                .data(updated)
                .build()
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponseDto> deleteEntitlement(@PathVariable Long id) {
        entitlementService.deleteEntitlement(id);
        return ResponseEntity.ok(
            ApiResponseDto.builder()
                .statusCode(HttpStatus.OK.value())
                .message("Entitlement deleted successfully.")
                .timestamp(LocalDateTime.now())
                .build()
        );
    }


}
