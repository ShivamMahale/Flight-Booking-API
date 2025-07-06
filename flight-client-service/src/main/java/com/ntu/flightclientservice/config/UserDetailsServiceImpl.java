package com.ntu.flightclientservice.config;

import com.ntu.flightclientservice.model.User;
import com.ntu.flightclientservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User userByUserName = userService.getUserByUserName(username);
        if (userByUserName == null) {
            System.out.println("User not found with the mail id : " + username);
        }
        UserDetailsImpl userDetails = new UserDetailsImpl(userByUserName);
        return userDetails;
    }
}