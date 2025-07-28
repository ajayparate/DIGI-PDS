package com.digipds.scheme_service.service;

import java.util.List;

import com.digipds.scheme_service.dto.CreateSchemeRequest;
import com.digipds.scheme_service.entity.Scheme;

public interface SchemeService {
    Scheme createScheme(CreateSchemeRequest request);
    List<Scheme> getAllSchemes();
    Scheme getSchemeById(Long id);

}
