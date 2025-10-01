package com.example.flightbooking.service;

import com.example.flightbooking.model.Admin;
import com.example.flightbooking.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class AdminService {

    @Autowired
    private AdminRepository adminRepository;

    public Optional<Admin> findByUsername(String username) {
        return adminRepository.findByUsername(username);
    }

    public Admin registerAdmin(Admin admin) {
        // You would add password hashing here.
        // For example: admin.setPassword(passwordEncoder.encode(admin.getPassword()));

        if (adminRepository.findByUsername(admin.getUsername()).isPresent()) {
            throw new IllegalArgumentException("Username already exists");
        }

        return adminRepository.save(admin);
    }
}