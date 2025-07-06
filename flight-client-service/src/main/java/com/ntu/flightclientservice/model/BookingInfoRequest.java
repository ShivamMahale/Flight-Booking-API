package com.ntu.flightclientservice.model;

import java.util.List;

public class BookingInfoRequest {
    private String userId;
    private Long flightId;
    private Double ticketPrice;
    private List<Passenger> passenger;

    public BookingInfoRequest() {
    }

    public BookingInfoRequest(String userId, Long flightId, Double ticketPrice, List<Passenger> passenger) {
        this.userId = userId;
        this.flightId = flightId;
        this.ticketPrice = ticketPrice;
        this.passenger = passenger;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Long getFlightId() {
        return flightId;
    }

    public void setFlightId(Long flightId) {
        this.flightId = flightId;
    }

    public Double getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(Double ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    public List<Passenger> getPassenger() {
        return passenger;
    }

    public void setPassenger(List<Passenger> passenger) {
        this.passenger = passenger;
    }
}