package com.nhlstenden.smartbbq;

import com.nhlstenden.smartbbq.food.*;
import com.nhlstenden.smartbbq.fridge.*;
import com.nhlstenden.smartbbq.meat.*;
import com.nhlstenden.smartbbq.vegetable.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.*;

public class FridgeTest
{
    private Fridge fridge;
    private Hamburger hamburger;
    private Sausage sausage;
    private Corn corn;

    @BeforeEach
    void setUp()
    {
        fridge = new Fridge();
        hamburger = new Hamburger(1, MeatType.COW, 1);
        fridge.addFood(hamburger);
        sausage = new Sausage(1, MeatType.PIG, 1);
        corn = new Corn(1, 1);
        fridge.addFood(corn);
    }

    @Test
    void getNextMeat_properValues_returnsMeat()
    {
        assertEquals(hamburger, fridge.getNextMeat());
    }

    @Test
    void getNextMeat_emptyFridge_throws()
    {
        HashSet<Food> foodInFridge = fridge.getFoodInFridge();
        foodInFridge.remove(hamburger);
        foodInFridge.remove(corn);
        fridge.setFoodInFridge(foodInFridge);
        assertThrows(FridgeIsEmptyException.class, () -> {
            fridge.getNextMeat();
        });
    }

    @Test
    void getNextMeat_noMoreMeatInTheFridge_throws()
    {
        HashSet<Food> foodInFridge = fridge.getFoodInFridge();
        foodInFridge.remove(hamburger);
        fridge.setFoodInFridge(foodInFridge);
        assertThrows(NoMoreFoodException.class, () -> {
            fridge.getNextMeat();
        });
    }

    @Test
    void getNextMeat_properValues_doesNoThrow()
    {
        assertDoesNotThrow(() -> fridge.getNextMeat());
    }

    @Test
    void getNextMeat_properValues_returnsHamburger()
    {
        fridge.addFood(sausage);
        assertEquals(hamburger, fridge.getNextMeat());
    }

}
