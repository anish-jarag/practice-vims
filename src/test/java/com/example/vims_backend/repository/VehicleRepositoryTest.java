package com.example.vims_backend.repository;

import com.example.vims_backend.entity.User;
import com.example.vims_backend.entity.Vehicle;
import com.example.vims_backend.entity.enums.Role;
import com.example.vims_backend.entity.enums.VehicleType;
import com.example.vims_backend.repository.UserRepository;
import com.example.vims_backend.repository.VehicleRepository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class VehicleRepositoryTest {

    @Autowired
    private VehicleRepository vehicleRepository;

    @Autowired
    private UserRepository userRepository;

    @Test
    public void testSaveAndFindByUserId() {
        User user = new User();
        user.setName("Vehicle User");
        user.setEmail("vehuser@example.com");
        user.setPassword("pass");
        user.setDob(LocalDate.of(1995, 5, 15));
        user.setAadhaar("111122223333");
        user.setPan("XYZAB1234C");
        user.setRole(Role.USER);

        userRepository.save(user);

        Vehicle vehicle = new Vehicle();
        vehicle.setUserId(user.getUserId());
        vehicle.setType(VehicleType.CAR);
        vehicle.setMake("Toyota");
        vehicle.setModel("Fortuner");
        vehicle.setRegistrationNumber("MH12AB1234");
        vehicle.setManufactureYear(2020);

        vehicleRepository.save(vehicle);

        List<Vehicle> vehicles = vehicleRepository.findByUserId(user.getUserId());

        assertThat(vehicles).isNotEmpty();
        assertThat(vehicles.get(0).getMake()).isEqualTo("Toyota");
    }
}
