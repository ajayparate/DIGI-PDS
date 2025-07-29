package com.digipds.scheme_commodity_service.entity;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "scheme_commodity")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SchemeCommodity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long schemeCommodityId;

    @ManyToOne
    @JoinColumn(name = "scheme_id", nullable = false)
    @JsonIgnore
    private Scheme scheme;

    @ManyToOne
    @JoinColumn(name = "commodity_id", nullable = false)
    @JsonIgnore
    private Commodity commodity;

    private Double quantityPerPerson;
    private Double subsidizedRate;
    private Double marketRate;
    private Boolean isActive;
    private LocalDate effectiveFrom;
    private LocalDate effectiveTo;
}
//✅ Pagination or filtering setup if required we will do it later
