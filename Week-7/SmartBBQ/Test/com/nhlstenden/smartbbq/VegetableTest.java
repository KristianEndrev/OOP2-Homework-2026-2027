package com.nhlstenden.smartbbq;

import com.nhlstenden.smartbbq.meat.*;
import com.nhlstenden.smartbbq.vegetable.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class VegetableTest
{
    private Hamburger hamburger;
    private Corn corn;
    private BellPepper bellPepper;

    @BeforeEach
    void setUp()
    {
        hamburger = new Hamburger(1, MeatType.COW, 1);
        corn = new Corn(1, 1);
        bellPepper = new BellPepper(1, 1);
    }

    @Test
    void setMoistPercentage_properValues_equals75()
    {
        corn.setMoistPercentage(75);
        assertEquals(75, corn.getMoistPercentage());
    }

    @Test
    void setMoistPercentage_above100_throws()
    {
        assertThrows(IllegalArgumentException.class, () -> {
           corn.setMoistPercentage(120);
        });
    }

    @Test
    void decreaseMoistPercentageInGrillMethod_moistPercentOf100_moistToBe95()
    {
        corn.decreaseMoistPercentage(5);
        assertEquals(95, corn.getMoistPercentage());
    }

    @Test
    void decreaseMoistPercentage_moistPercentOf100_doesNotThrow()
    {
        assertDoesNotThrow(() -> corn.decreaseMoistPercentage(1));
    }

    @Test
    void decreaseMoistPercentage_negativeDifference_throws()
    {
        assertThrows(IllegalArgumentException.class, () -> {
            corn.decreaseMoistPercentage(-1);
        });
    }

    @Test
    void decreaseMoistPercentage_tooBigDifference_throws()
    {
        assertThrows(IllegalArgumentException.class, () -> {
            corn.decreaseMoistPercentage(101);
        });
    }

}
