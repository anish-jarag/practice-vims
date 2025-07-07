package com.example.vims_backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.vims_backend.entity.ProposalAddon;

public interface ProposalAddonRepository extends JpaRepository<ProposalAddon, Integer> {
    List<ProposalAddon> findByProposal_ProposalId(int proposalId);
}
