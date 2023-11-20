package com.log.pp2.service;


import com.log.pp2.entity.Booking;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;
import java.util.List;


public interface BookingServiceIn {
     void bookFlight(Booking booking);

     ResponseEntity<Object> getAllBookings();
    List<Booking> findByDate(LocalDate bookingDate);
}
