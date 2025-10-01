package com.example.flightbooking.service;

import com.example.flightbooking.model.Flight;
import com.example.flightbooking.repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class FlightService {

    @Autowired
    private FlightRepository flightRepository;

    public List<Flight> searchFlights(String origin, String destination) {
        return flightRepository.findByOriginAndDestination(origin, destination);
    }

    // Existing method to create a flight
    @Transactional
    public Flight createFlight(Flight flight) {
        if (flight.getFlightNumber() == null || flight.getOrigin() == null || flight.getDestination() == null) {
            throw new IllegalArgumentException("Flight number, origin, and destination cannot be null.");
        }
        // Set available seats to total seats by default
        flight.setAvailableSeats(flight.getTotalSeats());
        return flightRepository.save(flight);
    }
}