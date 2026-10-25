package com.nhlstenden.smartbbq.vegetable;

public class BellPepper extends Vegetable
{
    public BellPepper(double browningFactor, double moistFactor)
    {
        super(browningFactor, moistFactor);
    }

    @Override
    public void grill(double temperature)
    {
        double newBrowningFactor = getBrowningFactor() + 0.03 * temperature;
        setBrowningFactor(newBrowningFactor);
        double moistDecreaseDifference = 0.1 * temperature;
        decreaseMoistPercentage(moistDecreaseDifference);
        double newTemperature = getCurrentTemperature() + 0.5;
        setCurrentTemperature(newTemperature);
    }
}
