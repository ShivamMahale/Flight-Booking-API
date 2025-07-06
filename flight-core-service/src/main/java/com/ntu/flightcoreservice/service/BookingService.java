package com.ntu.flightcoreservice.service;


import com.ntu.flightcoreservice.entity.BookingInfo;
import com.ntu.flightcoreservice.entity.Flight;
import com.ntu.flightcoreservice.entity.User;
import com.ntu.flightcoreservice.exception.CustomException;
import com.ntu.flightcoreservice.model.BookingInfoRequest;
import com.ntu.flightcoreservice.model.Passenger;
import com.ntu.flightcoreservice.repository.BookingInfoRepository;
import com.ntu.flightcoreservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookingService {

    FlightService flightService;
    @Autowired
    BookingInfoRepository bookingInfoRepository;
    @Autowired
    UserRepository userRepository;

    public BookingService(FlightService flightService) {
        this.flightService = flightService;
    }

    public List<Long> bookSeats(BookingInfoRequest bookingInfoRequest) {
        Long flightId = bookingInfoRequest.getFlightId();
        Flight flightById = flightService.getFlightById(flightId);
        String userId = bookingInfoRequest.getUserId();
        Optional<User> maybeUser = userRepository.findById(userId);
        if (maybeUser.isEmpty()) {
            throw new CustomException(401, "User not found");
        }
        User user = maybeUser.get();
        List<BookingInfo> bookingInfoList = new ArrayList<>();
        List<Passenger> passengerList = bookingInfoRequest.getPassenger();
        for (Passenger passenger : passengerList) {
            BookingInfo bookingInfo = new BookingInfo();
            bookingInfo.setAge(passenger.getAge());
            bookingInfo.setBookingDate(LocalDate.now());
            bookingInfo.setCountry(passenger.getCountry());
            bookingInfo.setAirline(flightById.getAirline());
            bookingInfo.setGender(passenger.getGender());
            bookingInfo.setPassengerName(passenger.getPassengerName());
            bookingInfo.setPassengerPhone(passenger.getPassengerPhone());
            bookingInfo.setDateOfDeparture(flightById.getDateOfDeparture());
            bookingInfo.setDestinationCity(flightById.getDestinationCity());
            bookingInfo.setOriginCity(flightById.getOriginCity());
            bookingInfo.setFlightNumber(flightById.getFlightNumber());
            bookingInfo.setTicketPrice(flightById.getTicketPrice());
            bookingInfo.setUserId(userId);

            bookingInfoList.add(bookingInfo);
        }
        List<BookingInfo> bookingInfos = bookingInfoRepository.saveAll(bookingInfoList);
        List<Long> bookingIds = bookingInfos.stream().map(bookingInfo -> bookingInfo.getBookingId()).toList();
        return bookingIds;


    }

    public List<BookingInfo> getAllBookingInfo(String mailId) {
        Optional<List<BookingInfo>> bookingInfoList = bookingInfoRepository.getAllBookingHistoryByUserId(mailId);
        if (bookingInfoList.isPresent()) {
            List<BookingInfo> bookingInfos = bookingInfoList.get();
            return bookingInfos;
        }
        return List.of(new BookingInfo());
    }
}