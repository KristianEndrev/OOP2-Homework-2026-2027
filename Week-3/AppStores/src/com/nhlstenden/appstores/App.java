package com.nhlstenden.appstores;

public class App
{
    private String name;
    private int priceInCents;
    private boolean violence;
    private boolean nudity;

    public App(String name, int priceInCents, boolean violence, boolean nudity)
    {
        this.setName(name);
        this.setPriceInCents(priceInCents);
        this.setViolence(violence);
        this.setNudity(nudity);
    }

    public String getName()
    {
        return this.name;
    }

    public void setName(String name)
    {
        if (name == null || name.isBlank())
        {
            throw new IllegalArgumentException("name cannot be null or blank");
        }

        this.name = name;
    }

    public int getPriceInCents()
    {
        return this.priceInCents;
    }

    public void setPriceInCents(int priceInCents)
    {
        if (priceInCents < 0)
        {
            throw new IllegalArgumentException("Price cannot be negative");
        }

        this.priceInCents = priceInCents;
    }

    public boolean hasViolence()
    {
        return this.violence;
    }

    public void setViolence(boolean violence)
    {
        this.violence = violence;
    }

    public boolean hasNudity()
    {
        return this.nudity;
    }

    public void setNudity(boolean nudity)
    {
        this.nudity = nudity;
    }
}
