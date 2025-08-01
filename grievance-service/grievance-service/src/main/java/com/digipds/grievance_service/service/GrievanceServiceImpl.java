package com.digipds.grievance_service.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.digipds.grievance_service.dto.GrievanceDTO;
import com.digipds.grievance_service.entity.Grievance;
import com.digipds.grievance_service.entity.GrievanceType;
import com.digipds.grievance_service.entity.Priority;
import com.digipds.grievance_service.entity.Status;
import com.digipds.grievance_service.exception.ResourceNotFoundException;
import com.digipds.grievance_service.repository.GrievanceRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class GrievanceServiceImpl implements GrievanceService {
    private final GrievanceRepository repository;

    @Override
    public GrievanceDTO createGrievance(GrievanceDTO dto) {
        Grievance grievance = convertToEntity(dto);
        grievance.setStatus(Status.OPEN);
        grievance.setCreatedAt(LocalDateTime.now());
        return convertToDTO(repository.save(grievance));
    }

    @Override
    public List<GrievanceDTO> getAllGrievances() {
        return repository.findAll()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public GrievanceDTO getGrievanceById(Long id) {
        Grievance g = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Grievance not found"));
        return convertToDTO(g);
    }

    @Override
    public GrievanceDTO updateGrievance(Long id, GrievanceDTO dto) {
        Grievance g = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Grievance not found"));
        g.setStatus(Status.valueOf(dto.getStatus()));
        g.setResolutionNotes(dto.getResolutionNotes());
        g.setResolvedAt(LocalDateTime.now());
        return convertToDTO(repository.save(g));
    }

    @Override
    public void deleteGrievance(Long id) {
        repository.deleteById(id);
    }

    private Grievance convertToEntity(GrievanceDTO dto) {
        return Grievance.builder()
                .grievanceId(dto.getGrievanceId())
                .citizenId(dto.getCitizenId())
                .fpsId(dto.getFpsId())
                .grievanceType(GrievanceType.valueOf(dto.getGrievanceType()))
                .title(dto.getTitle())
                .description(dto.getDescription())
                .priority(Priority.valueOf(dto.getPriority()))
                .status(Status.valueOf(dto.getStatus()))
                .assignedToUserId(dto.getAssignedToUserId())
                .resolutionNotes(dto.getResolutionNotes())
                .build();
    }

    private GrievanceDTO convertToDTO(Grievance g) {
        return GrievanceDTO.builder()
                .grievanceId(g.getGrievanceId())
                .citizenId(g.getCitizenId())
                .fpsId(g.getFpsId())
                .grievanceType(g.getGrievanceType().name())
                .title(g.getTitle())
                .description(g.getDescription())
                .priority(g.getPriority().name())
                .status(g.getStatus().name())
                .assignedToUserId(g.getAssignedToUserId())
                .resolutionNotes(g.getResolutionNotes())
                .build();
    }


}
