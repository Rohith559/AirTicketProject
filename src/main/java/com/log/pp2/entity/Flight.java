package com.log.pp2.entity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Entity
@NoArgsConstructor
@Data
public class Flight {

    @Id
    @GeneratedValue(generator = "flightsequence",strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "flightsequence",allocationSize = 100, initialValue = 70000,sequenceName = "flightsequence")
    private long flightNumber;

    @ManyToOne
    @JoinColumn(name = "a_id")
    private Airline airline;

    private int totalSeats;
    @ManyToOne
    @JoinColumn(name = "source_id")
    private Location source;

    @ManyToOne
    @JoinColumn(name = "destination_id")
    private Location destination;


    private String departureTime;

    private int fare;

    private int availableSeats;

    private Date departDate;

    @Transient
    private int airlineId;

    @Transient
    private int sourceId;

    @Transient
    private int destinationId;


}
