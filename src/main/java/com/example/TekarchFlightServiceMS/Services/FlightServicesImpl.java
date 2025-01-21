package com.example.TekarchFlightServiceMS.Services;

import com.example.TekarchFlightServiceMS.Models.Flight;
import com.example.TekarchFlightServiceMS.Services.Interfaces.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class FlightServicesImpl implements FlightService {
    @Autowired
    private RestTemplate restTemplate;
    @Value("${DATASERVICE.URL}")
    String DATASERVICE_URL;

    @Override
    public Flight createFlight(Flight flight) {
        return restTemplate.postForObject(DATASERVICE_URL, flight, Flight.class);
    }
    @Override
    public List<Flight> getAllFlights() {
        ResponseEntity<List<Flight>> response = restTemplate.exchange(
                DATASERVICE_URL,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Flight>>() {}
        );
        return response.getBody();
    }
    @Override
    public Flight getFlightByflightId(Long flightId) {
        return restTemplate.getForObject(DATASERVICE_URL +"/" + flightId, Flight.class);
    }

    @Override
    public void updateFlight(Flight flight) {
        String url = DATASERVICE_URL + "/" + flight.getFlightNumber();
        Flight existingFlight = restTemplate.getForObject(url, Flight.class);
        if (existingFlight != null) {
            restTemplate.put(url, flight);
        } else {
            throw new RuntimeException("Flight not found");
        }
    }
    @Override
    public void updateFlightByflightId(Long flightId, Flight flight) {
        restTemplate.put(DATASERVICE_URL + "/" + flightId, flight);
    }

    @Override
    public void deleteByflightId(Long flightId) {
        restTemplate.delete(DATASERVICE_URL + "/" + flightId);
    }
}
