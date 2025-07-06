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
@Entity
@Table(name = "booking_info")
public class BookingInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long bookingId;
    private String userId;
    private String passengerName;
    private String passengerPhone;
    private Double age;
    private String gender;
    private String country;
    private LocalDate bookingDate;
    private String flightNumber;
    private Double ticketPrice;
    private String airline;
    private String originCity;
    private String destinationCity;
    private LocalDate dateOfDeparture;

   }