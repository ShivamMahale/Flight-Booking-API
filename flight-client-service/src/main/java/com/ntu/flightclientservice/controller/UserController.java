package com.ntu.flightclientservice.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.ntu.flightclientservice.model.*;
import com.ntu.flightclientservice.service.FlightService;
import com.ntu.flightclientservice.service.UserService;
import com.ntu.flightclientservice.util.AppConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.text.ParseException;
import java.util.List;

@Controller
@RequestMapping("/flight-service")
public class UserController {
    @Autowired
    FlightService flightService;
    @Autowired
    private UserService userService;

    @GetMapping("/user/index")
    public String indexUser(Model model, Principal principal) {
        String email = principal.getName();
        model.addAttribute("userName", email);
        return "user/user-home";
    }

    @GetMapping("/user/register")
    public String registerUser(Model model) {
        model.addAttribute("userDto", new User());
        return "user-registration";
    }

    @PostMapping("/user/register")
    public String addUser(@ModelAttribute("userDto") User user, Model model) {
        System.out.println(user.getName());
        String mailId = user.getEmail();
        User savedUser;
        boolean isExist = userService.userExist(mailId);
        if (isExist) {
            model.addAttribute("error", "User with mailId : " + mailId + " is already exist");
            return "error";
        } else {
            savedUser = userService.registerUser(user);
        }
        if (savedUser.getEmail() == null) {
            model.addAttribute("error", "Something went wrong !! ");
            return "error";
        }
        model.addAttribute("userDto", new User());
        model.addAttribute("responseMsg", "Successfully Registered!! <br> Your user name is : " + mailId);
        return "success";
    }

    @GetMapping("/user/login")
    public String loginUser(Model model) {
        return "user-login";
    }

    @GetMapping("/user/search")
    public String searchFlight(Model model, Principal principal) {
        String email = principal.getName();
        model.addAttribute("userName", email);
        model.addAttribute("searchFlight", new SearchFlight());
        model.addAttribute("options", AppConstants.CITY_LIST);
        return "user/user-search-flight";
    }

    @PostMapping("/user/search")
    public String findFlight(@ModelAttribute("searchFlight") SearchFlight searchFlight, Model model, Principal principal) throws ParseException, JsonProcessingException {
        List<Flight> flights = flightService.searchFlights(searchFlight);
        model.addAttribute("flights", flights);
        String email = principal.getName();
        model.addAttribute("userName", email);
        model.addAttribute("options", AppConstants.CITY_LIST);
        return "user/user-display-flight";
    }

    @GetMapping("/user/reservation/{flightId}/{flightNumber}")
    public String getFlightBooking(Model model, @PathVariable("flightNumber") String flightNumber, @PathVariable("flightId") String flightId, Principal principal) {
        String email = principal.getName();
        model.addAttribute("userName", email);
        model.addAttribute("flightNumber", flightNumber);
        model.addAttribute("flightId", flightId);
        model.addAttribute("bookingInfoClientRequest", new BookingInfoClientRequest());
        return "user/user-book-flight";
    }

    @PostMapping("/user/reservation/seat")
    public String bookFlight(Model model, @ModelAttribute("bookingInfoClientRequest") BookingInfoClientRequest bookingInfoClientRequest, Principal principal) {
        String email = principal.getName();
        BookingInfoRequest bookingInfoRequest = new BookingInfoRequest();
        Passenger passenger = new Passenger();
        passenger.setAge(Double.valueOf(bookingInfoClientRequest.getAge()));
        passenger.setPassengerName(bookingInfoClientRequest.getPassengerName());
        passenger.setPassengerPhone(bookingInfoClientRequest.getPassengerPhone());
        passenger.setCountry(bookingInfoClientRequest.getCountry());
        passenger.setGender(bookingInfoClientRequest.getGender());

        bookingInfoRequest.setUserId(email);
        bookingInfoRequest.setFlightId(Long.valueOf(bookingInfoClientRequest.getFlightId()));
        bookingInfoRequest.setPassenger(List.of(passenger));
        List<Long> bookingIds = userService.bookSeats(bookingInfoRequest);
        model.addAttribute("userName", email);
        model.addAttribute("bookingId", bookingIds.get(0));
        return "user/user-book-flight-success";
    }

    @GetMapping("/user/profile")
    public String userProfile(Model model, Principal principal) {
        String email = principal.getName();
        List<BookingInfo> bookings = userService.getBookingInfo(email);
        model.addAttribute("userName", email);
        model.addAttribute("bookings", bookings);
        return "user/user-profile";
    }
}