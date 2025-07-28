package com.digipds.citizen_service.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.digipds.citizen_service.entity.Citizen;

public interface CitizenRepository extends JpaRepository<Citizen,Long> {
    Optional<Citizen> findByAadharNumber(String aadharNumber);

}
