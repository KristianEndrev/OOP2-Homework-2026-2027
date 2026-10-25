package com.nhlstenden.smartbbq.fridge;

import com.nhlstenden.smartbbq.food.Food;
import com.nhlstenden.smartbbq.meat.Meat;
import com.nhlstenden.smartbbq.vegetable.Vegetable;

import java.util.HashSet;

public class Fridge
{
    private static final int DEFAULT_TEMPERATURE = 8;
    private Fridge instance;
    private HashSet<Food> foodInFridge;
    private int temperature;

    public Fridge()
    {
        this.instance = null;
        this.setFoodInFridge(new HashSet<>());
        this.setTemperature(DEFAULT_TEMPERATURE);
    }

    public Fridge getInstance()
    {
        return this.instance;
    }

    public void setInstance(Fridge instance)
    {
        if (instance == null)
        {
            throw new IllegalArgumentException("Instance cannot be null");
        }

        this.instance = instance;
    }

    public HashSet<Food> getFoodInFridge()
    {
        return new HashSet<>(this.foodInFridge);
    }

    public void setFoodInFridge(HashSet<Food> foodInFridge)
    {
        if (foodInFridge == null)
        {
            throw new IllegalArgumentException("Food in fridge cannot be null");
        }
        for (Food foodItem : foodInFridge)
        {
            if (foodItem == null)
            {
                throw new IllegalArgumentException("Food item from the fridge cannot be null");
            }
        }

        this.foodInFridge = foodInFridge;
    }

    public int getTemperature()
    {
        return this.temperature;
    }

    public void setTemperature(int temperature)
    {
        this.temperature = temperature;
    }

    public void addFood(Food food)
    {
        if (food == null)
        {
            throw new IllegalArgumentException("Food cannot be null");
        }

        this.foodInFridge.add(food);
    }

    public Meat getNextMeat()
    {
        if (foodInFridge.isEmpty())
        {
            throw new FridgeIsEmptyException("Food of this type not found");
        }
        for (Food food : foodInFridge)
        {
            if (food instanceof Meat)
            {
                return (Meat) food;
            }
        }

        throw new NoMoreFoodException("No more food of the selected type is available");
    }

    public Vegetable getNextVegetable()
    {
        if (foodInFridge.isEmpty())
        {
            throw new FridgeIsEmptyException("Food of this type not found");
        }
        for (Food food : foodInFridge)
        {
            if (food instanceof Vegetable)
            {
                return (Vegetable) food;
            }
        }

        throw new NoMoreFoodException("No more food of the selected type is available");
    }
}
