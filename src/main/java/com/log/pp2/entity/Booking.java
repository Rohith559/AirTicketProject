package com.log.pp2.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;



import java.time.LocalDate;


@Entity
@Data
public class Booking {
    @Id
    @GeneratedValue(generator = "booking_sequence",strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "booking_sequence",allocationSize = 100, initialValue = 4000,sequenceName = "booking_sequence")
    private Long bookingId;

    private LocalDate bookingDate;

    @Transient
    private int flightNumber;

    @ManyToOne
    @JoinColumn(name = "flight_no")
    @NotNull(message = "Choose correct flightNumber")
    private Flight flight;

    @Transient
    private  int customerNumber;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    @NotNull(message = "Give your correct customerId to book tickets")
    private CustomerRegistration customer;

    private int totalPrice;

    private int seatsTOBook;
    @NotNull(message = "By default the departureDate will be five days after bookingDate")
    private LocalDate departureDate;

    public Booking(){
        this.bookingDate = LocalDate.now();
        this.departureDate = LocalDate.now().plusDays(1);
    }

}
