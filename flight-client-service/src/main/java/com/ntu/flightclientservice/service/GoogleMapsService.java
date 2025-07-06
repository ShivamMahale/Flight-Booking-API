package com.ntu.flightclientservice.service;

import com.google.maps.DirectionsApi;
import com.google.maps.DirectionsApiRequest;
import com.google.maps.GeoApiContext;
import com.google.maps.errors.ApiException;
import com.google.maps.model.DirectionsResult;
import com.google.maps.model.EncodedPolyline;
import com.google.maps.model.TravelMode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class GoogleMapsService {
    private final String apiKey;
    private GeoApiContext context;

    @Autowired
    public GoogleMapsService(Environment env) {
        this.apiKey = env.getProperty("google.maps.api-key");
        System.out.println(apiKey);
        this.context = new GeoApiContext.Builder().apiKey(apiKey).build();
    }

    public String getDirections(String origin, String destination) {

        try {
            DirectionsApiRequest request = DirectionsApi.newRequest(context);
            request.origin(origin);
            request.destination(destination);
            request.mode(TravelMode.DRIVING);
            DirectionsResult result = request.await();
            EncodedPolyline polyline = result.routes[0].overviewPolyline;
            return polyline.getEncodedPath();// Return encoded polyline
        } catch (ApiException e) {
            // Handle API exceptions
            throw new RuntimeException("Error fetching directions: " + e.getMessage());
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}