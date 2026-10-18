package com.nhlstenden.vegetablegarden;
import com.nhlstenden.vegetablegarden.vegetable.*;

import java.util.HashSet;
import java.util.concurrent.ThreadLocalRandom;

public class WeatherGenerator
{
    private static final int MINIMUM_NUMBER_FOR_RANDOM_LUX = 1000;
    private static final int MAXIMUM_NUMBER_FOR_RANDOM_LUX = 101592;
    private static final int MINIMUM_NUMBER_FOR_RANDOM_MM = 0;
    private static final int MAXIMUM_NUMBER_FOR_RANDOM_MM = 48;
    private static final int DAYS_FOR_WHICH_RUN_WEATHER_WORKS = 1;

    static int getRandomLux()
    {
        return ThreadLocalRandom.current().nextInt(MINIMUM_NUMBER_FOR_RANDOM_LUX, MAXIMUM_NUMBER_FOR_RANDOM_LUX);
    }

    static int getRandomMm()
    {
        return ThreadLocalRandom.current().nextInt(MINIMUM_NUMBER_FOR_RANDOM_MM, MAXIMUM_NUMBER_FOR_RANDOM_MM);
    }

    static void runWeather(HashSet<Vegetable> vegetables)
    {
        if (vegetables == null || vegetables.isEmpty())
        {
            throw new IllegalArgumentException("Vegetables cannot be null or empty");
        }
        for (Vegetable vegetable  : vegetables)
        {
            vegetable.grow(getRandomLux(), getRandomMm(), DAYS_FOR_WHICH_RUN_WEATHER_WORKS);
        }
    }
}
