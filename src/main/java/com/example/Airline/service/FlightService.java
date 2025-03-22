package com.example.Airline.service;

import com.example.Airline.entity.Flight;
import com.example.Airline.repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FlightService {

    @Autowired
    private FlightRepository flightRepository;


    public List<Flight> getFlightSchedule(String source, String destination) {
        return flightRepository.findBySourceAndDestination(source, destination);
    }
}
