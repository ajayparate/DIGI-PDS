package com.digipds.grievance_service.service;

import java.util.List;

import com.digipds.grievance_service.dto.GrievanceDTO;

public interface GrievanceService {
    GrievanceDTO createGrievance(GrievanceDTO dto);
    List<GrievanceDTO> getAllGrievances();
    GrievanceDTO getGrievanceById(Long id);
    GrievanceDTO updateGrievance(Long id, GrievanceDTO dto);
    void deleteGrievance(Long id);

}
