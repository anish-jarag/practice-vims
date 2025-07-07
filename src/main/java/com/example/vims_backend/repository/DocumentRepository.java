package com.example.vims_backend.repository;

import com.example.vims_backend.entity.Document;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface DocumentRepository extends JpaRepository<Document, Integer> {
	List<Document> findByProposal_ProposalId(int proposalId);
}
