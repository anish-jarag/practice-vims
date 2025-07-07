package com.example.vims_backend.controller;

import com.example.vims_backend.entity.Policy;
import com.example.vims_backend.service.PolicyService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/policies")
public class PolicyRestController {

    @Autowired
    private PolicyService policyService;

//	Add Policy
    @PostMapping
    public ResponseEntity<Policy> addPolicy(@RequestBody Policy policy) {
        return ResponseEntity.ok(policyService.addPolicy(policy));
    }

//	Get all policies
    @GetMapping
    public ResponseEntity<List<Policy>> getAllPolicies() {
        return ResponseEntity.ok(policyService.getAllPolicies());
    }

//	Get policy by ID
    @GetMapping("/{id}")
    public ResponseEntity<?> getPolicyById(@PathVariable int id) {
        Policy policy = policyService.getPolicyById(id);
        if (policy != null) {
            return ResponseEntity.ok(policy);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

//	Get all policies by user ID
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Policy>> getPoliciesByUserId(@PathVariable int userId) {
        return ResponseEntity.ok(policyService.getPoliciesByUserId(userId));
    }

//	Update policy
    @PutMapping("/{id}")
    public ResponseEntity<?> updatePolicy(@PathVariable int id, @RequestBody Policy policy) {
        Policy updated = policyService.updatePolicy(id, policy);
        if (updated != null) {
            return ResponseEntity.ok(updated);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

//	Delete policy
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePolicy(@PathVariable int id) {
        boolean deleted = policyService.deletePolicy(id);
        if (deleted) {
            return ResponseEntity.ok("Policy deleted successfully.");
        } else {
            return ResponseEntity.status(404).body("Policy not found.");
        }
    }
}
