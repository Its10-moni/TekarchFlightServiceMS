package com.example.TekarchFlightServiceMS.Controller;

import com.example.TekarchFlightServiceMS.Models.Flight;
import com.example.TekarchFlightServiceMS.Services.FlightServicesImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/flights")
public class FlightServiceController {
    @Autowired
    private FlightServicesImpl flightServices;

    @PostMapping
    public Flight createFlight(@RequestBody Flight flight) {
        return flightServices.createFlight(flight);
    }
     @GetMapping
    public ResponseEntity<List<Flight>> getAllFlights() {
        return new ResponseEntity<>(flightServices.getAllFlights(), HttpStatus.OK);
    }

    @GetMapping("/{flightId}")
    public Flight getFlightById(@PathVariable Long flightId) {
        return flightServices.getFlightByflightId(flightId);
    }
    @PutMapping("/flights")
    public void updateFlight(@RequestBody Flight flight) {
        flightServices.updateFlight(flight);
    }

    @PutMapping("/{flightId}")
    public void updateFlight(@PathVariable Long flightId, @RequestBody Flight flight) {
        flightServices.updateFlightByflightId(flightId, flight);
    }

    @DeleteMapping("/{flightId}")
    public void deleteFlightByflightId(@PathVariable Long flightId) {
        flightServices.deleteByflightId(flightId);
    }
}
