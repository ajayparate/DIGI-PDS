package com.digipds.scheme_commodity_service.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.digipds.scheme_commodity_service.dto.SchemeCommodityRequestDTO;
import com.digipds.scheme_commodity_service.entity.Commodity;
import com.digipds.scheme_commodity_service.entity.Scheme;
import com.digipds.scheme_commodity_service.entity.SchemeCommodity;
import com.digipds.scheme_commodity_service.repository.CommodityRepository;
import com.digipds.scheme_commodity_service.repository.SchemeCommodityRepository;
import com.digipds.scheme_commodity_service.repository.SchemeRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SchemeCommodityService {

    private final SchemeCommodityRepository repository;
    private final SchemeRepository schemeRepository;
    private final CommodityRepository commodityRepository;

    public SchemeCommodity createMapping(SchemeCommodityRequestDTO dto) {
        Scheme scheme = schemeRepository.findById(dto.getSchemeId())
                .orElseThrow(() -> new RuntimeException("Scheme not found"));
        Commodity commodity = commodityRepository.findById(dto.getCommodityId())
                .orElseThrow(() -> new RuntimeException("Commodity not found"));

        SchemeCommodity sc = SchemeCommodity.builder()
                .scheme(scheme)
                .commodity(commodity)
                .quantityPerPerson(dto.getQuantityPerPerson())
                .subsidizedRate(dto.getSubsidizedRate())
                .marketRate(dto.getMarketRate())
                .isActive(dto.getIsActive())
                .effectiveFrom(dto.getEffectiveFrom())
                .effectiveTo(dto.getEffectiveTo())
                .build();

        return repository.save(sc);
    }

    public List<SchemeCommodity> getAll() {
        return repository.findAll();
    }
}
