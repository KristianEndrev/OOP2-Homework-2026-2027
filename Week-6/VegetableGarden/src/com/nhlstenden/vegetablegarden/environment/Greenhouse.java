package com.nhlstenden.vegetablegarden.environment;

import com.nhlstenden.vegetablegarden.Market;
import com.nhlstenden.vegetablegarden.vegetable.Status;
import com.nhlstenden.vegetablegarden.WeatherGenerator;
import com.nhlstenden.vegetablegarden.vegetable.*;

import java.util.HashSet;

public class Greenhouse
{
    private HashSet<Vegetable> vegetables;
    private Market market;
    private WeatherGenerator weatherGenerator;

    public Greenhouse(HashSet<Vegetable> vegetables, WeatherGenerator weatherGenerator)
    {
        this.setWeatherGenerator(weatherGenerator);
        this.setVegetables(vegetables);
    }

    public HashSet<Vegetable> getVegetables()
    {
        return new HashSet<>(this.vegetables);
    }

    public void setVegetables(HashSet<Vegetable> vegetables)
    {
        if (vegetables == null)
        {
            throw new IllegalArgumentException("Vegetables cannot be null");
        }
        for (Vegetable vegetable : vegetables)
        {
            if (vegetable == null)
            {
                throw new IllegalArgumentException("A vegetable cannot be null");
            }
        }

        this.vegetables = vegetables;
    }

    public HashSet<Vegetable> getReadyHarvest()
    {
        HashSet<Vegetable> readyToHarvestVegetables = new HashSet<>();
        for (Vegetable vegetable : vegetables)
        {
            vegetable.updateStatus();
            if (vegetable.getStatus().equals(Status.READY_TO_HARVEST))
            {
                readyToHarvestVegetables.add(vegetable);
            }
        }

        return readyToHarvestVegetables;
    }

    public Market getMarket()
    {
        return this.market;
    }

    public void setMarket(Market market)
    {
        if (market == null)
        {
            throw new IllegalArgumentException("Market cannot be null");
        }

        this.market = market;
    }

    public WeatherGenerator getWeatherGenerator()
    {
        return this.weatherGenerator;
    }

    public void setWeatherGenerator(WeatherGenerator weatherGenerator)
    {
        if (weatherGenerator == null)
        {
            throw new IllegalArgumentException("Weather generator cannot be null");
        }

        this.weatherGenerator = weatherGenerator;
    }
}
