package com.digipds.scheme_commodity_service.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.digipds.scheme_commodity_service.dto.ApiResponseDTO;
import com.digipds.scheme_commodity_service.dto.SchemeCommodityRequestDTO;
import com.digipds.scheme_commodity_service.entity.SchemeCommodity;
import com.digipds.scheme_commodity_service.service.SchemeCommodityService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/scheme-commodity")
@RequiredArgsConstructor
public class SchemeCommodityController {
    private final SchemeCommodityService service;

    //create a one dto where write some fields like Status code, Message, Timestamp instead of returning object create an dto and play with it
    @PostMapping
    public ResponseEntity<ApiResponseDTO<SchemeCommodity>> create(@RequestBody SchemeCommodityRequestDTO request) {
        SchemeCommodity saved = service.createMapping(request);

        ApiResponseDTO<SchemeCommodity> response = ApiResponseDTO.<SchemeCommodity>builder()
                .statusCode(HttpStatus.CREATED.value())
                .message("Scheme-Commodity mapping created successfully")
                .timestamp(LocalDateTime.now())
                .data(saved)
                .build();

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }


    @GetMapping
    public ResponseEntity<List<SchemeCommodity>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }
}
