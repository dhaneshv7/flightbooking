package com.example.flightbooking.controller;

import com.example.flightbooking.model.Admin;
import com.example.flightbooking.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @PostMapping("/login")
    public ResponseEntity<String> adminLogin(@RequestBody Map<String, String> loginDetails) {
        String username = loginDetails.get("username");
        String password = loginDetails.get("password");

        Optional<Admin> adminOptional = adminService.findByUsername(username);

        if (adminOptional.isPresent()) {
            Admin admin = adminOptional.get();
            // In a real app, you would compare hashed passwords here
            if (admin.getPassword().equals(password)) {
                return new ResponseEntity<>("Login successful!", HttpStatus.OK);
            }
        }
        return new ResponseEntity<>("Invalid credentials", HttpStatus.UNAUTHORIZED);
    }

    @PostMapping("/register")
    public ResponseEntity<Admin> registerAdmin(@RequestBody Admin admin) {
        Admin newAdmin = adminService.registerAdmin(admin);
        return new ResponseEntity<>(newAdmin, HttpStatus.CREATED);
    }
}