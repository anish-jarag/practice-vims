package com.example.vims_backend.service;

import com.example.vims_backend.entity.Addon;
import com.example.vims_backend.entity.Proposal;
import com.example.vims_backend.entity.ProposalAddon;
import com.example.vims_backend.repository.ProposalAddonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProposalAddonService {

    @Autowired
    private ProposalAddonRepository proposalAddonRepository;

    public void addProposalAddon(Proposal proposal, Addon addon) {
        ProposalAddon pa = new ProposalAddon();
        pa.setProposal(proposal);
        pa.setAddon(addon);
        proposalAddonRepository.save(pa);
    }
}
