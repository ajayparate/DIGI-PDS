package com.digipds.rationcard_service.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.digipds.rationcard_service.entity.RationCard;

public interface RationCardRepository extends JpaRepository<RationCard, Long>{

    Optional<RationCard> findByRationCardNumber(String rationCardNumber);
}
