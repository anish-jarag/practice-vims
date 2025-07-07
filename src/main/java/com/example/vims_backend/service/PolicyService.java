package com.example.vims_backend.service;

import com.example.vims_backend.entity.Policy;
import com.example.vims_backend.repository.PolicyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PolicyService {

    @Autowired
    private PolicyRepository policyRepository;

    public Policy addPolicy(Policy policy) {
        return policyRepository.save(policy);
    }

    public List<Policy> getAllPolicies() {
        return policyRepository.findAll();
    }

    public Policy getPolicyById(int id) {
        return policyRepository.findById(id).orElse(null);
    }

    public List<Policy> getPoliciesByUserId(int userId) {
        return policyRepository.findByProposal_User_UserId(userId);
    }

    public Policy updatePolicy(int id, Policy updatedPolicy) {
        Policy existing = policyRepository.findById(id).orElse(null);
        if (existing != null) {
            updatedPolicy.setPolicyId(id);
            return policyRepository.save(updatedPolicy);
        }
        return null;
    }

    public boolean deletePolicy(int id) {
        if (policyRepository.existsById(id)) {
            policyRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
