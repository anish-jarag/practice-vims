package com.example.vims_backend.controller;

import com.example.vims_backend.entity.Payment;
import com.example.vims_backend.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/payments")
public class PaymentRestController {

    @Autowired
    private PaymentService paymentService;

    @PostMapping
    public ResponseEntity<Payment> createPayment(@RequestBody Payment payment) {
        return ResponseEntity.ok(paymentService.createPayment(payment));
    }

    @GetMapping
    public ResponseEntity<List<Payment>> getAllPayments() {
        return ResponseEntity.ok(paymentService.getAllPayments());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Payment> getPaymentById(@PathVariable int id) {
        Payment payment = paymentService.getPaymentById(id);
        if (payment != null) {
            return ResponseEntity.ok(payment);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Payment> updatePayment(@PathVariable int id, @RequestBody Payment payment) {
        Payment updated = paymentService.updatePayment(id, payment);
        if (updated != null) {
            return ResponseEntity.ok(updated);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePayment(@PathVariable int id) {
        boolean deleted = paymentService.deletePayment(id);
        return deleted ?
                ResponseEntity.ok("Payment deleted successfully.") :
                ResponseEntity.notFound().build();
    }
}
