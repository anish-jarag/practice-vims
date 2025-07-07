package com.example.vims_backend.controller;

import com.example.vims_backend.entity.Claim;
import com.example.vims_backend.service.ClaimService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/claims")
public class ClaimRestController {

    @Autowired
    private ClaimService claimService;

    @PostMapping
    public ResponseEntity<Claim> createClaim(@RequestBody Claim claim) {
        return ResponseEntity.ok(claimService.createClaim(claim));
    }

    @GetMapping
    public ResponseEntity<List<Claim>> getAllClaims() {
        return ResponseEntity.ok(claimService.getAllClaims());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Claim> getClaimById(@PathVariable int id) {
        Claim claim = claimService.getClaimById(id);
        if (claim != null) {
            return ResponseEntity.ok(claim);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Claim> updateClaim(@PathVariable int id, @RequestBody Claim updatedClaim) {
        Claim claim = claimService.updateClaim(id, updatedClaim);
        if (claim != null) {
            return ResponseEntity.ok(claim);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteClaim(@PathVariable int id) {
        boolean deleted = claimService.deleteClaim(id);
        return deleted ? ResponseEntity.ok("Deleted successfully.") :
                ResponseEntity.notFound().build();
    }
}
