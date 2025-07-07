package com.example.vims_backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.vims_backend.entity.Vehicle;
import com.example.vims_backend.service.VehicleService;

@RestController
@RequestMapping(("/api/vehicles"))
public class VehicleRestController {
	
	@Autowired
	private VehicleService vehicleService;
	
//	Add vehicle
	@PostMapping
	public ResponseEntity<Vehicle> addVehicle(@RequestBody Vehicle vehicle){
		return ResponseEntity.ok(vehicleService.addVehicle(vehicle));
	}
	
//	Get all vehicles for admin
    @GetMapping
    public ResponseEntity<List<Vehicle>> getAllVehicles() {
        return ResponseEntity.ok(vehicleService.getAllVehicles());
    }

//	Get vehicle by ID
    @GetMapping("/{id}")
    public ResponseEntity<Vehicle> getVehicleById(@PathVariable int id) {
        Vehicle vehicle = vehicleService.getVehicleById(id);
        if (vehicle != null) {
            return ResponseEntity.ok(vehicle);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

//	Get all vehicles for user
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Vehicle>> getByUser(@PathVariable int userId) {
        return ResponseEntity.ok(vehicleService.getVehiclesByUserId(userId));
    }

//	Delete vehicle
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteVehicle(@PathVariable int id) {
        vehicleService.deleteVehicle(id);
        return ResponseEntity.ok("Vehicle deleted");
    }

//	Update vehicle
    @PutMapping("/{id}")
    public ResponseEntity<Vehicle> updateVehicle(@PathVariable int id, @RequestBody Vehicle vehicle) {
        Vehicle updated = vehicleService.updateVehicle(id, vehicle);
        if (updated != null) {
            return ResponseEntity.ok(updated);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
