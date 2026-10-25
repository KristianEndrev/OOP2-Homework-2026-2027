package com.nhlstenden.smartbbq.fridge;

public class NoMoreFoodException extends RuntimeException
{
    public NoMoreFoodException(String message)
    {
        super(message);
    }
}
