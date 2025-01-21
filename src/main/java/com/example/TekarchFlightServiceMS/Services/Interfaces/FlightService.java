package com.example.TekarchFlightServiceMS.Services.Interfaces;

import com.example.TekarchFlightServiceMS.Models.Flight;

import java.util.List;

public interface FlightService {
    Flight createFlight(Flight flight);
    List<Flight> getAllFlights();
    Flight getFlightByflightId(Long flightId);
    void updateFlight(Flight flight);
    void updateFlightByflightId(Long flightId, Flight flight);
    void deleteByflightId(Long flightId);
}
