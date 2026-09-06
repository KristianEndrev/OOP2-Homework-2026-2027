package com.nhlstenden.kingdomsandquests;

public class Archer extends Character
{
    private static final int DOUBLE_DAMAGE = 2;

    public Archer()
    {
    }

    public void useSpecialAbility()
    {
        int damage = getAttackPower();
        setAttackPower(damage * DOUBLE_DAMAGE);
    }
}
