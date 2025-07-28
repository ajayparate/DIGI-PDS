package com.digipds.scheme_service.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "scheme")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Scheme {
     @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long schemeId;

    @Column(nullable = false)
    private String schemeName;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Enumerated(EnumType.STRING)
    private SchemeType schemeType; // FEDERAL, STATE, SPECIAL

    private LocalDate startDate;
    private LocalDate endDate;

    @Column(nullable = false)
    private Boolean isActive = true;

    @Column(columnDefinition = "TEXT")
    private String eligibilityCriteria; // JSON or TEXT format

    private LocalDate createdAt;
    private LocalDate updatedAt;

}
