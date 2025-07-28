package com.digipds.citizen_service.service;

import java.util.List;

import com.digipds.citizen_service.dto.CitizenRequestDTO;
import com.digipds.citizen_service.dto.CitizenResponseDTO;
// import com.digipds.citizen_service.entity.Citizen;

public interface CitizenService {
    CitizenResponseDTO createCitizen(CitizenRequestDTO dto);
    CitizenResponseDTO getCitizenById(Long id);
    List<CitizenResponseDTO> getAllCitizens();
    void deleteCitizen(Long id);

}
