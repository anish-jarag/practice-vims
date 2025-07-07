package com.example.vims_backend.repository;

import com.example.vims_backend.entity.Vehicle;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleRepository extends JpaRepository<Vehicle, Integer> {
	List<Vehicle> findByUser_UserId(int userId);
}
