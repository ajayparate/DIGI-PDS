package com.digipds.familymember_service.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import com.digipds.familymember_service.entity.FamilyMember;
import com.digipds.familymember_service.repository.FamilyMemberRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FamilyMemberServiceImpl implements FamilyMemberService {

    private final FamilyMemberRepository repository;

    @Override
    public FamilyMember save(FamilyMember member) {
        member.setCreatedAt(LocalDate.now());
        return repository.save(member);
    }

    @Override
    public FamilyMember getById(Long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Not Found"));
    }

    @Override
    public List<FamilyMember> getByRationCardId(Long rationCardId) {
        return repository.findByRationCardId(rationCardId);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

}
