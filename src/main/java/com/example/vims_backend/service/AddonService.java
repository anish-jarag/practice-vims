package com.example.vims_backend.service;

import com.example.vims_backend.entity.Addon;
import com.example.vims_backend.repository.AddonRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddonService {

    @Autowired
    private AddonRepository addonRepository;

    public Addon getAddonById(int id) {
        return addonRepository.findById(id).orElse(null);
    }
    
    public List<Addon> getAllAddons() {
        return addonRepository.findAll();
    }
}