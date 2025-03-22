package com.example.Airline.service;

import com.example.Airline.dto.TicketRequest;
import com.example.Airline.entity.Flight;
import com.example.Airline.entity.Ticket;
import com.example.Airline.exceptions.ResourceNotFoundException;
import com.example.Airline.repository.FlightRepository;
import com.example.Airline.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TicketService {


    @Autowired
    private  TicketRepository ticketRepository;

    @Autowired
    private  FlightRepository flightRepository;


    public Ticket getTicketDetails(Long ticketId) {
        return ticketRepository.findByIdAndIsCancelledFalse(ticketId)
                .orElseThrow(() -> new ResourceNotFoundException("Ticket not found or already cancelled"));
    }

    @Transactional
    public Ticket bookTicket(TicketRequest request) {
        Flight flight = flightRepository.findById(request.getFlightId())
                .orElseThrow(() -> new ResourceNotFoundException("Flight not found"));


        Ticket ticket = new Ticket();

        return ticketRepository.save(ticket);
    }

    @Transactional
    public void cancelTicket(Long ticketId) {
        Ticket ticket = ticketRepository.findById(ticketId)
                .orElseThrow(() -> new ResourceNotFoundException("Ticket not found"));

        ticket.isCancelled(true);
        ticketRepository.save(ticket);
    }
}
