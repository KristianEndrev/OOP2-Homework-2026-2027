package com.nhlstenden.smartbbq.temperature;

import com.nhlstenden.smartbbq.food.Food;
import com.nhlstenden.smartbbq.fridge.Fridge;
import com.nhlstenden.smartbbq.SmartBBQ;

public class Thermometer
{
    private static final int MIN_DEGREES_FOR_MEDIUM_TEMP = 10;
    private static final int MAX_DEGREES_FOR_MEDIUM_TEMP = 70;

    public static String getTemperature(Object object)
    {
        if (object instanceof Food)
        {
            return "I measured a temperature of " + ((Food) object).getCurrentTemperature() + " degrees Celsius" + " The temperature is " + classifyTemperature(((Food) object).getCurrentTemperature());
        }
        if (object instanceof Fridge)
        {
            return "I measured a temperature of " + ((Fridge) object).getTemperature() + " degrees Celsius" + " The temperature is " + classifyTemperature(((Fridge) object).getTemperature());
        }
        if (object instanceof SmartBBQ)
        {
            return "I measured a temperature of " + ((SmartBBQ) object).getTemperature() + " degrees Celsius" + " The temperature is " + classifyTemperature(((SmartBBQ) object).getTemperature());
        }

        throw new IllegalArgumentException("Provided object is invalid");
    }

    public static String classifyTemperature(double temperature)
    {
        if (temperature < MIN_DEGREES_FOR_MEDIUM_TEMP)
        {
            return TemperatureType.COLD.toString();
        }
        if (temperature >= MIN_DEGREES_FOR_MEDIUM_TEMP && temperature <= MAX_DEGREES_FOR_MEDIUM_TEMP)
        {
            return TemperatureType.MEDIUM.toString();
        }
        if (temperature > MAX_DEGREES_FOR_MEDIUM_TEMP)
        {
            return TemperatureType.HOT.toString();
        }

        throw new IllegalArgumentException("Provided temperature is invalid");
    }
}
