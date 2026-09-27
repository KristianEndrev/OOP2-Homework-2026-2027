package com.nhlstenden.flightbooking.airplane;

import com.nhlstenden.flightbooking.flight.Flight;
import com.nhlstenden.flightbooking.luggage.*;

import java.util.ArrayList;
import java.util.List;

public abstract class Airplane
{
    private String code;
    private double currentFuelLevelInLitres;
    private int totalNumOfSeats;
    private int totalSeatsTaken;
    private List<Luggage> luggageList;

    public Airplane(String code, double currentFuelLevelInLitres, int totalNumOfSeats)
    {
        this.setCode(code);
        this.setCurrentFuelLevelInLitres(currentFuelLevelInLitres);
        this.setTotalNumOfSeats(totalNumOfSeats);
        this.setTotalSeatsTaken(0);
        setLuggageList(new ArrayList<>());
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

    public double getCurrentFuelLevelInLitres()
    {
        return this.currentFuelLevelInLitres;
    }

    public void setCurrentFuelLevelInLitres(double currentFuelLevelInLitres)
    {
        if (currentFuelLevelInLitres < 0)
        {
            throw new IllegalArgumentException("Current fuel level in litres cannot be negative");
        }

        this.currentFuelLevelInLitres = currentFuelLevelInLitres;
    }

    public int getTotalNumOfSeats()
    {
        return this.totalNumOfSeats;
    }

    public void setTotalNumOfSeats(int totalNumOfSeats)
    {
        if (totalNumOfSeats < 0)
        {
            throw new IllegalArgumentException("Total number of seats cannot be 0");
        }

        this.totalNumOfSeats = totalNumOfSeats;
    }

    public int getTotalSeatsTaken()
    {
        return this.totalSeatsTaken;
    }

    public void setTotalSeatsTaken(int totalSeatsTaken)
    {
        if (totalSeatsTaken < 0 || totalSeatsTaken > totalNumOfSeats)
        {
            throw new IllegalArgumentException("Total seats taken cannot be negative or more than the total number of seats");
        }

        this.totalSeatsTaken = totalSeatsTaken;
    }

    public int getEmptySeats()
    {
        return getTotalNumOfSeats() - getTotalSeatsTaken();
    }

    public List<Luggage> getLuggageList()
    {
        return new ArrayList<>(this.luggageList);
    }

    public void setLuggageList(List<Luggage> luggageList)
    {
        if (luggageList == null)
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

    public double geTotalLuggageWeightInKg()
    {
        double total = 0;
        for (Luggage luggage : luggageList)
        {
            total += luggage.getWeightInKg();
        }

        return total;
    }

    public abstract double getFuelConsumptionInLitresForFLight(Flight flight);
}
