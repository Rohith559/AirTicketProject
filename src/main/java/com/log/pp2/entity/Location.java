package com.log.pp2.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Data
public class Location {
    @Id
    @GeneratedValue(generator = "location_sequence",strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "location_sequence",allocationSize = 100, initialValue = 10000,sequenceName = "location_sequence")
    private int locationId;

    @NotNull(message = "Give correct location name")
    private String locationName;

}
