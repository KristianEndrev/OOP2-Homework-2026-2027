package com.nhlstenden.kingdomsandquests;

public abstract class Character
{
    private static final int BASE_ATTACK_POWER = 89;
    private static final int BASE_DEFENSE = 673;
    private int attackPower;
    private int defense;
    private boolean defeated;

    public Character()
    {
        this.setAttackPower(BASE_ATTACK_POWER);
        this.setDefense(BASE_DEFENSE);
        this.setDefeated(false);
    }


    public int getAttackPower()
    {
        return this.attackPower;
    }

    public void setAttackPower(int attackPower)
    {
        if (attackPower < BASE_ATTACK_POWER)
        {
            throw new IllegalArgumentException("Attack power cannot be less than the base attack power");
        }

        this.attackPower = attackPower;
    }

    public int getDefense()
    {
        return this.defense;
    }

    public void setDefense(int defense)
    {
        if (defense < BASE_DEFENSE)
        {
            throw new IllegalArgumentException("Defense cannot be less than the base defense");
        }

        this.defense = defense;
    }

    public boolean isDefeated()
    {
        return this.defeated;
    }

    public void setDefeated(boolean defeated)
    {
        this.defeated = defeated;
    }

    public void attack(Character characterBeingAttacked)
    {
        characterBeingAttacked.setDefense(characterBeingAttacked.getDefense() - getAttackPower());
    }

    public abstract void useSpecialAbility();

    public void resetStats()
    {
        setAttackPower(BASE_ATTACK_POWER);
    }
}
