package com.digipds.grievance_service.controller;

import java.time.LocalDateTime;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.digipds.grievance_service.dto.APIResponseDTO;
import com.digipds.grievance_service.dto.GrievanceDTO;
import com.digipds.grievance_service.service.GrievanceService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/grievances")
@RequiredArgsConstructor
public class GrievanceController {
    private final GrievanceService service;

    @PostMapping
    public ResponseEntity<APIResponseDTO> create(@RequestBody GrievanceDTO dto) {
        return ResponseEntity.ok(APIResponseDTO.builder()
                .statusCode(201)
                .message("Grievance created")
                .timestamp(LocalDateTime.now())
                .data(service.createGrievance(dto))
                .build());
    }

    @GetMapping
    public ResponseEntity<APIResponseDTO> getAll() {
        return ResponseEntity.ok(APIResponseDTO.builder()
                .statusCode(200)
                .message("All grievances")
                .timestamp(LocalDateTime.now())
                .data(service.getAllGrievances())
                .build());
    }

    @GetMapping("/{id}")
    public ResponseEntity<APIResponseDTO> getById(@PathVariable Long id) {
        return ResponseEntity.ok(APIResponseDTO.builder()
                .statusCode(200)
                .message("Grievance fetched")
                .timestamp(LocalDateTime.now())
                .data(service.getGrievanceById(id))
                .build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<APIResponseDTO> update(@PathVariable Long id, @RequestBody GrievanceDTO dto) {
        return ResponseEntity.ok(APIResponseDTO.builder()
                .statusCode(200)
                .message("Grievance updated")
                .timestamp(LocalDateTime.now())
                .data(service.updateGrievance(id, dto))
                .build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<APIResponseDTO> delete(@PathVariable Long id) {
        service.deleteGrievance(id);
        return ResponseEntity.ok(APIResponseDTO.builder()
                .statusCode(200)
                .message("Grievance deleted")
                .timestamp(LocalDateTime.now())
                .build());
    }

}
