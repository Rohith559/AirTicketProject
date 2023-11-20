package com.log.pp2.service;

import com.log.pp2.entity.Booking;
import com.log.pp2.entity.Flight;
import com.log.pp2.repository.BookingRepository;
import com.log.pp2.repository.CustomerRegisRepo;
import com.log.pp2.repository.FlightRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;



@Service
public class BookingServiceImpl implements BookingServiceIn {

    private final BookingRepository bookingRepository;
    private final FlightRepository flightRepository;

    private final CustomerRegisRepo customerRegisRepo;

    public BookingServiceImpl(BookingRepository bookingRepository,FlightRepository flightRepository,CustomerRegisRepo customerRegisRepo){
        this.bookingRepository = bookingRepository;
        this.flightRepository = flightRepository;
        this.customerRegisRepo = customerRegisRepo;
    }


    @Override
    public void bookFlight(Booking booking) {
        booking.setFlight(flightRepository.findById(booking.getFlightNumber()));
        booking.setCustomer(customerRegisRepo.findById(booking.getCustomerNumber()));
        List<Flight> flight = flightRepository.findAll();
        for (Flight flight1 : flight) {
            Flight fm1 = booking.getFlight();
            long flight2 = fm1.getFlightNumber();
            if (flight2 == flight1.getFlightNumber() && (flight1.getAvailableSeats() >= booking.getSeatsTOBook())) {
                    int availabeSeats = flight1.getAvailableSeats() - booking.getSeatsTOBook();
                    flight1.setAvailableSeats(availabeSeats);
                    flightRepository.save(flight1);
                    int price = booking.getSeatsTOBook() * flight1.getFare();
                    booking.setTotalPrice(price);
                    bookingRepository.save(booking);

            }
        }
        ResponseEntity.status(HttpStatus.NOT_FOUND).body("Ticket Booked Successfully");
    }

    @Override
    public ResponseEntity<Object> getAllBookings () {
        List<Booking> bookings = bookingRepository.findAll();
        if (bookings.isEmpty()) {
            String msg = "There is no data in booking table";
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(msg);
        } else {
            return ResponseEntity.ok(bookings);
        }
    }

    @Override
    public List<Booking> findByDate(LocalDate bookingDate) {
        return bookingRepository.findByBookingDate(bookingDate);
    }


}
