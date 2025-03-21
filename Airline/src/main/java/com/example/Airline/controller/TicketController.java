package com.example.Airline.controller;

import com.example.Airline.dto.TicketRequest;
import com.example.Airline.entity.Ticket;
import com.example.Airline.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tickets")
public class TicketController {

    @Autowired
    private  TicketService ticketService;

    @GetMapping("/{ticketId}")
    public Ticket getTicketDetails(@PathVariable Long ticketId) {
        return ticketService.getTicketDetails(ticketId);
    }

    @PostMapping("/book")
    public Ticket bookTicket(@RequestBody TicketRequest request) {

        return ticketService.bookTicket(request);
    }

    @DeleteMapping("/{ticketId}/cancel")
    public void cancelTicket(@PathVariable Long ticketId) {
        ticketService.cancelTicket(ticketId);
    }
}
