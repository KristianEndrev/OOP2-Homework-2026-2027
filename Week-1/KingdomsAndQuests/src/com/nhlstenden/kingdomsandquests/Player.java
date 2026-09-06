package com.nhlstenden.kingdomsandquests;

import java.util.ArrayList;
import java.util.List;

public class Player
{
    private static final int NEEDED_POINTS_TO_LEVEL_UP = 200;
    private List<Quest> quests;
    private List<Character> characters;
    private int xp;
    private int level;
    private boolean inQuest;
    private List<Item> items;

    public Player()
    {
        this.setQuests(new ArrayList<>());
        this.setCharacters(new ArrayList<>());
        this.setXp(0);
        this.setLevel(1);
        this.setInQuest(false);
        this.setItems(new ArrayList<>());
    }

    public List<Quest> getQuests()
    {
        return new ArrayList<>(this.quests);
    }

    public void setQuests(List<Quest> quests)
    {
        if (quests == null)
        {
            throw new IllegalArgumentException("quests cannot be null");
        }

        for (Quest quest : quests)
        {
            if (quest == null)
            {
                throw new IllegalArgumentException("A quest cannot be null");
            }
        }

        this.quests = new ArrayList<>(quests);
    }

    public List<Character> getCharacters()
    {
        return new ArrayList<>(this.characters);
    }

    public void setCharacters(List<Character> characters)
    {
        if (characters == null)
        {
            throw new IllegalArgumentException("characters cannot be null");
        }

        for (Character character : characters)
        {
            if (character == null)
            {
                throw new IllegalArgumentException("A character cannot be null");
            }
        }

        this.characters = new ArrayList<>(characters);
    }

    public int getXp()
    {
        return this.xp;
    }

    public void setXp(int xp)
    {
        if (xp < 0)
        {
            throw new IllegalArgumentException("Xp cannot be negative");
        }

        this.xp = xp;
    }

    public int getLevel()
    {
        return this.level;
    }

    public void setLevel(int level)
    {
        if (level < 1)
        {
            throw new IllegalArgumentException("Level cannot be less than 1");
        }

        this.level = level;
    }

    public boolean isInQuest()
    {
        return this.inQuest;
    }

    public void setInQuest(boolean inQuest)
    {
        this.inQuest = inQuest;
    }

    public List<Item> getItems()
    {
        return new ArrayList<>(this.items);
    }

    public void setItems(List<Item> items)
    {
        if (items == null)
        {
            throw new IllegalArgumentException("items cannot be null");
        }

        for (Item item : items)
        {
            if (item == null)
            {
                throw new IllegalArgumentException("An item cannot be null");
            }
        }

        this.items = new ArrayList<>(items);
    }

    public void levelUp()
    {
        int currentLevel = getLevel();
        int currentXp = getXp();
        int correctLevel = currentXp/NEEDED_POINTS_TO_LEVEL_UP;

        if(currentLevel != correctLevel)
        {
            setLevel(correctLevel);
        }
        else
        {
            int neededXpPoints = currentLevel * NEEDED_POINTS_TO_LEVEL_UP - currentXp;
            throw new IllegalArgumentException("You need" + neededXpPoints + " more points to level up");
        }
    }

    public void startQuest(Character character, Quest quest)
    {
        if (isInQuest())
        {
            throw new IllegalArgumentException("The player is in a quest right now");
        }
        if (getXp() < quest.getNeededXp())
        {
            throw new IllegalArgumentException("Not enough xp to start the quest");
        }
        if (character == null)
        {
            throw new IllegalArgumentException("Character cannot be null");
        }
        if (quest == null)
        {
            throw new IllegalArgumentException("Quest cannot be null");
        }
        boolean characterFound = false;
        for (Character character1 : getCharacters())
        {
            if (character.equals(character1))
            {
                characterFound = true;
                break;
            }
        }
        if (!characterFound)
        {
            throw new IllegalArgumentException("Character not found");
        }
        boolean questFound = false;
        for (Quest quest1 : getQuests())
        {
            if (quest.equals(quest1))
            {
                questFound = true;
                break;
            }
        }
        if (!questFound)
        {
            throw new IllegalArgumentException("Quest not found");
        }
        setInQuest(true);
        fightCharacter(character, quest);
        endQuest(quest);
    }

    public void fightCharacter(Character character, Quest quest)
    {
        Character questCharacter = quest.getCharacterToPlayAgainst();

        int attackPowerPlayer = character.getAttackPower();
        int defensePlayer = character.getDefense();

        character.useSpecialAbility();
        questCharacter.useSpecialAbility();

        character.attack(questCharacter);
        questCharacter.attack(character);

        character.resetStats();
        questCharacter.resetStats();
        if (character instanceof Mage mage)
        {
            mage.setDefense(mage.getDefense() - 100);
        }
        if (questCharacter instanceof Mage mage)
        {
            mage.setDefense(mage.getDefense() - 100);
        }

        int attackPowerQuestCharacter = questCharacter.getAttackPower();
        int defenseQuestCharacter = questCharacter.getDefense();

        int attacksNeededPlayerToKill = defenseQuestCharacter/attackPowerPlayer;
        int attacksNeededQuestCharacterToKill = defensePlayer/attackPowerQuestCharacter;

        if (attacksNeededPlayerToKill > attacksNeededQuestCharacterToKill)
        {
            questCharacter.setDefeated(true);
        }
    }

    public boolean isCharacterDefeated(Quest quest)
    {
        if (quest == null)
        {
            throw new IllegalArgumentException("Quest cannot be null");
        }

        for (Quest quest1 : getQuests())
        {
            if (quest.equals(quest1))
            {
                return quest1.getCharacterToPlayAgainst().isDefeated();
            }
        }

        throw new IllegalArgumentException("Quest not found");
    }

    public void endQuest(Quest quest)
    {
        if (isCharacterDefeated(quest))
        {
            quest.setCompleted(true);
            setXp(getXp() + quest.getOfferedXp());
            if (quest instanceof SpecialQuest specialQuest)
            {
                List<Item> itemsToAdd = specialQuest.getItems();
                List<Item> currentItems = getItems();
                currentItems.addAll(itemsToAdd);
                setItems(currentItems);
                setInQuest(false);
            }
        }
    }
}
