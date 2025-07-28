package com.digipds.citizen_service.service;

import java.time.LocalDateTime;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digipds.citizen_service.dto.CitizenRequestDTO;
import com.digipds.citizen_service.dto.CitizenResponseDTO;
import com.digipds.citizen_service.entity.Citizen;
import com.digipds.citizen_service.entity.User;
import com.digipds.citizen_service.repository.CitizenRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CitizenServiceImpl implements CitizenService {

    @Autowired
    private ModelMapper modelMapper;

   private final CitizenRepository repository;

@Override
public CitizenResponseDTO createCitizen(CitizenRequestDTO dto) {
    User user = new User();
    user.setUserId(dto.getUserId());  // Make sure this exists in DB

    Citizen citizen = Citizen.builder()
        .user(user)
        .firstName(dto.getFirstName())
        .lastName(dto.getLastName())
        .dateOfBirth(new java.sql.Date(dto.getDateOfBirth().getTime()))
        .gender(dto.getGender())
        .aadharNumber(dto.getAadharNumber())
        .isHeadOfFamily(dto.isHeadOfFamily())
        .pincode(dto.getPincode())
        .createdAt(LocalDateTime.now())
        .updatedAt(LocalDateTime.now())
        .build();

    Citizen savedCitizen = repository.save(citizen);
    return modelMapper.map(savedCitizen, CitizenResponseDTO.class);
}

    @Override
    public CitizenResponseDTO getCitizenById(Long id) {
        Citizen citizen = repository.findById(id)
            .orElseThrow(() -> new RuntimeException("Citizen not found"));
        return modelMapper.map(citizen, CitizenResponseDTO.class);
    }

    @Override
    public List<CitizenResponseDTO> getAllCitizens() {
        List<Citizen> citizens = repository.findAll();
        return citizens.stream()
            .map(citizen -> modelMapper.map(citizen, CitizenResponseDTO.class))
            .toList();
    }

    @Override
    public void deleteCitizen(Long id) {
        repository.deleteById(id);
    }

}
