package com.nhlstenden.smartbbq.food;

public abstract class Food
{
    private double currentBrownPercentage;
    private double browningFactor;
    private double currentTemperature;

    public Food(double browningFactor)
    {
        this.setCurrentBrownPercentage(0);
        this.setBrowningFactor(browningFactor);
        this.setCurrentTemperature(0);
    }

    public double getCurrentBrownPercentage()
    {
        return this.currentBrownPercentage;
    }

    public void setCurrentBrownPercentage(double currentBrownPercentage)
    {
        if (currentBrownPercentage < 0)
        {
            throw new IllegalArgumentException("Current brown percentage cannot be negative");
        }

        this.currentBrownPercentage = currentBrownPercentage;
    }

    public double getBrowningFactor()
    {
        return this.browningFactor;
    }

    public void setBrowningFactor(double browningFactor)
    {
        if (browningFactor < 0)
        {
            throw new IllegalArgumentException("Browning factor cannot be negative");
        }

        this.browningFactor = browningFactor;
    }

    public double getCurrentTemperature()
    {
        return this.currentTemperature;
    }

    public void setCurrentTemperature(double currentTemperature)
    {
        if (currentTemperature < 0)
        {
            throw new IllegalArgumentException("Current temperature cannot be negative");
        }

        this.currentTemperature = currentTemperature;
    }

    private String getName()
    {
        return this.toString();
    }

    public abstract void grill(double temperature);
}
