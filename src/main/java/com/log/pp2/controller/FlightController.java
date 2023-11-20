package com.log.pp2.controller;

import com.log.pp2.entity.Flight;
import com.log.pp2.entity.Location;
import com.log.pp2.service.FlightServiceIn;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping(path = "/flight-api")
public class FlightController {
    private static final Logger logger = LoggerFactory.getLogger(FlightController.class);

    private final FlightServiceIn flightServiceIn;

    public FlightController(FlightServiceIn flightServiceIn){
        this.flightServiceIn=flightServiceIn;
    }

    @PostMapping(path = "/flightStats")
    public Flight createFlight(@RequestBody Flight flight){
        logger.info("To register new flights");
        return flightServiceIn.createFlight(flight);
    }

    @GetMapping(path = "/find")
    public ResponseEntity<Object> searchAvailableFlights(@RequestParam Location source,@RequestParam Location destination,@RequestParam String date) {
        logger.info("To see avaliable flights from particular source and destination");
        return flightServiceIn.searchAvailableFlights(source, destination, date);
    }

    @GetMapping(path = "/flight")
    @ResponseBody
    public ResponseEntity<Object> getFlightById(@RequestParam("id") long id){
        logger.info("Fetching details of particular id");
        return flightServiceIn.getFlightById(id);
    }

    @GetMapping(path="/allFlights")
    public ResponseEntity<Object> getAllFlights(){
        logger.info("To get all flight deatils");
        return  flightServiceIn.getAllFlights();
    }
}
