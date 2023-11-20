package com.log.pp2.repository;

import com.log.pp2.entity.Location;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepository extends JpaRepository<Location,Integer> {
    Location findById(int locationId);
}
