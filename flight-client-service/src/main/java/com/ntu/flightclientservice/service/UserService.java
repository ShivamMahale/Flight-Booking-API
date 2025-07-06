package com.ntu.flightclientservice.service;

import com.ntu.flightclientservice.model.BookingInfo;
import com.ntu.flightclientservice.model.BookingInfoRequest;
import com.ntu.flightclientservice.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;


@Service
public class UserService {
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    @Autowired
    private RestTemplate restTemplate;

    public User registerUser(User userDto) {
        userDto.setPassword(passwordEncoder.encode(userDto.getPassword()));
        ResponseEntity<User> userResponseEntity = restTemplate.postForEntity("http://localhost:5004/flight-service/api/user/register", userDto, User.class);
        if (userResponseEntity.getStatusCode().is2xxSuccessful()) {
            return userResponseEntity.getBody();
        }
        return new User();
    }

    public boolean userExist(String mailId) {
        ResponseEntity<User> userResponseEntity = restTemplate.getForEntity("http://localhost:5004/flight-service/api/user/" + mailId, User.class);
        if (userResponseEntity.getStatusCode().is2xxSuccessful()) {
            User user = userResponseEntity.getBody();
            return user.getName() != null;
        }
        return false;
    }

    public User getUserByUserName(String mailId) {
        ResponseEntity<User> userResponseEntity = restTemplate.getForEntity("http://localhost:5004/flight-service/api/user/" + mailId, User.class);
        if (userResponseEntity.getStatusCode().is2xxSuccessful()) {
            return userResponseEntity.getBody();
        }
        return new User();
    }

    public List<Long> bookSeats(BookingInfoRequest bookingInfo) {
        ResponseEntity<Object> response = restTemplate.postForEntity("http://localhost:5004/flight-service/api/user//flight/booking", bookingInfo, Object.class);
        if (response.getStatusCode().is2xxSuccessful()) {
            List<Long> bookingIds = (List<Long>) response.getBody();
            return bookingIds;
        }
        return List.of();
    }

    public List<BookingInfo> getBookingInfo(String email) {
        ResponseEntity<Object> response = restTemplate.getForEntity("http://localhost:5004/flight-service/api/user/profile/" + email, Object.class);
        if (response.getStatusCode().is2xxSuccessful()) {
            List<BookingInfo> bookingInfoList = (List<BookingInfo>) response.getBody();
            return bookingInfoList;
        }
        return List.of(new BookingInfo());
    }
}