package com.example.vims_backend.entity;

import java.time.LocalDate;

import com.example.vims_backend.entity.enums.ProposalStatus;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Proposal {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int proposalId;
	
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    
    @ManyToOne
    @JoinColumn(name = "vehicle_id")
    private Vehicle vehicle;
    
    @ManyToOne
    @JoinColumn(name = "policy_type_id")
    private PolicyType policyType;
    
    @Enumerated(EnumType.STRING)
    private ProposalStatus status;
    
    private LocalDate submissionDate;
    
    private double quoteAmount;
    
    @ManyToOne
    @JoinColumn(name = "approved_by")
    private User approvedBy;
    
	public int getProposalId() {
		return proposalId;
	}

	public void setProposalId(int proposalId) {
		this.proposalId = proposalId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	public ProposalStatus getStatus() {
		return status;
	}

	public void setStatus(ProposalStatus status) {
		this.status = status;
	}

	public LocalDate getSubmissionDate() {
		return submissionDate;
	}

	public void setSubmissionDate(LocalDate submissionDate) {
		this.submissionDate = submissionDate;
	}

	public double getQuoteAmount() {
		return quoteAmount;
	}

	public void setQuoteAmount(double quoteAmount) {
		this.quoteAmount = quoteAmount;
	}

	public User getApprovedBy() {
		return approvedBy;
	}

	public void setApprovedBy(User approvedBy) {
		this.approvedBy = approvedBy;
	}

	public PolicyType getPolicyType() {
		return policyType;
	}

	public void setPolicyType(PolicyType policyType) {
		this.policyType = policyType;
	}

	public Proposal(int proposalId, User user, Vehicle vehicle, ProposalStatus status, LocalDate submissionDate,
			double quoteAmount, User approvedBy) {
		super();
		this.proposalId = proposalId;
		this.user = user;
		this.vehicle = vehicle;
		this.status = status;
		this.submissionDate = submissionDate;
		this.quoteAmount = quoteAmount;
		this.approvedBy = approvedBy;
	}
	
	public Proposal() {
    }
	
	@Override
	public String toString() {
		return "Proposal [proposalId=" + proposalId + ", user=" + user + ", vehicle=" + vehicle + ", status=" + status
				+ ", submissionDate=" + submissionDate + ", quoteAmount=" + quoteAmount + ", approvedBy=" + approvedBy
				+ "]";
	}
    
}
