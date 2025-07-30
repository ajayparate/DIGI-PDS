package com.digipds.procurement_agency_service.controller;

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

import com.digipds.procurement_agency_service.dto.APIResponseDTO;
import com.digipds.procurement_agency_service.dto.ProcurementAgencyRequestDTO;
import com.digipds.procurement_agency_service.dto.ProcurementAgencyResponseDTO;
import com.digipds.procurement_agency_service.entity.ProcurementAgency;
import com.digipds.procurement_agency_service.service.ProcurementAgencyService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/procurement-agencies")
@RequiredArgsConstructor
public class ProcurementAgencyController {

    private final ProcurementAgencyService service;

    @PostMapping
public ResponseEntity<APIResponseDTO<ProcurementAgencyResponseDTO>> createAgency(@RequestBody ProcurementAgencyRequestDTO agencyDTO) {
    // service.createAgency(agencyDTO);
    ProcurementAgencyResponseDTO saved = service.create(agencyDTO);

    APIResponseDTO response = APIResponseDTO.builder()
        .statusCode(HttpStatus.CREATED.value())
        .message("Procurement Agency created successfully.")
        .timestamp(LocalDateTime.now())
        .data(agencyDTO)
        .build();

    return new ResponseEntity<>(response, HttpStatus.CREATED);
}
    /*
     * @PostMapping
        public ResponseEntity<ApiResponseDTO<SchemeCommodity>> create(@RequestBody SchemeCommodityRequest request) {
            SchemeCommodity saved = schemeCommodityService.createMapping(request);

            ApiResponseDTO<SchemeCommodity> response = ApiResponseDTO.<SchemeCommodity>builder()
                .statusCode(HttpStatus.CREATED.value())
                .message("Scheme-Commodity mapping created successfully")
                .timestamp(LocalDateTime.now())
                .data(saved)
                .build();

            return new ResponseEntity<>(response, HttpStatus.CREATED);
        }

     */

    @GetMapping
    public List<ProcurementAgency> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public ProcurementAgency getById(@PathVariable Integer id) {
        return service.getById(id);
    }

    @PutMapping("/{id}")
    public ProcurementAgency update(@PathVariable Integer id, @RequestBody ProcurementAgency agency) {
        return service.update(id, agency);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        service.delete(id);
    }

}
