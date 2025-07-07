package com.example.vims_backend.service;

import com.example.vims_backend.entity.Vehicle;
import com.example.vims_backend.repository.VehicleRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VehicleService {

    @Autowired
    private VehicleRepository vehicleRepository;

    public Vehicle addVehicle(Vehicle vehicle) {
        return vehicleRepository.save(vehicle);
    }

    public List<Vehicle> getAllVehicles() {
        return vehicleRepository.findAll();
    }

    public Vehicle getVehicleById(int id) {
        return vehicleRepository.findById(id).orElse(null);
    }

    public List<Vehicle> getVehiclesByUserId(int userId) {
        return vehicleRepository.findByUser_UserId(userId);
    }

    public void deleteVehicle(int id) {
        vehicleRepository.deleteById(id);
    }

    public Vehicle updateVehicle(int id, Vehicle updatedVehicle) {
        Optional<Vehicle> optional = vehicleRepository.findById(id);
        if (optional.isPresent()) {
            Vehicle existing = optional.get();
            existing.setMake(updatedVehicle.getMake());
            existing.setModel(updatedVehicle.getModel());
            existing.setRegistrationNumber(updatedVehicle.getRegistrationNumber());
            existing.setManufactureYear(updatedVehicle.getManufactureYear());
            existing.setType(updatedVehicle.getType());
            return vehicleRepository.save(existing);
        }
        return null;
    }
}
