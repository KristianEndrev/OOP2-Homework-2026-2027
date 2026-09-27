package com.nhlstenden.flightbooking.flight;

import com.nhlstenden.flightbooking.*;
import com.nhlstenden.flightbooking.airplane.*;

import java.time.LocalDateTime;

public class Flight
{
    private Airport departureAirport;
    private Airport arrivalAirport;
    private int distanceInKm;
    private LocalDateTime departureDateTime;
    private LocalDateTime arrivalDateTime;
    private Status status;
    private Airplane airplane;

    public Flight(Airport departureAirport, Airport arrivalAirport, LocalDateTime departureDateTime, Airplane airplane)
    {
        this.setDepartureAirport(departureAirport);
        this.setArrivalAirport(arrivalAirport);
        this.distanceInKm = 0;
        this.setDepartureDateTime(departureDateTime);
        this.arrivalDateTime = null;
        this.setStatus(Status.AWAITING_DEPARTURE);
        this.setAirplane(airplane);
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

    public int getDistanceInKm()
    {
        return this.distanceInKm;
    }

    public void setDistanceInKm(int distanceInKm)
    {
        if (distanceInKm <= 0)
        {
            throw new IllegalArgumentException("Distance cannot be 0 or negative");
        }

        this.distanceInKm = distanceInKm;
    }

    public LocalDateTime getDepartureDateTime()
    {
        return this.departureDateTime;
    }

    public void setDepartureDateTime(LocalDateTime departureDateTime)
    {
        if (departureDateTime == null || departureDateTime.isAfter(arrivalDateTime))
        {
            throw new IllegalArgumentException("Departure date time cannot be null or after arrivate date time");
        }

        this.departureDateTime = departureDateTime;
    }

    public LocalDateTime getArrivalDateTime()
    {
        return this.arrivalDateTime;
    }

    public void setArrivalDateTime(LocalDateTime arrivalDateTime)
    {
        if (arrivalDateTime == null || arrivalDateTime.isBefore(departureDateTime))
        {
            throw new IllegalArgumentException("Arrival date time cannot be null or before departure date time");
        }

        this.arrivalDateTime = arrivalDateTime;
    }

    public Status getStatus()
    {
        return this.status;
    }

    public void setStatus(Status status)
    {
        if (status == null)
        {
            throw new IllegalArgumentException("Status cannot be null");
        }

        this.status = status;
    }

    public Airplane getAirplane()
    {
        return this.airplane;
    }

    public void setAirplane(Airplane airplane)
    {
        if (airplane == null)
        {
            throw new IllegalArgumentException("Airplane cannot be null");
        }

        this.airplane = airplane;
    }

    public boolean hasSufficientFuel(Airplane airplane)
    {
        if (airplane == null)
        {
            throw new IllegalArgumentException("Airplane cannot be null");
        }
        if (airplane.getCurrentFuelLevelInLitres() < airplane.getFuelConsumptionInLitresForFLight(this))
        {
            return false;
        }

        return true;
    }

    public void depart()
    {
        setStatus(Status.DEPARTED);
    }
}
