package com.example.vims_backend.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Addon {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int addonId;
	
    private String name;
    
    private double extraCost;
    
    private String description;
    
	public Addon() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Addon(int addonId, String name, double extraCost, String description) {
		super();
		this.addonId = addonId;
		this.name = name;
		this.extraCost = extraCost;
		this.description = description;
	}
	
	@Override
	public String toString() {
		return "Addon [addonId=" + addonId + ", name=" + name + ", extraCost=" + extraCost + ", description="
				+ description + "]";
	}
	
	public int getAddonId() {
		return addonId;
	}
	
	public void setAddonId(int addonId) {
		this.addonId = addonId;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public double getExtraCost() {
		return extraCost;
	}
	
	public void setExtraCost(double extraCost) {
		this.extraCost = extraCost;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
    
}
