package com.digipds.familymember_service.service;

import java.util.List;

import com.digipds.familymember_service.entity.FamilyMember;

public interface FamilyMemberService {
    FamilyMember save(FamilyMember member);
    FamilyMember getById(Long id);
    List<FamilyMember> getByRationCardId(Long rationCardId);
    void delete(Long id);

}
