package com.nhlstenden.vegetablegarden;

public class TooManyVegetablesException extends RuntimeException
{
    public TooManyVegetablesException(String message)
    {
        super(message);
    }
}
