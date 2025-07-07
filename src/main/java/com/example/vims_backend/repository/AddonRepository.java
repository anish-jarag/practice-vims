package com.example.vims_backend.repository;

import com.example.vims_backend.entity.Addon;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddonRepository extends JpaRepository<Addon, Integer> {
}
