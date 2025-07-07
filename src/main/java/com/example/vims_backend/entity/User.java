package com.example.vims_backend.entity;

import com.example.vims_backend.entity.enums.Role;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;
    
    private String name;
    
    private String email;
    
    private String password;
    
    private LocalDate dob;
    
    private String aadhaar;
    
    private String pan;
    
    @Enumerated(EnumType.STRING)
    private Role role;
    
    @CreationTimestamp 
    private LocalDateTime createdAt;
    
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public String getAadhaar() {
        return aadhaar;
    }

    public void setAadhaar(String aadhaar) {
        this.aadhaar = aadhaar;
    }

    public String getPan() {
        return pan;
    }

    public void setPan(String pan) {
        this.pan = pan;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime timestamp) {
        this.createdAt = timestamp;
    }

	public User(int userId, String name, String email, String password, LocalDate dob, String aadhaar, String pan,
			Role role, LocalDateTime createdAt) {
		super();
		this.userId = userId;
		this.name = name;
		this.email = email;
		this.password = password;
		this.dob = dob;
		this.aadhaar = aadhaar;
		this.pan = pan;
		this.role = role;
		this.createdAt = createdAt;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
   
}
