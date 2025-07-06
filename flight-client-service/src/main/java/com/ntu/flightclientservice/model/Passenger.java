package com.ntu.flightclientservice.model;

public class Passenger {
    private String passengerName;
    private String passengerPhone;
    private Double age;
    private String gender;
    private String country;

    public Passenger() {
    }

    public Passenger(String passengerName, String passengerPhone, Double age, String gender, String country) {
        this.passengerName = passengerName;
        this.passengerPhone = passengerPhone;
        this.age = age;
        this.gender = gender;
        this.country = country;
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
}