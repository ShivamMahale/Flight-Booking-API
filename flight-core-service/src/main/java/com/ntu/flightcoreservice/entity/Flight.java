package com.ntu.flightcoreservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Flight {
    private Long id;
    private String flightNumber;
    private String airline;
    private String originCity;
    private String destinationCity;
    private LocalDate dateOfDeparture;
    private Integer seats;
    private Integer numberOfConnection;
    private Double ticketPrice;

}