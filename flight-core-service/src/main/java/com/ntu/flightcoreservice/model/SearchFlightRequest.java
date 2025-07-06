package com.ntu.flightcoreservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SearchFlightRequest {
    private String from;
    private String to;
    private String date;
}