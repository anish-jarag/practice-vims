package com.example.vims_backend.service;

import com.example.vims_backend.entity.PolicyType;
import com.example.vims_backend.repository.PolicyTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PolicyTypeService {

    @Autowired
    private PolicyTypeRepository repository;

    public PolicyType addPolicyType(PolicyType type) {
        return repository.save(type);
    }

    public List<PolicyType> getAllPolicyTypes() {
        return repository.findAll();
    }

    public PolicyType getPolicyTypeById(int id) {
        return repository.findById(id).orElse(null);
    }

    public PolicyType updatePolicyType(int id, PolicyType updated) {
        Optional<PolicyType> existing = repository.findById(id);
        if (existing.isPresent()) {
            PolicyType policyType = existing.get();
            policyType.setName(updated.getName());
            policyType.setBasePremium(updated.getBasePremium());
            policyType.setDescription(updated.getDescription());
            return repository.save(policyType);
        }
        return null;
    }

    public boolean deletePolicyType(int id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }
}
