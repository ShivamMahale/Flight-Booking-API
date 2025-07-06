package com.ntu.flightcoreservice.service;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.ntu.flightcoreservice.entity.Flight;
import com.ntu.flightcoreservice.model.SearchFlightRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FlightService {
    private final String FLIGHT_DATA_FILE = "cloud_touch.json";
    private static final Logger LOGGER = LoggerFactory.getLogger(FlightService.class);
    private List<Flight> flightList;

    public FlightService() {
        loadFlightDataFromJsonFile();
    }

    private void loadFlightDataFromJsonFile() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        try {
            // Read flight data from JSON file using classpath
            // ClassLoader classLoader = getClass().getClassLoader();
            //File file = new File(classLoader.getResource(FLIGHT_DATA_FILE).getFile());
           // flightList = objectMapper.readValue(file, new TypeReference<List<Flight>>() {
           // });
            flightList = objectMapper.readValue(new File("src/main/resources/cloud_touch.json"), new TypeReference<List<Flight>>(){});
        } catch (IOException e) {
            e.printStackTrace();
            // Handle file read error
        }
    }
    public List<Flight> searchFlights(SearchFlightRequest searchFlight) {
        LOGGER.info("Request received in service for searching flights");
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate dateOfDeparture = LocalDate.parse(searchFlight.getDate(), dateTimeFormatter);
        String originCity = searchFlight.getFrom();
        String destinationCity = searchFlight.getTo();
        List<Flight> searchedFlights = flightList.stream().filter(flight -> flight.getOriginCity().equalsIgnoreCase(originCity)).filter(flight -> flight.getDestinationCity().equalsIgnoreCase(destinationCity)).filter(flight -> flight.getDateOfDeparture().isEqual(dateOfDeparture)).collect(Collectors.toList());
        return searchedFlights;
    }

    public Flight getFlightById(Long flightId) {
        LOGGER.info("Request received for getting flight details by id ");
        Optional<Flight> optFlightById = flightList.stream().filter(flight -> flight.getId() == flightId).findFirst();
        return optFlightById.orElseGet(Flight::new);
    }

    public void reduceFlightSeats(Long flightId, Integer totalSeat) {
        LOGGER.info("Request received for reducing seat number of a flight id {}", flightId);
        // Reduce available seats
        List<Flight> updatedFlights = new ArrayList<>();
        for (Flight flight : flightList) {
            if (flight.getId() == flightId) {
                flight.setSeats(flight.getSeats() - totalSeat);
            }
            updatedFlights.add(flight);
        }

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        try {
            // Read flight data from JSON file using classpath
            ClassLoader classLoader = getClass().getClassLoader();
            File file = new File(classLoader.getResource(FLIGHT_DATA_FILE).getFile());
            objectMapper.writeValue(file, updatedFlights);
        } catch (IOException e) {
            e.printStackTrace();
            // Handle file read error
        }
    }

    public List<Flight> getAllFlights() {
        return flightList;
    }
}