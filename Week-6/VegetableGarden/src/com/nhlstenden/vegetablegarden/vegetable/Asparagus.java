package com.nhlstenden.vegetablegarden.vegetable;

public class Asparagus extends Vegetable
{
    private static final int MINIMUM_MM_OF_RAIN_RECEIVED_FOR_TEN_DAYS_EACH = 14;
    private static final int AMOUNT_OF_DAYS_IN_WHICH_RECEIVED_14_MM_OF_RAIN_EACH_TO_BREAK_DOWN = 10;
    private static final int MAXIMUM_CM_SIZE_TO_BE_MARKETABLE = 29;
    private static final double PRICE_PER_CM_IN_EURO = 0.12;

    public Asparagus(double cmPerLux, double cmPerMillimeter, int ripeLength, Color color)
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
        if (amountOfDays >= AMOUNT_OF_DAYS_IN_WHICH_RECEIVED_14_MM_OF_RAIN_EACH_TO_BREAK_DOWN)
        {
            if (mm < MINIMUM_MM_OF_RAIN_RECEIVED_FOR_TEN_DAYS_EACH)
            {
                setStatus(Status.DESTROYED);
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
        if (getSizeInCm() <= MAXIMUM_CM_SIZE_TO_BE_MARKETABLE)
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
