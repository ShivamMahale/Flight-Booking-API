package com.ntu.flightclientservice.model;

import java.time.LocalDate;

public class Flight {
    private Long id;
    private String flightNumber;
    private String airline;
    private String originCity;
    private String destinationCity;
    private Integer seats;
    private Integer numberOfConnection;
    private Double ticketPrice;
    private LocalDate dateOfDeparture;

    public Flight() {
    }

    public Flight(Long id, String flightNumber, String airline, String originCity, String destinationCity, Integer seats, Integer numberOfConnection, Double ticketPrice, LocalDate dateOfDeparture) {
        this.id = id;
        this.flightNumber = flightNumber;
        this.airline = airline;
        this.originCity = originCity;
        this.destinationCity = destinationCity;
        this.seats = seats;
        this.numberOfConnection = numberOfConnection;
        this.ticketPrice = ticketPrice;
        this.dateOfDeparture = dateOfDeparture;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public String getAirline() {
        return airline;
    }

    public void setAirline(String airline) {
        this.airline = airline;
    }

    public String getOriginCity() {
        return originCity;
    }

    public void setOriginCity(String originCity) {
        this.originCity = originCity;
    }

    public String getDestinationCity() {
        return destinationCity;
    }

    public void setDestinationCity(String destinationCity) {
        this.destinationCity = destinationCity;
    }

    public Integer getSeats() {
        return seats;
    }

    public void setSeats(Integer seats) {
        this.seats = seats;
    }

    public Integer getNumberOfConnection() {
        return numberOfConnection;
    }

    public void setNumberOfConnection(Integer numberOfConnection) {
        this.numberOfConnection = numberOfConnection;
    }

    public Double getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(Double ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    public LocalDate getDateOfDeparture() {
        return dateOfDeparture;
    }

    public void setDateOfDeparture(LocalDate dateOfDeparture) {
        this.dateOfDeparture = dateOfDeparture;
    }

    @Override
    public String toString() {
        return "Flight{" +
                "id=" + id +
                ", flightNumber='" + flightNumber + '\'' +
                ", airline='" + airline + '\'' +
                ", originCity='" + originCity + '\'' +
                ", destinationCity='" + destinationCity + '\'' +
                ", seats=" + seats +
                ", numberOfConnection=" + numberOfConnection +
                ", ticketPrice=" + ticketPrice +
                ", dateOfDeparture=" + dateOfDeparture +
                '}';
    }
}