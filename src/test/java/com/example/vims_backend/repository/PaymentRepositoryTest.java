package com.example.vims_backend.repository;

import com.example.vims_backend.entity.*;
import com.example.vims_backend.entity.enums.*;
import com.example.vims_backend.repository.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class PaymentRepositoryTest {

    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private VehicleRepository vehicleRepository;

    @Autowired
    private ProposalRepository proposalRepository;

    @Test
    public void testSaveAndFetchPayment() {
        // Step 1: Save User
        User user = new User(
                0,
                "Payee",
                "payee@example.com",
                "secure",
                LocalDate.of(1995, 6, 20),
                "112233445566",
                "PAYEE1234Z",
                Role.USER,
                LocalDateTime.now()
        );
        userRepository.save(user);

        // Step 2: Save Vehicle
        Vehicle vehicle = new Vehicle(
                0,
                user.getUserId(),
                VehicleType.BIKE,
                "Yamaha",
                "R15",
                "MH20ZZ0001",
                2020
        );
        vehicleRepository.save(vehicle);

        // Step 3: Save Proposal
        Proposal proposal = new Proposal(
                0,
                user.getUserId(),
                vehicle.getVehicleId(),
                ProposalStatus.QUOTE_GENERATED,
                LocalDate.now(),
                4500.0,
                (Integer) null
        );
        proposalRepository.save(proposal);

        // Step 4: Save Payment
        Payment payment = new Payment();
        payment.setProposalId(proposal.getProposalId());
        payment.setAmount(4500.0);
        payment.setPaymentMethod("UPI");
        payment.setTransactionId("TXN123456UPI");
        payment.setStatus(PaymentStatus.SUCCESS);

        paymentRepository.save(payment);

        // Step 5: Validate
        Payment fetched = paymentRepository.findById(payment.getPaymentId()).orElse(null);
        assertThat(fetched).isNotNull();
        assertThat(fetched.getAmount()).isEqualTo(4500.0);
        assertThat(fetched.getStatus()).isEqualTo(PaymentStatus.SUCCESS);
    }
}
