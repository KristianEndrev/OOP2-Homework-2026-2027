package com.nhlstenden.flightbooking.ticket;
import com.nhlstenden.flightbooking.*;
import com.nhlstenden.flightbooking.flight.*;
import com.nhlstenden.flightbooking.luggage.*;

import java.util.ArrayList;
import java.util.List;


public class Ticket
{
    private static final int CARRY_ON_LIMIT = 1;
    private Airport departureAirport;
    private Airport arrivalAirport;
    private Person person;
    private List<Luggage> luggageList;

    public Ticket(Airport departureAirport, Airport arrivalAirport, Person person, List<Luggage> luggageList)
    {
        this.setDepartureAirport(departureAirport);
        this.setArrivalAirport(arrivalAirport);
        this.setPerson(person);
        this.setLuggageList(luggageList);
    }

    public Airport getDepartureAirport()
    {
        return this.departureAirport;
    }

    public void setDepartureAirport(Airport departureAirport)
    {
        if (departureAirport == null)
        {
            throw new IllegalArgumentException("Departure airport cannot be null");
        }

        this.departureAirport = departureAirport;
    }

    public Airport getArrivalAirport()
    {
        return this.arrivalAirport;
    }

    public void setArrivalAirport(Airport arrivalAirport)
    {
        if (arrivalAirport == null)
        {
            throw new IllegalArgumentException("Arrival airport cannot be null");
        }

        this.arrivalAirport = arrivalAirport;
    }

    public Person getPerson()
    {
        return this.person;
    }

    public void setPerson(Person person)
    {
        if (person == null)
        {
            throw new IllegalArgumentException("Person cannot be null");
        }

        this.person = person;
    }

    public List<Luggage> getLuggageList()
    {
        return new ArrayList<>(this.luggageList);
    }

    public void setLuggageList(List<Luggage> luggageList)
    {
        if (luggageList == null || luggageList.isEmpty())
        {
            throw new IllegalArgumentException("luggageList cannot be null");
        }

        for (Luggage luggage : luggageList)
        {
            if (luggage == null)
            {
                throw new IllegalArgumentException("Luggage cannot be null");
            }
        }

        this.luggageList = new ArrayList<>(luggageList);
    }

    public Flight getNonDepartedFlight()
    {
        for (Flight flight : departureAirport.getFlights())
        {
            if (flight.getStatus() == Status.AWAITING_DEPARTURE)
            {
                return flight;
            }
        }

        throw new IllegalArgumentException("There are no available flights from this airport");
    }

    public boolean hasAirplaneSpace(Flight flight)
    {
        return flight.getAirplane().getEmptySeats() > 0;
    }
}
