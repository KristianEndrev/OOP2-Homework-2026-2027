package com.nhlstenden.smartbbq.meat;

import com.nhlstenden.smartbbq.food.Food;

public abstract class Meat extends Food
{
    private double currentCookedPercentage;
    private double cookingFactor;
    private MeatType meatType;

    public Meat(double browningFactor, MeatType meatType, double cookingFactor)
    {
        super(browningFactor);
        this.setCurrentCookedPercentage(0);
        this.setMeatType(meatType);
        this.setCookingFactor(cookingFactor);
    }


    public double getCurrentCookedPercentage()
    {
        return this.currentCookedPercentage;
    }

    public void setCurrentCookedPercentage(double currentCookedPercentage)
    {
        if (currentCookedPercentage < 0)
        {
            throw new IllegalArgumentException("Current cooked percentage cannot be negative");
        }

        this.currentCookedPercentage = currentCookedPercentage;
    }

    public double getCookingFactor()
    {
        return this.cookingFactor;
    }

    public void setCookingFactor(double cookingFactor)
    {
        if (cookingFactor < 0)
        {
            throw new IllegalArgumentException("Cooking factor cannot be negative");
        }

        this.cookingFactor = cookingFactor;
    }

    public MeatType getMeatType()
    {
        return this.meatType;
    }

    public void setMeatType(MeatType meatType)
    {
        if (meatType == null)
        {
            throw new IllegalArgumentException("Meat type cannot be null");
        }

        this.meatType = meatType;
    }
}
