package com.digipds.procurement_agency_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.digipds.procurement_agency_service.entity.ProcurementAgency;

public interface ProcurementAgencyRepository extends JpaRepository<ProcurementAgency, Long> {
    

}
