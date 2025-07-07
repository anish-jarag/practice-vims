package com.example.vims_backend.repository;

import com.example.vims_backend.entity.Proposal;
import com.example.vims_backend.entity.enums.ProposalStatus;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProposalRepository extends JpaRepository<Proposal, Integer> {
	List<Proposal> findByUser_UserId(int userId);
    List<Proposal> findByStatus(ProposalStatus status); 
}
