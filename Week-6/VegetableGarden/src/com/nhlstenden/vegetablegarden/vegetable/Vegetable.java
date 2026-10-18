package com.nhlstenden.vegetablegarden.vegetable;

public abstract class Vegetable
{
    private double sizeInCm;
    private double cmPerLux;
    private double cmPerMillimeter;
    private int ripeLength;
    private Color color;
    private Status status;

    public Vegetable(double cmPerLux, double cmPerMillimeter, int ripeLength, Color color)
    {
        this.setSizeInCm(0);
        this.setCmPerLux(cmPerLux);
        this.setCmPerMillimeter(cmPerMillimeter);
        this.setRipeLength(ripeLength);
        this.setColor(color);
        this.setStatus(Status.GROWING);
    }

    public double getSizeInCm()
    {
        return this.sizeInCm;
    }

    public void setSizeInCm(double sizeInCm)
    {
        if (sizeInCm < 0)
        {
            throw new IllegalArgumentException("Size in cm cannot be negative");
        }

        this.sizeInCm = sizeInCm;
    }

    public double getCmPerLux()
    {
        return this.cmPerLux;
    }

    public void setCmPerLux(double cmPerLux)
    {
        if (cmPerLux < 0)
        {
            throw new IllegalArgumentException("Cm per lux cannot be negative");
        }
        if (this instanceof Asparagus)
        {
            this.cmPerLux = 0.000027;
            return;
        }
        if (this instanceof Pepper)
        {
            this.cmPerLux = 0.000044;
            return;
        }
        if (this instanceof  Kale)
        {
            this.cmPerLux = 0.0057;
            return;
        }

        this.cmPerLux = cmPerLux;
    }

    public double getCmPerMillimeter()
    {
        return this.cmPerMillimeter;
    }

    public void setCmPerMillimeter(double cmPerMillimeter)
    {
        if (cmPerMillimeter < 0)
        {
            throw new IllegalArgumentException("Cm per millimeter cannot be negative");
        }
        if (this instanceof Asparagus)
        {
            this.cmPerMillimeter = 0.0049;
            return;
        }
        if (this instanceof Pepper)
        {
            this.cmPerMillimeter = 0.0013;
            return;
        }
        if (this instanceof  Kale)
        {
            this.cmPerMillimeter = 0.032;
            return;
        }

        this.cmPerMillimeter = cmPerMillimeter;
    }

    public int getRipeLength()
    {
        return this.ripeLength;
    }

    public void setRipeLength(int ripeLength)
    {
        if (ripeLength < 0)
        {
            throw new IllegalArgumentException("Ripe length cannot be negative");
        }
        if (this instanceof Asparagus)
        {
            this.ripeLength = 20;
            return;
        }
        if (this instanceof Pepper)
        {
            this.ripeLength = 7;
            return;
        }
        if (this instanceof Kale)
        {
            this.ripeLength = 16;
            return;
        }

        this.ripeLength = ripeLength;
    }

    public Color getColor()
    {
        return this.color;
    }

    public void setColor(Color color)
    {
        if (color == null)
        {
            throw new IllegalArgumentException("Color cannot be null");
        }
        if (this instanceof Asparagus)
        {
            this.color = Color.BLUE;
            return;
        }
        if (this instanceof Pepper)
        {
            this.color = Color.PINK;
            return;
        }
        if (this instanceof Kale)
        {
            this.color = Color.YELLOW;
            return;
        }

        this.color = color;
    }

    public Status getStatus()
    {
        return this.status;
    }

    public void setStatus(Status status)
    {
        if (status == null)
        {
            throw new IllegalArgumentException("Status cannot be null");
        }

        this.status = status;
    }

    public abstract void grow(int lux, int mm, int amountOfDays);

    public abstract void updateStatus();

    public abstract boolean isMarketable();

    public abstract double getPriceInEuros();
}
