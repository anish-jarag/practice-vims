package com.example.vims_backend.repository;

import com.example.vims_backend.entity.User;


import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
	User findByEmail(String email);
}