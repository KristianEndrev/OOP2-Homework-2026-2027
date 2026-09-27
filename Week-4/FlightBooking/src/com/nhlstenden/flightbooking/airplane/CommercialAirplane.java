package com.nhlstenden.flightbooking.airplane;

import com.nhlstenden.flightbooking.flight.Flight;

public class CommercialAirplane extends Airplane
{
    private int economySeats;
    private int businessSeats;
    private int economySeatsTaken;
    private int businessSeatsTaken;

    public CommercialAirplane(String code, double currentFuelLevelInLitres, int totalNumOfSeats, int economySeats, int businessSeats)
    {
        super(code, currentFuelLevelInLitres, totalNumOfSeats);
        this.setEconomySeats(economySeats);
        this.setBusinessSeats(businessSeats);
        this.setEconomySeatsTaken(0);
        this.setBusinessSeatsTaken(0);
    }

    public int getEconomySeats()
    {
        return this.economySeats;
    }

    public void setEconomySeats(int economySeats)
    {
        if (economySeats != (getTotalNumOfSeats() - businessSeats))
        {
            throw new IllegalArgumentException("Economy seats cannot be an invalid number");
        }

        this.economySeats = economySeats;
    }

    public int getBusinessSeats()
    {
        return this.businessSeats;
    }

    public void setBusinessSeats(int businessSeats)
    {
        if (businessSeats != (getTotalNumOfSeats() - economySeats))
        {
            throw new IllegalArgumentException("Business seats cannot be an invalid number");
        }

        this.businessSeats = businessSeats;
    }

    public int getEconomySeatsTaken()
    {
        return this.economySeatsTaken;
    }

    public void setEconomySeatsTaken(int economySeatsTaken)
    {
        if (economySeatsTaken < 0 || economySeatsTaken > economySeats)
        {
            throw new IllegalArgumentException("Economy seats taken cannot be negative or more than the total number of economy seats");
        }

        this.economySeatsTaken = economySeatsTaken;
    }

    public int getBusinessSeatsTaken()
    {
        if (businessSeatsTaken < 0 || businessSeatsTaken > businessSeats)
        {
            throw new IllegalArgumentException("Business seats taken cannot be negative or more than the total number of business seats");
        }

        return this.businessSeatsTaken;
    }

    public void setBusinessSeatsTaken(int businessSeatsTaken)
    {
        this.businessSeatsTaken = businessSeatsTaken;
    }

    @Override
    public double getFuelConsumptionInLitresForFLight(Flight flight)
    {
        return economySeats * 1.75 + businessSeats * 1.98 * flight.getDistanceInKm() + getEconomySeatsTaken() * 2.02 + getBusinessSeatsTaken() * 2.87 + geTotalLuggageWeightInKg() * 0.3;
    }
}
