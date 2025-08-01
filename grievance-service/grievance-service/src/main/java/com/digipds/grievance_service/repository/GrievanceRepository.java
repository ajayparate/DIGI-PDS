package com.digipds.grievance_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.digipds.grievance_service.entity.Grievance;

public interface GrievanceRepository extends JpaRepository<Grievance,Long> {

}
