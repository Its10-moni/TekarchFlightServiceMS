package com.example.TekarchFlightServiceMS.Models;

import lombok.Data;

@Data
public class Flight {
    private Long flightId;
    private String flightNumber;
    private String departure;
    private String arrival;
    private Double price;
    private Integer availableSeats;
}
