package com.digipds.scheme_commodity_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.digipds.scheme_commodity_service.entity.SchemeCommodity;

public interface SchemeCommodityRepository extends JpaRepository<SchemeCommodity, Long> {
    

}
