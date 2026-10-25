package com.nhlstenden.smartbbq.meat;

public class Hamburger extends Meat
{
    public Hamburger(double browningFactor, MeatType meatType, double cookingFactor)
    {
        super(browningFactor, meatType, cookingFactor);
    }

    @Override
    public void grill(double temperature)
    {
        double newCookedPercentage = getCurrentCookedPercentage() + (1/(100*Math.PI)) * temperature;
        setCurrentCookedPercentage(newCookedPercentage);
        double newTemperature = getCurrentTemperature() + 0.5;
        setCurrentTemperature(newTemperature);
        double newBrowningFactor = getBrowningFactor() + 0.06 * (temperature / 100);
        setBrowningFactor(newBrowningFactor);
    }
}
