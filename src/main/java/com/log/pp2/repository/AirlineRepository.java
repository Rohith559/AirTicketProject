package com.log.pp2.repository;


import com.log.pp2.entity.Airline;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AirlineRepository extends JpaRepository<Airline,Integer> {
    Airline findById(int airlineId);
}
