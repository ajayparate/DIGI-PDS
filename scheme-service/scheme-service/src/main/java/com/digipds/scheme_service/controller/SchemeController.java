package com.digipds.scheme_service.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.digipds.scheme_service.dto.CreateSchemeRequest;
import com.digipds.scheme_service.entity.Scheme;
import com.digipds.scheme_service.service.SchemeService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/schemes")
@RequiredArgsConstructor
public class SchemeController {
    private final SchemeService schemeService;

    @PostMapping
    public ResponseEntity<Scheme> createScheme(@RequestBody CreateSchemeRequest request) {
        return ResponseEntity.ok(schemeService.createScheme(request));
    }

    @GetMapping
    public ResponseEntity<List<Scheme>> getAllSchemes() {
        return ResponseEntity.ok(schemeService.getAllSchemes());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Scheme> getSchemeById(@PathVariable Long id) {
        return ResponseEntity.ok(schemeService.getSchemeById(id));
    }

}
