package com.nhlstenden.flightbooking;

import com.nhlstenden.flightbooking.airplane.*;
import com.nhlstenden.flightbooking.flight.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDateTime;

public class FlightTest
{
    private Flight flight;
    private Airport a1;
    private Airport a2;
    private CommercialAirplane c1;


    @BeforeEach
    void setUp()
    {
        a1 = new Airport("LAX");
        a2 = new Airport("AMS");
        c1 = new CommercialAirplane("123", 10, 100, 50, 50);
        flight = new Flight(a1, a2, LocalDateTime.now(), c1);
        flight.setDistanceInKm(8956);
    }

    @Test
    void hasSufficientFuel_properValues_expectNotToThrow()
    {
        assertTrue(flight.hasSufficientFuel(c1));
    }
}
