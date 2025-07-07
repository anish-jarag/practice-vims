package com.example.vims_backend.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class PolicyType {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int policyTypeId;
    
    private String name;
    
    private double basePremium;
    
    private String description;
    
	@Override
	public String toString() {
		return "PolicyType [policyTypeId=" + policyTypeId + ", name=" + name + ", basePremium=" + basePremium
				+ ", description=" + description + "]";
	}
	
	public PolicyType() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public PolicyType(int policyTypeId, String name, double basePremium, String description) {
		super();
		this.policyTypeId = policyTypeId;
		this.name = name;
		this.basePremium = basePremium;
		this.description = description;
	}
	
	public int getPolicyTypeId() {
		return policyTypeId;
	}
	
	public void setPolicyTypeId(int policyTypeId) {
		this.policyTypeId = policyTypeId;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public double getBasePremium() {
		return basePremium;
	}
	
	public void setBasePremium(double basePremium) {
		this.basePremium = basePremium;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
    
}
