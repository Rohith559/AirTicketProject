package com.log.pp2.service;

import com.log.pp2.entity.Location;
import com.log.pp2.repository.LocationRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationServiceImpl implements LocationServiceIn{
    private final LocationRepository locationRepository;
    public LocationServiceImpl(LocationRepository locationRepository){
        this.locationRepository=locationRepository;
    }

    @Override
    public Location addLocation(Location location) {
        return locationRepository.save(location);
    }

    @Override
    public ResponseEntity<Object> getAllLocations() {
        List<Location> locations = locationRepository.findAll();
        if (locations.isEmpty()) {
            String msg = "Location table is empty";
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(msg);
        } else {
            return ResponseEntity.ok(locations);
        }
    }
}
