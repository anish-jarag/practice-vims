package com.example.vims_backend.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class ProposalAddon {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    private Proposal proposal;

    @ManyToOne
    private Addon addon;

	public ProposalAddon() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ProposalAddon(int id, Proposal proposal, Addon addon) {
		super();
		this.id = id;
		this.proposal = proposal;
		this.addon = addon;
	}

	@Override
	public String toString() {
		return "ProposalAddon [id=" + id + ", proposal=" + proposal + ", addon=" + addon + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Proposal getProposal() {
		return proposal;
	}

	public void setProposal(Proposal proposal) {
		this.proposal = proposal;
	}

	public Addon getAddon() {
		return addon;
	}

	public void setAddon(Addon addon) {
		this.addon = addon;
	}
    
    
}
