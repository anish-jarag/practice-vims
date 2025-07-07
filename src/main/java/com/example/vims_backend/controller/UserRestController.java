package com.example.vims_backend.controller;

import com.example.vims_backend.entity.User;
import com.example.vims_backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserRestController {

    @Autowired
    private UserService userService;

//	Register User
    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody User user) {
        if (userService.emailExists(user.getEmail())) {
            return ResponseEntity.badRequest().body("Email already exists.");
        }
        User savedUser = userService.registerUser(user);
        return ResponseEntity.ok(savedUser);
    }

// 	Login
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestParam String email, @RequestParam String password) {
        User user = userService.authenticate(email, password);
        if (user != null) {
            return ResponseEntity.ok(user);
        }
        return ResponseEntity.badRequest().body("Invalid credentials.");
    }

//	Get user by ID
    @GetMapping("/{id}")
    public ResponseEntity<?> getUser(@PathVariable int id) {
        User user = userService.getUserById(id);
        return (user != null) ? ResponseEntity.ok(user) : ResponseEntity.notFound().build();
    }

//	Get all users
    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

//	Update user by ID
    @PutMapping("/{id}")
    public ResponseEntity<?> updateUser(@PathVariable int id, @RequestBody User updatedUser) {
        User updated = userService.updateUser(id, updatedUser);
        if (updated != null) {
            return ResponseEntity.ok(updated);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

//	Delete user by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable int id) {
        boolean deleted = userService.deleteUser(id);
        return deleted ?
            ResponseEntity.ok("User deleted successfully.") :
            ResponseEntity.status(404).body("User not found.");
    }
}
