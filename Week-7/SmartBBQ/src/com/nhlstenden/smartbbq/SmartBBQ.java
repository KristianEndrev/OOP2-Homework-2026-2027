package com.nhlstenden.smartbbq;

import com.nhlstenden.smartbbq.food.Food;

import java.util.HashSet;
import java.util.Timer;
import java.util.TimerTask;

public class SmartBBQ
{
    private static final int MAX_TEMPERATURE_IN_CELSIUS = 250;
    private static final int MAX_FOOD_ITEMS_TO_BE_PLACED = 6;
    private HashSet<Food> food;
    private int temperature;
    public Timer timer;
    public TimerTask timerTask;

    public SmartBBQ()
    {
        this.setFood(new HashSet<>());
        this.setTemperature(0);
    }

    public HashSet<Food> getFood()
    {
        return new HashSet<>(this.food);
    }

    public void setFood(HashSet<Food> food)
    {
        if (food == null)
        {
            throw new IllegalArgumentException("Food cannot be empty");
        }
        for (Food foodItem : food)
        {
            if (foodItem == null)
            {
                throw new IllegalArgumentException("A food item cannot be null");
            }
        }
        if (food.size() > MAX_FOOD_ITEMS_TO_BE_PLACED)
        {
            throw new IllegalArgumentException("Cannot place more than 6 items on the BBQ");
        }

        this.food = food;
    }

    public int getTemperature()
    {
        return this.temperature;
    }

    public void setTemperature(int temperature)
    {
        if (temperature < 0 || temperature > MAX_TEMPERATURE_IN_CELSIUS)
        {
            throw new IllegalArgumentException("Temperature cannot be negative or greater than 250 degrees Celsius");
        }

        this.temperature = temperature;
    }

    public void addFood(Food food)
    {
        if (food == null)
        {
            throw new IllegalArgumentException("Food cannot be null");
        }

        this.food.add(food);
    }

    public void turnOn(int temperature)
    {
        setTemperature(temperature);
        timer = new Timer();
        timerTask = new TimerTask()
        {
            @Override
            public void run()
            {
                for (Food foodItem : food)
                {
                    foodItem.grill(temperature);
                }
            }
        };

        timer.schedule(timerTask, 100);
    }

    public void turnOff()
    {
        timer.cancel();
        setTemperature(0);
    }
}
