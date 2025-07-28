package com.digipds.scheme_service.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import com.digipds.scheme_service.dto.CreateSchemeRequest;
import com.digipds.scheme_service.entity.Scheme;
import com.digipds.scheme_service.repository.SchemeRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SchemeServiceImpl implements SchemeService {

    private final SchemeRepository schemeRepository;

    @Override
    public Scheme createScheme(CreateSchemeRequest request) {
        Scheme scheme = Scheme.builder()
                .schemeName(request.getSchemeName())
                .description(request.getDescription())
                .schemeType(request.getSchemeType())
                .startDate(request.getStartDate())
                .endDate(request.getEndDate())
                .isActive(request.getIsActive())
                .eligibilityCriteria(request.getEligibilityCriteria())
                .createdAt(LocalDate.now())
                .updatedAt(LocalDate.now())
                .build();
        return schemeRepository.save(scheme);
    }

    @Override
    public List<Scheme> getAllSchemes() {
        return schemeRepository.findAll();
    }

    @Override
    public Scheme getSchemeById(Long id) {
        return schemeRepository.findById(id).orElseThrow(() -> new RuntimeException("Scheme not found"));
    }

}
