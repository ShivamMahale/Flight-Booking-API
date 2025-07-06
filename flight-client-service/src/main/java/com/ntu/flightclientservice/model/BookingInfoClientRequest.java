package com.ntu.flightclientservice.model;

public class BookingInfoClientRequest {
    private String userId;
    private String flightId;
    private String ticketPrice;
    private String passengerName;
    private String passengerPhone;
    private String age;
    private String gender;
    private String country;

    public BookingInfoClientRequest() {
    }

    public BookingInfoClientRequest(String userId, String flightId, String ticketPrice, String passengerName, String passengerPhone, String age, String gender, String country) {
        this.userId = userId;
        this.flightId = flightId;
        this.ticketPrice = ticketPrice;
        this.passengerName = passengerName;
        this.passengerPhone = passengerPhone;
        this.age = age;
        this.gender = gender;
        this.country = country;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getFlightId() {
        return flightId;
    }

    public void setFlightId(String flightId) {
        this.flightId = flightId;
    }

    public String getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(String ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    public String getPassengerName() {
        return passengerName;
    }

    public void setPassengerName(String passengerName) {
        this.passengerName = passengerName;
    }

    public String getPassengerPhone() {
        return passengerPhone;
    }

    public void setPassengerPhone(String passengerPhone) {
        this.passengerPhone = passengerPhone;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
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

}