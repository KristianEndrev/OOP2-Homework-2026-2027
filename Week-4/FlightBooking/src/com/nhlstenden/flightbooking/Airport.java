package com.nhlstenden.flightbooking;

import com.nhlstenden.flightbooking.flight.*;

import java.util.ArrayList;
import java.util.List;

public class Airport
{
    private String code;
    private List<Flight> flights;

    public Airport(String code)
    {
        this.setCode(code);
        this.setFlights(new ArrayList<>());
    }

    public String getCode()
    {
        return this.code;
    }

    public void setCode(String code)
    {
        if (code == null || code.isBlank())
        {
            throw new IllegalArgumentException("code cannot be null or blank");
        }

        this.code = code;
    }

    public List<Flight> getFlights()
    {
        return new ArrayList<>(this.flights);
    }

    public void setFlights(List<Flight> flights)
    {
        if (flights == null)
        {
            throw new IllegalArgumentException("flights cannot be null");
        }

        for (Flight flight : flights)
        {
            if (flight == null)
            {
                throw new IllegalArgumentException("A flight cannot be null");
            }
        }

        this.flights = new ArrayList<>(flights);
    }
}
