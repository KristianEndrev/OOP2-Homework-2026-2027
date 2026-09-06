package com.nhlstenden.kingdomsandquests;

public class Quest
{
    private static final int NEEDED_XP_MULTIPLIER = 10;
    private boolean completed;
    private int offeredXp;
    private int difficultyLevel;
    private Character characterToPlayAgainst;

    public Quest(int offeredXp, int difficultyLevel)
    {
        this.setCompleted(false);
        this.setOfferedXp(offeredXp);
        this.setDifficultyLevel(difficultyLevel);
        this.setCharacterToPlayAgainst(chooseCharacter());
    }

    public boolean isCompleted()
    {
        return this.completed;
    }

    public void setCompleted(boolean completed)
    {
        this.completed = completed;
    }

    public int getOfferedXp()
    {
        return this.offeredXp;
    }

    public void setOfferedXp(int offeredXp)
    {
        if (offeredXp < 0)
        {
            throw new IllegalArgumentException("Offered xp cannot be negative");
        }

        this.offeredXp = offeredXp;
    }

    public int getDifficultyLevel()
    {
        return this.difficultyLevel;
    }

    public void setDifficultyLevel(int difficultyLevel)
    {
        if (difficultyLevel <= 0)
        {
            throw new IllegalArgumentException("Difficulty level cannot be negative");
        }

        this.difficultyLevel = difficultyLevel;
    }

    public Character getCharacterToPlayAgainst()
    {
        return this.characterToPlayAgainst;
    }

    public void setCharacterToPlayAgainst(Character characterToPlayAgainst)
    {
        if (characterToPlayAgainst == null)
        {
            throw new IllegalArgumentException("The character you are trying to play against can not be null");
        }

        this.characterToPlayAgainst = characterToPlayAgainst;
    }

    public Character chooseCharacter()
    {
        if (getDifficultyLevel() <= 3)
        {
            return new Warrior();
        }
        else if (getDifficultyLevel() > 3 && getDifficultyLevel() < 7)
        {
            return new Mage();
        }
        else if (getDifficultyLevel() > 7)
        {
            return new Archer();
        }

        throw new IllegalArgumentException("There is a problem with character choosing");
    }

    public int getNeededXp()
    {
        return getDifficultyLevel() * NEEDED_XP_MULTIPLIER;
    }
}
