package com.digipds.familymember_service.entity;

import java.time.LocalDate;

// import org.aspectj.asm.internal.Relationship;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "family_member")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FamilyMember {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long familyMemberId;

    private Long rationCardId; // FK → RATION_CARD (From another microservice)

    private Long citizenId; // FK → CITIZEN (From another microservice)

    @Enumerated(EnumType.STRING)
    private com.digipds.familymember_service.entity.Relationship relationship;

    private Boolean isPrimary;

    private LocalDate addedDate;

    private LocalDate createdAt;

}
