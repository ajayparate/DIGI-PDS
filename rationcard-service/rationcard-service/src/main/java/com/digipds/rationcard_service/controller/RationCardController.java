package com.digipds.rationcard_service.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.digipds.rationcard_service.dto.RationCardRequest;
import com.digipds.rationcard_service.dto.RationCardResponse;
import com.digipds.rationcard_service.service.RationCardService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/rationcards")
@RequiredArgsConstructor
public class RationCardController {
    private final RationCardService rationCardService;

    @PostMapping("/create")
    public ResponseEntity<RationCardResponse> create(@Valid @RequestBody RationCardRequest request) {
        return ResponseEntity.ok(rationCardService.createRationCard(request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<RationCardResponse> getById(@PathVariable Long id) {
        return ResponseEntity.ok(rationCardService.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<RationCardResponse>> getAll() {
        return ResponseEntity.ok(rationCardService.getAll());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        rationCardService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
