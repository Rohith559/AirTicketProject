package com.log.pp2.repository;

import com.log.pp2.entity.Flight;
import com.log.pp2.entity.Location;
import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.Date;
import java.util.List;

public interface FlightRepository extends JpaRepository<Flight,Long> {

    List<Flight> findBySourceAndDestinationAndDepartDate(Location source, Location destination, Date date);

    Flight findById(long flightId);
}
