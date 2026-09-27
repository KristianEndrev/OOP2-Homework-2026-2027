package com.nhlstenden.flightbooking.airplane;

import com.nhlstenden.flightbooking.flight.Flight;

public class PrivateAirplane extends Airplane
{

    public PrivateAirplane(String code, double currentFuelLevelInLitres, int totalNumOfSeats)
    {
        super(code, currentFuelLevelInLitres, totalNumOfSeats);
    }

    @Override
    public double getFuelConsumptionInLitresForFLight(Flight flight)
    {
        return getTotalNumOfSeats() * 1.31 * flight.getDistanceInKm() + getTotalSeatsTaken() * 1.87 + geTotalLuggageWeightInKg() * 0.4;
    }
}
