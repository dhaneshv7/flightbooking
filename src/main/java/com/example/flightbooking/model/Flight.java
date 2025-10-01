package com.example.flightbooking.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Data // Lombok annotation for getters, setters, etc.
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String flightNumber;
    private String origin;
    private String destination;
    private LocalDateTime departureTime;
    private LocalDateTime arrivalTime;
    private double price;
    private int totalSeats;
    private int availableSeats;
    private String flightClass; // e.g., "Economy", "Business"
    private String type; // "Domestic" or "International"
}