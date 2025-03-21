package com.example.Airline.controller;

import com.example.Airline.entity.Flight;
import com.example.Airline.service.FlightService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/flights")
public class FlightController {

    @Autowired
    public FlightService flightService;

    @GetMapping
    public List<Flight> getFlightSchedule(@RequestParam String source, @RequestParam String destination) {
        return flightService.getFlightSchedule(source, destination);
    }
}
