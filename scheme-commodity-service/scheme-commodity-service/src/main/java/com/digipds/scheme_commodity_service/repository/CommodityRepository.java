package com.digipds.scheme_commodity_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.digipds.scheme_commodity_service.entity.Commodity;

public interface CommodityRepository extends JpaRepository<Commodity, Long> {

}
