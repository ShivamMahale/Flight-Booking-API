package com.ntu.flightclientservice.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ntu.flightclientservice.model.CurrencyRequest;
import com.ntu.flightclientservice.model.Flight;
import com.ntu.flightclientservice.model.SearchFlight;
import com.ntu.flightclientservice.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;


@Service
public class FlightService {
    @Value("${flight.core.base-url}")
    private String flightCoreBaseUrl;
    @Value("${currency.exchange.base-url}")
    private String currencyExchangeBaseUrl;
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private ObjectMapper objectMapper;

    public List<Flight> searchFlights(SearchFlight searchFlightRequest) throws JsonProcessingException {
        ResponseEntity<Object> response = restTemplate.postForEntity(flightCoreBaseUrl + "/api/flights/search", searchFlightRequest, Object.class);
        if (response.getStatusCode().is2xxSuccessful()) {
            System.out.println("Ok");
            List<Flight> flightList = (List<Flight>) response.getBody();
            System.out.println(flightList);
            return flightList;
        }
        return List.of(new Flight());
    }

    public double getExchangeCurrency(String ticketPrice, String currency) {
        //http://localhost:7001/api/currency-exchange/convert
        CurrencyRequest currencyRequest = new CurrencyRequest();
        currencyRequest.setSourceCurrency("USD");
        currencyRequest.setTargetCurrency(currency);
        currencyRequest.setAmount(Double.parseDouble(ticketPrice));
        ResponseEntity<Double> response = restTemplate.postForEntity(currencyExchangeBaseUrl + "/api/currency-exchange/convert", currencyRequest, double.class);
        if (response.getStatusCode().is2xxSuccessful()) {
            return response.getBody();
        }
        return -1;
    }
}