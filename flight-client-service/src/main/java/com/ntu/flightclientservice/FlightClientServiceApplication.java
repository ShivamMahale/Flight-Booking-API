package com.ntu.flightclientservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication(scanBasePackages = "com.ntu.flightclientservice")
public class FlightClientServiceApplication extends SpringBootServletInitializer {
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(FlightClientServiceApplication.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(FlightClientServiceApplication.class, args);
    }

}
