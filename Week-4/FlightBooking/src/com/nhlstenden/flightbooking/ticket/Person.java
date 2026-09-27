package com.nhlstenden.flightbooking.ticket;

import com.nhlstenden.flightbooking.flight.Flight;

public class Person
{
    private String name;

    public Person(String name)
    {
        this.setName(name);
    }

    public String getName()
    {
        return this.name;
    }

    public void setName(String name)
    {
        if (name == null || name.isBlank())
        {
            throw new IllegalArgumentException("name cannot be null or blank");
        }

        this.name = name;
    }

    public void bookTicket(Ticket ticket)
    {
        if (ticket == null)
        {
            throw new IllegalArgumentException("Ticket cannot be null");
        }
        Flight theFlight = ticket.getNonDepartedFlight();
        if (!ticket.hasAirplaneSpace(theFlight))
        {
            throw new IllegalArgumentException("Airplane has no available seats");
        }

        int seats = theFlight.getAirplane().getTotalSeatsTaken();
        theFlight.getAirplane().setTotalSeatsTaken(seats+1);
    }
}
