package com.example.vims_backend.controller;

import com.example.vims_backend.entity.PolicyType;
import com.example.vims_backend.service.PolicyTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/policy-types")
public class PolicyTypeRestController {

    @Autowired
    private PolicyTypeService service;

    @PostMapping
    public ResponseEntity<PolicyType> create(@RequestBody PolicyType type) {
        return ResponseEntity.ok(service.addPolicyType(type));
    }

    @GetMapping
    public ResponseEntity<List<PolicyType>> getAll() {
        return ResponseEntity.ok(service.getAllPolicyTypes());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PolicyType> getById(@PathVariable int id) {
        PolicyType type = service.getPolicyTypeById(id);
        if (type != null) {
            return ResponseEntity.ok(type);
        } else {
        	return ResponseEntity.notFound().build();
        }    
    }

    @PutMapping("/{id}")
    public ResponseEntity<PolicyType> update(@PathVariable int id, @RequestBody PolicyType updated) {
        PolicyType type = service.updatePolicyType(id, updated);
        if (type != null) {
            return ResponseEntity.ok(type);
        } else {
        	return ResponseEntity.notFound().build();
        }     
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable int id) {
    	if (service.deletePolicyType(id)) {
    	    return ResponseEntity.ok("Deleted successfully.");
    	} else {
    	    return ResponseEntity.notFound().build();
    	}
    }
}
