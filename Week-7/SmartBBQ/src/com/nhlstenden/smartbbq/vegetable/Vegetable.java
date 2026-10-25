package com.nhlstenden.smartbbq.vegetable;

import com.nhlstenden.smartbbq.food.Food;

public abstract class Vegetable extends Food
{
    private static final int MAXIMUM_MOISTURE_IN_PERCENTS = 100;
    private double moistPercentage;
    private double moistFactor;


    public Vegetable(double browningFactor, double moistFactor)
    {
        super(browningFactor);
        this.setMoistPercentage(100);
        this.setMoistFactor(moistFactor);
    }

    public double getMoistPercentage()
    {
        return this.moistPercentage;
    }

    public void setMoistPercentage(double moistPercentage)
    {
        if (moistPercentage < 0 || moistPercentage > MAXIMUM_MOISTURE_IN_PERCENTS)
        {
            throw new IllegalArgumentException("Moist percentage cannot be negative or greater than 100");
        }

        this.moistPercentage = moistPercentage;
    }

    public double getMoistFactor()
    {
        return this.moistFactor;
    }

    public void setMoistFactor(double moistFactor)
    {
        if (moistFactor < 0)
        {
            throw new IllegalArgumentException("Moist factor cannot be negative");
        }

        this.moistFactor = moistFactor;
    }

    public void decreaseMoistPercentage(double difference)
    {
        if (difference < 0 || difference > MAXIMUM_MOISTURE_IN_PERCENTS)
        {
            throw new IllegalArgumentException("Difference cannot be negative or above 100");
        }

        this.moistPercentage -= difference;
    }
}
