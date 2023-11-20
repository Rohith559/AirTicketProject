package com.log.pp2.service;

import com.log.pp2.entity.Airline;
import org.springframework.http.ResponseEntity;


public interface AirlineServiceIn {
    Airline createAirline(Airline airLine);

    ResponseEntity<Object> getAllAirlines();
}
