package com.digipds.rationcard_service.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "ration_cards")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RationCard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long rationCardId;

    @Column(unique = true, nullable = false)
    private String rationCardNumber;

    private Long citizenId; // FK to CITIZEN

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private CardType cardType;

    private LocalDate issueDate;
    private LocalDate expiryDate;

    private Boolean isActive = true;
    private Double monthlyIncome;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
    }
}
