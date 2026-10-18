package com.nhlstenden.vegetablegarden.vegetable;

public class Pepper extends Vegetable
{
    private static final int MINIMUM_DAYS_FOR_RAINING_31MM_EACH_TO_BREAK_DOWN = 4;
    private static final int MINIMUM_MM_FOR_RAINING_4_DAYS_EACH_TO_BREAK_DOWN = 31;
    private static final int MINIMUM_MM_NEEDED_FOR_10_DAYS_EACH__TO_GROW = 25;
    private static final int MINIMUM_DAYS_RAINING_25MM_EACH_TO_NOT_GROW = 10;
    private static final int MINIMUM_SIZE_TO_BE_MARKETABLE = 15;
    private static final int MAXIMUM_SIZE_TO_BE_MARKETABLE = 21;
    private static final double PRICE_PER_CM_IN_EURO = 0.15;

    public Pepper(double cmPerLux, double cmPerMillimeter, int ripeLength, Color color)
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
        if (amountOfDays >= MINIMUM_DAYS_FOR_RAINING_31MM_EACH_TO_BREAK_DOWN)
        {
            if (mm > MINIMUM_MM_FOR_RAINING_4_DAYS_EACH_TO_BREAK_DOWN)
            {
                setStatus(Status.DESTROYED);
            }
        }
        if (amountOfDays >= MINIMUM_DAYS_RAINING_25MM_EACH_TO_NOT_GROW)
        {
            if (mm < MINIMUM_MM_NEEDED_FOR_10_DAYS_EACH__TO_GROW)
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
        if (getSizeInCm() > MINIMUM_SIZE_TO_BE_MARKETABLE && getSizeInCm() < MAXIMUM_SIZE_TO_BE_MARKETABLE)
        {
            return true;
        }

        return false;
    }

    @Override
    public double getPriceInEuros()
    {
        return getSizeInCm() * PRICE_PER_CM_IN_EURO;
    }
}
