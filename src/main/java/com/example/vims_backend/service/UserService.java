package com.example.vims_backend.service;

import com.example.vims_backend.entity.User;
import com.example.vims_backend.entity.enums.Role;
import com.example.vims_backend.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

//	Register a new user
    public User registerUser(User user) {
        if (user.getRole() == null) {
            user.setRole(Role.USER); // Default role
        }
        return userRepository.save(user);
    }

//	Authenticate by email and password
    public User authenticate(String email, String password) {
        User user = userRepository.findByEmail(email);
        return (user != null && user.getPassword().equals(password)) ? user : null;
    }

//	Check if email already exists
    public boolean emailExists(String email) {
        return userRepository.findByEmail(email) != null;
    }

//	Get user by ID
    public User getUserById(int userId) {
        return userRepository.findById(userId).orElse(null);
    }

//	Get all users
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

//	Update user
    public User updateUser(int id, User updatedUser) {
        User existing = getUserById(id);
        if (existing != null) {
            existing.setName(updatedUser.getName());
            existing.setDob(updatedUser.getDob());
            existing.setAadhaar(updatedUser.getAadhaar());
            existing.setPan(updatedUser.getPan());
            existing.setEmail(updatedUser.getEmail());
            return userRepository.save(existing);
        }
        return null;
    }

//	Delete user
    public boolean deleteUser(int id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
