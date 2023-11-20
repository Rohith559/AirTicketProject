package com.log.pp2.service;

import com.log.pp2.entity.Airline;
import com.log.pp2.repository.AirlineRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AirlineServiceImpl implements AirlineServiceIn{


    private  final AirlineRepository airlineRepository;

    public AirlineServiceImpl(AirlineRepository airlineRepository){
        this.airlineRepository = airlineRepository;
    }

    @Override
    public Airline createAirline(Airline airLine) {
        return airlineRepository.save(airLine);
    }

    @Override
    public ResponseEntity<Object> getAllAirlines() {
        List<Airline> airline = airlineRepository.findAll();
        if (airline.isEmpty()) {
            String msg = "AirLine table is empty";
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(msg);
        } else {
            return ResponseEntity.ok(airline);
        }
    }
}
