package com.digipds.scheme_commodity_service.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.digipds.scheme_commodity_service.dto.SchemeCommodityRequestDTO;
import com.digipds.scheme_commodity_service.entity.SchemeCommodity;
import com.digipds.scheme_commodity_service.service.SchemeCommodityService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/scheme-commodity")
@RequiredArgsConstructor
public class SchemeCommodityController {
    private final SchemeCommodityService service;

    @PostMapping
    public ResponseEntity<SchemeCommodity> create(@RequestBody SchemeCommodityRequestDTO dto) {
        return ResponseEntity.ok(service.createMapping(dto));
    }

    @GetMapping
    public ResponseEntity<List<SchemeCommodity>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }
}
