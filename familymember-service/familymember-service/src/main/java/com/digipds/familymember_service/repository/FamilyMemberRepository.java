package com.digipds.familymember_service.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.digipds.familymember_service.entity.FamilyMember;

public interface FamilyMemberRepository extends JpaRepository<FamilyMember, Long> {
    List<FamilyMember> findByRationCardId(Long rationCardId);

}
