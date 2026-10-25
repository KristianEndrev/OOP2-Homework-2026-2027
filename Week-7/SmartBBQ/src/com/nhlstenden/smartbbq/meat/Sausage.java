package com.nhlstenden.smartbbq.meat;

public class Sausage extends Meat
{
    public Sausage(double browningFactor, MeatType meatType, double cookingFactor)
    {
        super(browningFactor, meatType, cookingFactor);
    }

    @Override
    public void grill(double temperature)
    {
        double newCookedPercentage = getCurrentCookedPercentage() + (1/(80*Math.PI)) * temperature;
        setCurrentCookedPercentage(newCookedPercentage);
        double newTemperature = getCurrentTemperature() + 0.5;
        setCurrentTemperature(newTemperature);
        double newBrowningFactor = getBrowningFactor() + 0.05 * (temperature / 100);
        setBrowningFactor(newBrowningFactor);
    }
}
