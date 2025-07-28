package com.digipds.citizen_service.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.digipds.citizen_service.dto.CitizenRequestDTO;
import com.digipds.citizen_service.dto.CitizenResponseDTO;
// import com.digipds.citizen_service.entity.Citizen;
import com.digipds.citizen_service.service.CitizenService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/citizens")
@RequiredArgsConstructor
public class CitizenController {

    private final CitizenService citizenService;

    @PostMapping("/create")
    public ResponseEntity<CitizenResponseDTO> createCitizen(@Valid @RequestBody CitizenRequestDTO dto) {
        return new ResponseEntity<>(citizenService.createCitizen(dto), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public CitizenResponseDTO getCitizen(@PathVariable Long id) {
        return citizenService.getCitizenById(id);
    }

    @GetMapping
    public List<CitizenResponseDTO> getAll() {
        return citizenService.getAllCitizens();
    }

    @DeleteMapping("/{id}")
    public void deleteCitizen(@PathVariable Long id) {
        citizenService.deleteCitizen(id);
    }
}
