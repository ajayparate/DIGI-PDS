package com.digipds.entitlement_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.digipds.entitlement_service.entity.Entitlement;

public interface EntitlementRepository extends JpaRepository<Entitlement, Long> {

}
