package com.ntu.flightcoreservice.controller;


import com.ntu.flightcoreservice.entity.Flight;
import com.ntu.flightcoreservice.model.SearchFlightRequest;
import com.ntu.flightcoreservice.service.FlightService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/flights")
public class FlightController {
    private static final Logger LOGGER = LoggerFactory.getLogger(FlightController.class);

    private FlightService flightService;

    public FlightController(FlightService flightService) {
        this.flightService = flightService;
    }

    @GetMapping
    public ResponseEntity<List<Flight>> getAllFlights() {
        LOGGER.info("Request received in controller for getting all flights");
        List<Flight> flights = flightService.getAllFlights();
        return ResponseEntity.ok(flights);
    }

    @PostMapping("/search")
    public ResponseEntity<List<Flight>> searchFlights(@RequestBody SearchFlightRequest searchFlight) {
        System.out.println(searchFlight);
        LOGGER.info("Request received in controller for searching flights");
        List<Flight> flights = flightService.searchFlights(searchFlight);
        return ResponseEntity.ok(flights);
    }

    @GetMapping("/{flightId}")
    public ResponseEntity<Flight> getFlightDetailsById(@PathVariable Long flightId) {
        LOGGER.info("Request received in controller for getting flights by id");
        Flight flight = flightService.getFlightById(flightId);
        return ResponseEntity.ok(flight);
    }


// @PutMapping("/reduce/seats/{flightId}/{totalSeat}")
// public ResponseEntity<Long> reduceFlightSeats(@PathVariable Long flightId, @PathVariable Integer totalSeat) {
// LOGGER.info("Request received in controller for reduce seat of flights");
// Flight updatedFlight = flightService.reduceFlightSeats(flightId, totalSeat);
// return ResponseEntity.ok(updatedFlight.getId());
// }
}