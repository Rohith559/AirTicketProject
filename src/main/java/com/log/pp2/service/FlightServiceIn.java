package com.log.pp2.service;

import com.log.pp2.entity.Flight;
import com.log.pp2.entity.Location;
import org.springframework.http.ResponseEntity;

public interface FlightServiceIn {

    Flight createFlight(Flight flight);
    ResponseEntity<Object> searchAvailableFlights(Location source, Location destination, String date);

    ResponseEntity<Object> getFlightById(long flightNumber);

    ResponseEntity<Object> getAllFlights();
}
