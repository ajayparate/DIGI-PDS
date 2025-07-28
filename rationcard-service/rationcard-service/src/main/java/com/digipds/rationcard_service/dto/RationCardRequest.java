package com.digipds.rationcard_service.dto;

import java.time.LocalDate;

import com.digipds.rationcard_service.entity.CardType;

// import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class RationCardRequest {
    private String rationCardNumber;
    private Long citizenId;
    private CardType cardType;
    private LocalDate issueDate;
    private LocalDate expiryDate;
    private Boolean isActive;
    private Double monthlyIncome;

}
