package com.ntu.flightclientservice.controller;

import com.ntu.flightclientservice.service.GoogleMapsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MapController {

    @Autowired
    private GoogleMapsService googleMapsService;

    @GetMapping("/map")
    public String showMap(Model model) {
        String origin = "Bhubaneswar"; // Replace with user input or default value
        String destination = "Pune"; // Replace with user input or default value
        String encodedPolyline = googleMapsService.getDirections(origin, destination);
        model.addAttribute("encodedPolyline", encodedPolyline);
        return "map"; // Name of your JSP page
    }
}