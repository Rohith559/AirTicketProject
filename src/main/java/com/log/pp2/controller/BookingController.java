package com.log.pp2.controller;

import com.log.pp2.entity.Booking;
import com.log.pp2.service.BookingServiceIn;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;



@RestController
@RequestMapping("/booking-api")
public class BookingController {
    private static final Logger logger = LoggerFactory.getLogger(BookingController.class);

    private final BookingServiceIn bookingServiceIn;

    public BookingController(BookingServiceIn bookingServiceIn){
        this.bookingServiceIn = bookingServiceIn;
    }


    @PostMapping("/book")
    public boolean flightBooking(@RequestBody Booking booking) {
        logger.info("booking flight ticket");
        bookingServiceIn.bookFlight(booking);
        return true;
    }

    @GetMapping(path="/all")
    public ResponseEntity<Object> getAllBookings() {
        logger.info("Getting all booked ticket deatils");
        return bookingServiceIn.getAllBookings();
    }

    @GetMapping(path="/getByDate")
    public List<Booking> getByDate(@RequestParam("bookingDate") LocalDate date){
        return bookingServiceIn.findByDate(date);
    }
}
