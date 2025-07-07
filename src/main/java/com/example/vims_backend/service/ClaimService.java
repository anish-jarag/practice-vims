package com.example.vims_backend.service;

import com.example.vims_backend.entity.Claim;
import com.example.vims_backend.repository.ClaimRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClaimService {

    @Autowired
    private ClaimRepository claimRepository;

    public Claim createClaim(Claim claim) {
        return claimRepository.save(claim);
    }

    public List<Claim> getAllClaims() {
        return claimRepository.findAll();
    }

    public Claim getClaimById(int id) {
        return claimRepository.findById(id).orElse(null);
    }

    public Claim updateClaim(int id, Claim updated) {
        Claim existing = getClaimById(id);
        if (existing != null) {
            existing.setClaimDate(updated.getClaimDate());
            existing.setDescription(updated.getDescription());
            existing.setStatus(updated.getStatus());
            existing.setPolicy(updated.getPolicy());
            return claimRepository.save(existing);
        }
        return null;
    }

    public boolean deleteClaim(int id) {
        if (claimRepository.existsById(id)) {
            claimRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
