package com.example.vims_backend.service;

import com.example.vims_backend.entity.Payment;
import com.example.vims_backend.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    public Payment createPayment(Payment payment) {
        return paymentRepository.save(payment);
    }

    public List<Payment> getAllPayments() {
        return paymentRepository.findAll();
    }

    public Payment getPaymentById(int id) {
        return paymentRepository.findById(id).orElse(null);
    }

    public Payment updatePayment(int id, Payment updated) {
        Payment existing = getPaymentById(id);
        if (existing != null) {
            existing.setProposal(updated.getProposal());
            existing.setPaymentDate(updated.getPaymentDate());
            existing.setAmount(updated.getAmount());
            existing.setPaymentMethod(updated.getPaymentMethod());
            existing.setTransactionId(updated.getTransactionId());
            existing.setStatus(updated.getStatus());
            return paymentRepository.save(existing);
        }
        return null;
    }

    public boolean deletePayment(int id) {
        if (paymentRepository.existsById(id)) {
            paymentRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
