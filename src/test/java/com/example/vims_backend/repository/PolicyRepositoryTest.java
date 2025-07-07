package com.example.vims_backend.repository;

import com.example.vims_backend.entity.*;
import com.example.vims_backend.entity.enums.*;
import com.example.vims_backend.repository.PolicyRepository;
import com.example.vims_backend.repository.ProposalRepository;
import com.example.vims_backend.repository.UserRepository;
import com.example.vims_backend.repository.VehicleRepository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class PolicyRepositoryTest {

    @Autowired
    private PolicyRepository policyRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private VehicleRepository vehicleRepository;

    @Autowired
    private ProposalRepository proposalRepository;

    @Test
    public void testSaveAndFindPolicyByProposalId() {
        // Step 1: Create and save user
        User user = new User(
                0,
                "Policy User",
                "policy@example.com",
                "pass",
                LocalDate.of(1999, 1, 1),
                "998877665544",
                "POLICY1234A",
                Role.USER,
                LocalDate.now().atStartOfDay()
        );
        userRepository.save(user);

        // Step 2: Create and save vehicle
        Vehicle vehicle = new Vehicle(
                0,
                user.getUserId(),
                VehicleType.CAR,
                "Tata",
                "Nexon",
                "MH10XY1234",
                2021
        );
        vehicleRepository.save(vehicle);

        // Step 3: Create and save proposal
        Proposal proposal = new Proposal(
                0,
                user.getUserId(),
                vehicle.getVehicleId(),
                ProposalStatus.ACTIVE,
                LocalDate.now(),
                6000.0,
                user.getUserId()
        );
        proposalRepository.save(proposal);

        // Step 4: Create and save policy
        Policy policy = new Policy();
        policy.setProposalId(proposal.getProposalId());
        policy.setPolicyNumber("POLICY001");
        policy.setStartDate(LocalDate.now());
        policy.setEndDate(LocalDate.now().plusYears(1));
        policy.setStatus(PolicyStatus.ACTIVE);
        policy.setDocumentUrl("https://dummy-policy.com/file.pdf");

        policyRepository.save(policy);

        // Step 5: Verify retrieval
        Policy fetched = policyRepository.findByProposalId(proposal.getProposalId());
        assertThat(fetched).isNotNull();
        assertThat(fetched.getPolicyNumber()).isEqualTo("POLICY001");
        assertThat(fetched.getStatus()).isEqualTo(PolicyStatus.ACTIVE);
    }
}
