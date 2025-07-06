package com.ntu.flightclientservice.model;

public class SearchFlight {
    private String to;
    private String from;
    private String date;

    public SearchFlight() {
    }

    public SearchFlight(String to, String from, String date) {
        this.to = to;
        this.from = from;
        this.date = date;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}