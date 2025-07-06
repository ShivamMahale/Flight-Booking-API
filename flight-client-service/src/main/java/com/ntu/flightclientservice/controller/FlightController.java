package com.ntu.flightclientservice.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.ntu.flightclientservice.model.Flight;
import com.ntu.flightclientservice.model.SearchFlight;
import com.ntu.flightclientservice.service.FlightService;
import com.ntu.flightclientservice.util.AppConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

@Controller
@RequestMapping("/flight-service")
public class FlightController {

    @Autowired
    FlightService flightService;

    @GetMapping("/")
    public String getHomePage(Model model) {
        return "home";
    }

    @GetMapping("/search")
    public String searchFlight(Model model) {
        model.addAttribute("searchFlight", new SearchFlight());
        model.addAttribute("options", AppConstants.CITY_LIST);
        return "search-flight";
    }

    @PostMapping("/search")
    public String findFlight(@ModelAttribute("searchFlight") SearchFlight searchFlight, Model model) throws ParseException, JsonProcessingException {
        List<Flight> flights = flightService.searchFlights(searchFlight);
        model.addAttribute("options", AppConstants.CITY_LIST);
        model.addAttribute("flights", flights);
        return "display-flight";
    }

    @GetMapping("/exchange-price/{ticketPrice}/{currency}")
    public String exchangePrice(Model model,@PathVariable("ticketPrice") String ticketPrice,@PathVariable("currency") String currency) {
        double exchangePrice = flightService.getExchangeCurrency(ticketPrice,currency);
        model.addAttribute("ticketPrice",ticketPrice);
        model.addAttribute("exchangePrice",exchangePrice);
        model.addAttribute("currency", currency);
        return "exchangePrice";
    }

    }
