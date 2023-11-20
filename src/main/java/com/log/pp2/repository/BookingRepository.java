package com.log.pp2.repository;

import com.log.pp2.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface BookingRepository extends JpaRepository<Booking,Integer> {
    List<Booking> findByBookingDate(LocalDate bookingDate);
}
