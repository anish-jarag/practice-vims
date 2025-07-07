package com.example.vims_backend.repository;

import com.example.vims_backend.entity.Policy;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PolicyRepository extends JpaRepository<Policy, Integer> {
	Policy findByProposal_ProposalId(int proposalId);
	List<Policy> findByProposal_User_UserId(int userId);
}
