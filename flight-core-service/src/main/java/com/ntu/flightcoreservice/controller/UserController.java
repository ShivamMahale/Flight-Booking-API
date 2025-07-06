package com.ntu.flightcoreservice.controller;


import com.ntu.flightcoreservice.entity.BookingInfo;
import com.ntu.flightcoreservice.entity.User;
import com.ntu.flightcoreservice.model.BookingInfoRequest;
import com.ntu.flightcoreservice.repository.UserRepository;
import com.ntu.flightcoreservice.service.BookingService;
import com.ntu.flightcoreservice.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    BookingService bookingService;

    FlightService flightService;
    @Autowired
    private UserRepository userRepository;

    public UserController(FlightService flightService) {
        this.flightService = flightService;
    }

    @PostMapping("/register")
    public ResponseEntity<User> registerUser(@RequestBody User userDto) {
        userDto.setRole("ROLE_USER");
        User savedUser = userRepository.save(userDto);
        return ResponseEntity.ok(savedUser);
    }

    @GetMapping("/{mailId}")
    public ResponseEntity<User> getUserById(@PathVariable String mailId) {
        Optional<User> maybeUser = userRepository.findById(mailId);
        if (maybeUser.isPresent()) {
            return ResponseEntity.ok(maybeUser.get());
        }
        return ResponseEntity.ok(new User());
    }

    @GetMapping("/profile/{mailId}")
    public ResponseEntity<List<BookingInfo>> getUserBookingInfo(@PathVariable String mailId) {
        List<BookingInfo> bookingInfoList = bookingService.getAllBookingInfo(mailId);
        return ResponseEntity.ok(bookingInfoList);
    }

    @PostMapping("/flight/booking")
    public ResponseEntity<List<Long>> bookSeat(@RequestBody BookingInfoRequest bookingInfoRequest) {
        List<Long> bookingIds = bookingService.bookSeats(bookingInfoRequest);
        flightService.reduceFlightSeats(bookingInfoRequest.getFlightId(), bookingIds.size());
        return ResponseEntity.ok(bookingIds);
    }
}