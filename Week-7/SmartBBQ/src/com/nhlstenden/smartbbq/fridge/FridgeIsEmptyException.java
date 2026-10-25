package com.nhlstenden.smartbbq.fridge;

public class FridgeIsEmptyException extends RuntimeException
{
    public FridgeIsEmptyException(String message)
    {
        super(message);
    }
}
