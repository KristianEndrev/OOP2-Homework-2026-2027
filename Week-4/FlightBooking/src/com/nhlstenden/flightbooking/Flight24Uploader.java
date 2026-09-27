package com.nhlstenden.flightbooking;

import com.nhlstenden.flightbooking.flight.*;

public class Flight24Uploader
{
    private Flight flight;
    private String flightInfo;
    private String airplaneInfo;

    public Flight24Uploader(Flight flight)
    {
        this.setFlight(flight);
        this.setFlightInfo(buildStringFlightInfo());
        this.setAirplaneInfo("");
    }

    public String buildStringFlightInfo()
    {
        StringBuilder s = new StringBuilder();

        s.append(flight.getDepartureAirport().getCode());
        s.append(" -> ");
        s.append(flight.getArrivalAirport().getCode());
        s.append(". Departure ");
        s.append(flight.getDepartureDateTime());

        return s.toString();
    }

    public String buildStringAirplaneInfo()
    {
        StringBuilder s = new StringBuilder();

        s.append(flight.getAirplane().getCode());
        s.append(". ");
        s.append(flight.getAirplane().getCurrentFuelLevelInLitres());
        s.append(" litre/s fuel. ");
        s.append(flight.getAirplane().getEmptySeats());
        s.append(" empty seats.");

        return s.toString();
    }

    public Flight getFlight()
    {
        return this.flight;
    }

    public void setFlight(Flight flight)
    {
        if (flight == null)
        {
            throw new IllegalArgumentException("Flight cannot be null");
        }

        this.flight = flight;
    }

    public String getFlightInfo()
    {
        return this.flightInfo;
    }

    public void setFlightInfo(String flightInfo)
    {
        if (flightInfo == null)
        {
            throw new IllegalArgumentException("flightInfo cannot be null");
        }

        this.flightInfo = flightInfo;
    }

    public String getAirplaneInfo()
    {
        return this.airplaneInfo;
    }

    public void setAirplaneInfo(String airplaneInfo)
    {
        if (airplaneInfo == null)
        {
            throw new IllegalArgumentException("airplaneInfo cannot be null or blank");
        }

        this.airplaneInfo = airplaneInfo;
    }

    public void upload()
    {
    }
}
