package com.log.pp2.controller;

import com.log.pp2.entity.Airline;
import com.log.pp2.service.AirlineServiceIn;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping(path = "/airline-api")
public class AirController {
    private static final Logger logger = LoggerFactory.getLogger(AirController.class);

    private  final AirlineServiceIn airlineServiceIn;

    public AirController(AirlineServiceIn airlineServiceIn){
        this.airlineServiceIn = airlineServiceIn;
    }


    @PostMapping(path = "/airDetails")
    public Airline createAirline(@RequestBody Airline airLine){
        logger.info("Registering new AirLine");
        return airlineServiceIn.createAirline(airLine);
    }


    @GetMapping(path = "/all")
    public ResponseEntity<Object> getAllLocations() {
        logger.info(("To Display all Flight details.."));
        return airlineServiceIn.getAllAirlines();
    }
}
