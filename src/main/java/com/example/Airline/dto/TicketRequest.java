package com.example.Airline.dto;



public class TicketRequest {
    public String passengerName;
    public String email;
    public long flightId;


    public long getFlightId() {
        return flightId;
    }

    public String getPassengerName() {
        return passengerName;
    }

    public void setPassengerName(String passengerName) {
        this.passengerName = passengerName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setFlightId(long flightId) {
        this.flightId = flightId;
    }
}
