package com.example.Airline.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
public class Ticket {
    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Setter
    @Getter
    private String passengerName;
    @Getter
    @Setter
    private String email;

    @Getter
    @Setter
    private Flight flight;

    private boolean isCancelled = false;

    public boolean isCancelled(boolean isc) {
        return isCancelled = isc;
    }

}
