package com.nhlstenden.vegetablegarden;

import com.nhlstenden.vegetablegarden.vegetable.*;

import java.util.HashSet;

public class Market
{
    private HashSet<Vegetable> marketableVegetables;
    private double totalRevenueInEuro;

    public Market()
    {
        this.setMarketableVegetables(new HashSet<>());
        this.setTotalRevenueInEuro(0);
    }

    public HashSet<Vegetable> getMarketableVegetables()
    {
        return new HashSet<>(this.marketableVegetables);
    }

    public void setMarketableVegetables(HashSet<Vegetable> marketableVegetables)
    {
        if (marketableVegetables == null)
        {
            throw new IllegalArgumentException("Vegetables cannot be null");
        }
        for (Vegetable vegetable : marketableVegetables)
        {
            if (vegetable == null)
            {
                throw new IllegalArgumentException("A vegetable cannot be null");
            }
        }

        this.marketableVegetables = marketableVegetables;    }

    public double getTotalRevenueInEuro()
    {
        return this.totalRevenueInEuro;
    }

    public void setTotalRevenueInEuro(double totalRevenueInEuro)
    {
        if (totalRevenueInEuro < 0)
        {
            throw new IllegalArgumentException("Total price in euro cannot be negative");
        }

        this.totalRevenueInEuro = totalRevenueInEuro;
    }

    public void addMarketableVegetable(Vegetable vegetable)
    {
        if (vegetable == null)
        {
            throw new IllegalArgumentException("Vegetable cannot be null");
        }
        if (vegetable.isMarketable())
        {
            marketableVegetables.add(vegetable);
        }
    }

    public void sellVegetables(HashSet<Vegetable> vegetables)
    {
        if (marketableVegetables.containsAll(vegetables))
        {
            for (Vegetable vegetable : vegetables)
            {
                totalRevenueInEuro += vegetable.getPriceInEuros();
                marketableVegetables.remove(vegetable);
            }
        }

        throw new IllegalArgumentException("We do not sell these vegetables in our garden");
    }
}
