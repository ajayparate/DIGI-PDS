package com.digipds.rationcard_service.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.digipds.rationcard_service.dto.RationCardRequest;
import com.digipds.rationcard_service.dto.RationCardResponse;
import com.digipds.rationcard_service.entity.RationCard;
import com.digipds.rationcard_service.exception.ResourceNotFoundException;
import com.digipds.rationcard_service.repository.RationCardRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RationCardServiceImpl implements RationCardService {
    private final RationCardRepository repository;

    @Override
    public RationCardResponse createRationCard(RationCardRequest request) {
        RationCard rationCard = RationCard.builder()
                .rationCardNumber(request.getRationCardNumber())
                .citizenId(request.getCitizenId())
                .cardType(request.getCardType())
                .issueDate(request.getIssueDate())
                .expiryDate(request.getExpiryDate())
                .isActive(request.getIsActive())
                .monthlyIncome(request.getMonthlyIncome())
                .build();
        return mapToResponse(repository.save(rationCard));
    }

    @Override
    public RationCardResponse getById(Long id) {
        RationCard card = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Ration card not found with id: " + id));
        return mapToResponse(card);
    }

    @Override
    public List<RationCardResponse> getAll() {
        return repository.findAll()
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    private RationCardResponse mapToResponse(RationCard r) {
        return RationCardResponse.builder()
                .rationCardId(r.getRationCardId())
                .rationCardNumber(r.getRationCardNumber())
                .citizenId(r.getCitizenId())
                .cardType(r.getCardType())
                .issueDate(r.getIssueDate())
                .expiryDate(r.getExpiryDate())
                .isActive(r.getIsActive())
                .monthlyIncome(r.getMonthlyIncome())
                .build();
    }
    

}
