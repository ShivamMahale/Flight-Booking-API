package com.ntu.flightclientservice.model;

import java.time.LocalDate;


public class BookingInfo {
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

    public BookingInfo() {
    }

    public BookingInfo(Long bookingId, String userId, String passengerName, String passengerPhone, Double age, String gender, String country, LocalDate bookingDate, String flightNumber, Double ticketPrice, String airline, String originCity, String destinationCity, LocalDate dateOfDeparture) {
        this.bookingId = bookingId;
        this.userId = userId;
        this.passengerName = passengerName;
        this.passengerPhone = passengerPhone;
        this.age = age;
        this.gender = gender;
        this.country = country;
        this.bookingDate = bookingDate;
        this.flightNumber = flightNumber;
        this.ticketPrice = ticketPrice;
        this.airline = airline;
        this.originCity = originCity;
        this.destinationCity = destinationCity;
        this.dateOfDeparture = dateOfDeparture;
    }

    public Long getBookingId() {
        return bookingId;
    }

    public void setBookingId(Long bookingId) {
        this.bookingId = bookingId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPassengerName() {
        return passengerName;
    }

    public void setPassengerName(String passengerName) {
        this.passengerName = passengerName;
    }

    public Double getAge() {
        return age;
    }

    public void setAge(Double age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public LocalDate getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(LocalDate bookingDate) {
        this.bookingDate = bookingDate;
    }

    public String getPassengerPhone() {
        return passengerPhone;
    }

    public void setPassengerPhone(String passengerPhone) {
        this.passengerPhone = passengerPhone;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public Double getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(Double ticketPrice) {
        this.ticketPrice = ticketPrice;
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

    public LocalDate getDateOfDeparture() {
        return dateOfDeparture;
    }

    public void setDateOfDeparture(LocalDate dateOfDeparture) {
        this.dateOfDeparture = dateOfDeparture;
    }
}