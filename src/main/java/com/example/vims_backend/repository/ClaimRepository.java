package com.example.vims_backend.repository;

import com.example.vims_backend.entity.Claim;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ClaimRepository extends JpaRepository<Claim, Integer> {
	List<Claim> findByPolicy_PolicyId(int policyId);
}
