package com.example.flightbooking.repository;

import com.example.flightbooking.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface BookingRepository extends JpaRepository<Booking, Long> {

    /**
     * Finds a list of bookings associated with a specific customer ID.
     * This is an example of a derived query from Spring Data JPA.
     * @param customerId The ID of the customer
     * @return A list of Booking objects
     */
    List<Booking> findByCustomerId(Long customerId);
}