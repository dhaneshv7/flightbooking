package com.example.flightbooking.service;

import com.example.flightbooking.model.Booking;
import com.example.flightbooking.model.Flight;
import com.example.flightbooking.repository.BookingRepository;
import com.example.flightbooking.repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

import java.util.Optional;

@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private FlightRepository flightRepository;

    @Transactional
    public Booking createBooking(Booking booking) {
        // Step 1: Validate the booking data
        if (booking == null || booking.getFlightId() == null) {
            throw new IllegalArgumentException("Booking data and Flight ID cannot be null.");
        }

        // Step 2: Retrieve the flight to check seat availability
        Optional<Flight> optionalFlight = flightRepository.findById(booking.getFlightId());
        if (optionalFlight.isEmpty()) {
            throw new IllegalArgumentException("Flight with ID " + booking.getFlightId() + " not found.");
        }

        Flight flight = optionalFlight.get();

        // Step 3: Check if there are available seats
        if (flight.getAvailableSeats() <= 0) {
            throw new IllegalStateException("No seats available for this flight.");
        }

        // Step 4: Decrement the available seats and save the updated flight
        flight.setAvailableSeats(flight.getAvailableSeats() - 1);
        flightRepository.save(flight);

        // Step 5: Save the new booking
        return bookingRepository.save(booking);
    }
}