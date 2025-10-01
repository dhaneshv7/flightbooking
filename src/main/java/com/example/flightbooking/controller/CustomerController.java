package com.example.flightbooking.controller;

import com.example.flightbooking.model.Customer;
import com.example.flightbooking.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    /**
     * Endpoint to register a new customer.
     * @param customer The Customer object to be saved, received in the request body.
     * @return A ResponseEntity with the registered Customer object and HTTP status 201.
     */
    @PostMapping("/register")
    public ResponseEntity<Customer> registerCustomer(@RequestBody Customer customer) {
        Customer newCustomer = customerService.registerCustomer(customer);
        return new ResponseEntity<>(newCustomer, HttpStatus.CREATED);
    }

    /**
     * Endpoint to get customer details by ID.
     * @param id The ID of the customer.
     * @return A ResponseEntity with the Customer object if found, or HTTP status 404 if not.
     */
    @GetMapping("/{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable Long id) {
        Optional<Customer> customer = customerService.getCustomerById(id);
        return customer.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}