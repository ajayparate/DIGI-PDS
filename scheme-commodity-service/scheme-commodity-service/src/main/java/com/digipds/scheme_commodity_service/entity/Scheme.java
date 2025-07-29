package com.digipds.scheme_commodity_service.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
// import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Scheme {
     @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long schemeId;

    private String schemeName;

    // Optional: if you want bidirectional mapping
    @OneToMany(mappedBy = "scheme")
    private List<SchemeCommodity> schemeCommodities;

}
