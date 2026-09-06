package com.nhlstenden.kingdomsandquests;

public class Mage extends Character
{
    private static final int DEFENSE_INCREASE = 100;

    public Mage()
    {
    }

    public void useSpecialAbility()
    {
        int defense = getDefense();
        setDefense(defense + 100);
    }
}
