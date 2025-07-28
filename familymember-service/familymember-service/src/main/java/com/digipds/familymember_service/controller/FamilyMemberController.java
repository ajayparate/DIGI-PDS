package com.digipds.familymember_service.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.digipds.familymember_service.entity.FamilyMember;
import com.digipds.familymember_service.service.FamilyMemberService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/familymembers")
@RequiredArgsConstructor
public class FamilyMemberController {

    private final FamilyMemberService familyMemberService;

    @PostMapping("/new")
    public ResponseEntity<FamilyMember> save(@RequestBody FamilyMember member) {
        return ResponseEntity.ok(familyMemberService.save(member));
    }

    @GetMapping("/{id}")
    public ResponseEntity<FamilyMember> getById(@PathVariable Long id) {
        return ResponseEntity.ok(familyMemberService.getById(id));
    }

    @GetMapping("/rationcard/{rationCardId}")
    public ResponseEntity<List<FamilyMember>> getByRationCardId(@PathVariable Long rationCardId) {
        return ResponseEntity.ok(familyMemberService.getByRationCardId(rationCardId));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        familyMemberService.delete(id);
        return ResponseEntity.ok("Deleted successfully");
    }
}
