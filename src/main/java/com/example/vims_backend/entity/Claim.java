package com.example.vims_backend.entity;

import java.time.LocalDateTime;

import com.example.vims_backend.entity.enums.ClaimStatus;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Claim {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int claimId;

	@ManyToOne
	@JoinColumn(name = "policy_id")
	private Policy policy;
	
    private LocalDateTime claimDate;
    
    private String description;
    
    @Enumerated(EnumType.STRING)
    private ClaimStatus status;
    
    private String remarks;

    public Claim() {}

	public Claim(int claimId, Policy policy, LocalDateTime claimDate, String description, ClaimStatus status,
			String remarks) {
		super();
		this.claimId = claimId;
		this.policy = policy;
		this.claimDate = claimDate;
		this.description = description;
		this.status = status;
		this.remarks = remarks;
	}

	@Override
	public String toString() {
		return "Claim [claimId=" + claimId + ", policy=" + policy + ", claimDate=" + claimDate + ", description="
				+ description + ", status=" + status + ", remarks=" + remarks + "]";
	}

	public int getClaimId() {
		return claimId;
	}

	public void setClaimId(int claimId) {
		this.claimId = claimId;
	}

	public Policy getPolicy() {
		return policy;
	}

	public void setPolicy(Policy policy) {
		this.policy = policy;
	}

	public LocalDateTime getClaimDate() {
		return claimDate;
	}

	public void setClaimDate(LocalDateTime claimDate) {
		this.claimDate = claimDate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public ClaimStatus getStatus() {
		return status;
	}

	public void setStatus(ClaimStatus status) {
		this.status = status;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

}
