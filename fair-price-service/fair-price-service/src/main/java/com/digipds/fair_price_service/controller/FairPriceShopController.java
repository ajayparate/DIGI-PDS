package com.digipds.fair_price_service.controller;

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

import com.digipds.fair_price_service.dto.APIResponseDTO;
import com.digipds.fair_price_service.dto.FairPriceShopRequest;
import com.digipds.fair_price_service.dto.FairPriceShopResponse;
import com.digipds.fair_price_service.service.FairPriceShopService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/fps")
@RequiredArgsConstructor
public class FairPriceShopController {
    private final FairPriceShopService fpsService;

    @PostMapping
    public ResponseEntity<APIResponseDTO> createShop(@RequestBody FairPriceShopRequest request) {
        FairPriceShopResponse response = fpsService.createShop(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(
                APIResponseDTO.builder()
                        .statusCode(HttpStatus.CREATED.value())
                        .message("Fair Price Shop created successfully.")
                        .timestamp(LocalDateTime.now())
                        .build()
        );
    }

    @GetMapping
    public ResponseEntity<List<FairPriceShopResponse>> getAllShops() {
        return ResponseEntity.ok(fpsService.getAllShops());
    }

    @GetMapping("/{id}")
    public ResponseEntity<FairPriceShopResponse> getShopById(@PathVariable Integer id) {
        return ResponseEntity.ok(fpsService.getShopById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<APIResponseDTO> updateShop(@PathVariable Integer id, @RequestBody FairPriceShopRequest request) {
        fpsService.updateShop(id, request);
        return ResponseEntity.ok(APIResponseDTO.builder()
                .statusCode(HttpStatus.OK.value())
                .message("Fair Price Shop updated successfully.")
                .timestamp(LocalDateTime.now())
                .build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<APIResponseDTO> deleteShop(@PathVariable Integer id) {
        fpsService.deleteShop(id);
        return ResponseEntity.ok(APIResponseDTO.builder()
                .statusCode(HttpStatus.OK.value())
                .message("Fair Price Shop deleted successfully.")
                .timestamp(LocalDateTime.now())
                .build());
    }

}
