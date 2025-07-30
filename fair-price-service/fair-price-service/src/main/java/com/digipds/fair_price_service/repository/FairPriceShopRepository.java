package com.digipds.fair_price_service.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.digipds.fair_price_service.entity.FairPriceShop;

public interface FairPriceShopRepository extends JpaRepository<FairPriceShop, Long> {
    Optional<FairPriceShop> findByFpsCode (String fpsCode);

}
