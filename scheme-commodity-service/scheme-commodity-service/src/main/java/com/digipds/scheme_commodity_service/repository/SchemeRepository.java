package com.digipds.scheme_commodity_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.digipds.scheme_commodity_service.entity.Scheme;

public interface SchemeRepository extends JpaRepository<Scheme, Long> {

}
