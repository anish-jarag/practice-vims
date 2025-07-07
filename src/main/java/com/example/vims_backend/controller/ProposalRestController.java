package com.example.vims_backend.controller;

import com.example.vims_backend.entity.Proposal;
import com.example.vims_backend.service.ProposalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/proposals")
public class ProposalRestController {

    @Autowired
    private ProposalService proposalService;

    @PostMapping
    public ResponseEntity<Proposal> addProposal(@RequestBody Proposal proposal) {
        return ResponseEntity.ok(proposalService.addProposal(proposal));
    }

    @GetMapping
    public ResponseEntity<List<Proposal>> getAllProposals() {
        return ResponseEntity.ok(proposalService.getAllProposals());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getProposalById(@PathVariable int id) {
        Proposal proposal = proposalService.getProposalById(id);
        if (proposal != null) {
            return ResponseEntity.ok(proposal);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateProposal(@PathVariable int id, @RequestBody Proposal updatedProposal) {
        Proposal proposal = proposalService.updateProposal(id, updatedProposal);
        if (proposal != null) {
            return ResponseEntity.ok(proposal);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteProposal(@PathVariable int id) {
        boolean deleted = proposalService.deleteProposal(id);
        if (deleted) {
            return ResponseEntity.ok("Proposal deleted successfully.");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Proposal>> getProposalsByUserId(@PathVariable int userId) {
        return ResponseEntity.ok(proposalService.getProposalsByUserId(userId));
    }
}
