package com.log.pp2.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Entity
@Data
@NoArgsConstructor
public class Airline {
    @Id
    @GeneratedValue(generator = "airlinesequence",strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "airlinesequence",allocationSize = 100, initialValue =6000, sequenceName = "airlinesequence")
    private int airlineId;

    @NotNull(message = "AirLine need to have name to it")
    private String airlineName;
    @Past(message = "It need to be past date")
    private Date dateOfOperation;


}
