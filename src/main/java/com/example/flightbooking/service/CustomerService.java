package com.example.flightbooking.service;

import com.example.flightbooking.model.Customer;
import com.example.flightbooking.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    /**
     * Registers a new customer in the system.
     * In a real application, this method would include password hashing and validation.
     *
     * @param customer The Customer object to be saved.
     * @return The newly registered Customer object.
     */
    public Customer registerCustomer(Customer customer) {
        // Here, you would implement password hashing (e.g., using BCryptPasswordEncoder)
        // and validation to ensure the customer data is valid before saving.
        customer.setRegistrationDate(LocalDateTime.now());
        return customerRepository.save(customer);
    }

    /**
     * Retrieves a customer by their unique ID.
     *
     * @param id The ID of the customer to retrieve.
     * @return An Optional containing the Customer if found, or an empty Optional otherwise.
     */
    public Optional<Customer> getCustomerById(Long id) {
        return customerRepository.findById(id);
    }
}