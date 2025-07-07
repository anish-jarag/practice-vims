package com.example.vims_backend.service;

import com.example.vims_backend.entity.Proposal;
import com.example.vims_backend.repository.ProposalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProposalService {

    @Autowired
    private ProposalRepository proposalRepository;

    public Proposal addProposal(Proposal proposal) {
        return proposalRepository.save(proposal);
    }

    public List<Proposal> getAllProposals() {
        return proposalRepository.findAll();
    }

    public Proposal getProposalById(int id) {
        return proposalRepository.findById(id).orElse(null);
    }

    public Proposal updateProposal(int id, Proposal updatedProposal) {
        Proposal existing = proposalRepository.findById(id).orElse(null);
        if (existing != null) {
            updatedProposal.setProposalId(id);
            return proposalRepository.save(updatedProposal);
        } else {
            return null;
        }
    }

    public boolean deleteProposal(int id) {
        if (proposalRepository.existsById(id)) {
            proposalRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public List<Proposal> getProposalsByUserId(int userId) {
        return proposalRepository.findByUser_UserId(userId);
    }
}
