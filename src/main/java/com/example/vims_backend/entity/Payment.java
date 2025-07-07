package com.example.vims_backend.entity;

import java.time.LocalDateTime;

import com.example.vims_backend.entity.enums.PaymentStatus;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Payment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int paymentId;
	
	@ManyToOne
	@JoinColumn(name = "proposal_id")
	private Proposal proposal;

	private LocalDateTime paymentDate;
    
    private double amount;
    
    private String paymentMethod;
    
    private String transactionId;
    
    @Enumerated(EnumType.STRING)
    private PaymentStatus status;

    public Payment() {}

	public Payment(int paymentId, Proposal proposal, LocalDateTime paymentDate, double amount, String paymentMethod,
			String transactionId, PaymentStatus status) {
		super();
		this.paymentId = paymentId;
		this.proposal = proposal;
		this.paymentDate = paymentDate;
		this.amount = amount;
		this.paymentMethod = paymentMethod;
		this.transactionId = transactionId;
		this.status = status;
	}

	@Override
	public String toString() {
		return "Payment [paymentId=" + paymentId + ", proposal=" + proposal + ", paymentDate=" + paymentDate
				+ ", amount=" + amount + ", paymentMethod=" + paymentMethod + ", transactionId=" + transactionId
				+ ", status=" + status + "]";
	}

	public int getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(int paymentId) {
		this.paymentId = paymentId;
	}

	public Proposal getProposal() {
		return proposal;
	}

	public void setProposal(Proposal proposal) {
		this.proposal = proposal;
	}

	public LocalDateTime getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(LocalDateTime paymentDate) {
		this.paymentDate = paymentDate;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	public PaymentStatus getStatus() {
		return status;
	}

	public void setStatus(PaymentStatus status) {
		this.status = status;
	}

}
