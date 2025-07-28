package com.digipds.rationcard_service.dto;

import java.time.LocalDate;

import com.digipds.rationcard_service.entity.CardType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RationCardResponse {
    private Long rationCardId;
    private String rationCardNumber;
    private Long citizenId;
    private CardType cardType;
    private LocalDate issueDate;
    private LocalDate expiryDate;
    private Boolean isActive;
    private Double monthlyIncome;

}
