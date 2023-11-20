package com.log.pp2.service;

import com.log.pp2.entity.Location;
import org.springframework.http.ResponseEntity;

public interface LocationServiceIn {
    Location addLocation(Location location);
    ResponseEntity<Object> getAllLocations();
}
