package com.nhlstenden.smartbbq.vegetable;

public class Corn extends Vegetable
{
    public Corn(double browningFactor, double moistFactor)
    {
        super(browningFactor, moistFactor);
    }

    @Override
    public void grill(double temperature)
    {
        double newBrowningFactor = getBrowningFactor() + 0.08 * temperature;
        setBrowningFactor(newBrowningFactor);
        double moistDecreaseDifference = 0.05 * temperature;
        decreaseMoistPercentage(moistDecreaseDifference);
        double newTemperature = getCurrentTemperature() + 0.5;
        setCurrentTemperature(newTemperature);
    }
}
