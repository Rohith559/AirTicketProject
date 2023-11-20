package com.log.pp2.controller;

import com.log.pp2.entity.Location;
import com.log.pp2.service.LocationServiceIn;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping(path = "/location-api")
public class LocationController {
    private static final Logger logger = LoggerFactory.getLogger(LocationController.class);

    private final LocationServiceIn locationServiceIn;
    public LocationController(LocationServiceIn locationServiceIn){
        this.locationServiceIn = locationServiceIn;
    }

    @PostMapping(path = "/location_details")
    public Location addLocation(@RequestBody Location location){
        logger.info("To Add new Location");
        return locationServiceIn.addLocation(location);
    }

    @GetMapping(path = "/all")
    public ResponseEntity<Object> getAllLocations() {
        logger.info("To get all location details");
        return locationServiceIn.getAllLocations();
    }

}
