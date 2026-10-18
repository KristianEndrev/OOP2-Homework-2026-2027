package com.nhlstenden.vegetablegarden.vegetable;

public class Kale extends Vegetable
{
    private static final int MINIMUM_DAYS_RAINING_40MM_EACH_TO_NOT_GROW = 6;
    private static final int MINIMUM_MM_RECEIVED_FOR_6_DAYS_EACH_TO_NOT_GROW = 40;

    public Kale(double cmPerLux, double cmPerMillimeter, int ripeLength, Color color)
    {
        super(cmPerLux, cmPerMillimeter, ripeLength, color);
    }

    @Override
    public void grow(int lux, int mm, int amountOfDays)
    {
        if (lux < 0 || mm < 0 || amountOfDays < 0)
        {
            throw new IllegalArgumentException("Lux, mm or amount of days cannot be a negative number");
        }
        if (amountOfDays >= MINIMUM_DAYS_RAINING_40MM_EACH_TO_NOT_GROW)
        {
            if (mm > MINIMUM_MM_RECEIVED_FOR_6_DAYS_EACH_TO_NOT_GROW)
            {
                return;
            }
        }

        double cmGrownPerLux = getCmPerLux() * (lux * amountOfDays);
        double cmGrownPerMm = getCmPerMillimeter() * (mm * amountOfDays);

        double updatedSizeInCm = getSizeInCm() + cmGrownPerLux + cmGrownPerMm;
        setSizeInCm(updatedSizeInCm);
    }

    @Override
    public void updateStatus()
    {
        if (getSizeInCm() >= getRipeLength())
        {
            setStatus(Status.READY_TO_HARVEST);
        }
    }

    @Override
    public boolean isMarketable()
    {
        return false;
    }

    @Override
    public double getPriceInEuros()
    {
        return 0;
    }
}