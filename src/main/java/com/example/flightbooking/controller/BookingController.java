package com.example.flightbooking.controller;

import com.example.flightbooking.model.Booking;
import com.example.flightbooking.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/bookings")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    /**
     * Endpoint to create a new flight booking.
     *
     * @param booking The Booking object to be saved, received in the request body.
     * @return A ResponseEntity with the created Booking object and HTTP status 201.
     */
    @PostMapping
    public ResponseEntity<Booking> createBooking(@RequestBody Booking booking) {
        Booking newBooking = bookingService.createBooking(booking);
        return new ResponseEntity<>(newBooking, HttpStatus.CREATED);
    }
}