package com.example.vims_backend.repository;

import com.example.vims_backend.entity.*;
import com.example.vims_backend.entity.enums.ProposalStatus;
import com.example.vims_backend.entity.enums.Role;
import com.example.vims_backend.entity.enums.VehicleType;
import com.example.vims_backend.repository.ProposalRepository;
import com.example.vims_backend.repository.UserRepository;
import com.example.vims_backend.repository.VehicleRepository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class ProposalRepositoryTest {

    @Autowired
    private ProposalRepository proposalRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private VehicleRepository vehicleRepository;

    @Test
    public void testProposalSaveAndFind() {
        // Create user
        User user = new User();
        user.setName("Proposal User");
        user.setEmail("puser@example.com");
        user.setPassword("pass");
        user.setDob(LocalDate.of(1998, 1, 1));
        user.setAadhaar("999988887777");
        user.setPan("LMNOP1234Z");
        user.setRole(Role.USER);
        userRepository.save(user);
        
        // Cretae officer
        User officer = new User();
        officer.setName("Approver");
        officer.setEmail("officer@example.com");
        officer.setPassword("secure");
        officer.setDob(LocalDate.of(1985, 3, 15));
        officer.setAadhaar("999966667777");
        officer.setPan("OFFIC1234Z");
        officer.setRole(Role.OFFICER);
        userRepository.save(officer);

        // Create vehicle
        Vehicle vehicle = new Vehicle();
        vehicle.setUserId(user.getUserId());
        vehicle.setType(VehicleType.BIKE);
        vehicle.setMake("Hero");
        vehicle.setModel("Splendor");
        vehicle.setRegistrationNumber("MH01XY1234");
        vehicle.setManufactureYear(2018);
        vehicleRepository.save(vehicle);

        // Create proposal
        Proposal proposal = new Proposal();
        proposal.setUserId(user.getUserId());
        proposal.setVehicleId(vehicle.getVehicleId());
        proposal.setStatus(ProposalStatus.PROPOSAL_SUBMITTED);
        proposal.setQuoteAmount(0.0);
        proposal.setApprovedBy(officer.getUserId());
        proposalRepository.save(proposal);

        List<Proposal> proposals = proposalRepository.findByUserId(user.getUserId());

        assertThat(proposals).isNotEmpty();
        assertThat(proposals.get(0).getStatus()).isEqualTo(ProposalStatus.PROPOSAL_SUBMITTED);
    }
}
