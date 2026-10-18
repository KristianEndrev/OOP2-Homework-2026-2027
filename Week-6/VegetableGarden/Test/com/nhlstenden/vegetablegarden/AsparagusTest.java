package com.nhlstenden.vegetablegarden;

import com.nhlstenden.vegetablegarden.vegetable.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AsparagusTest
{
    private Asparagus asparagus;

    @BeforeEach
    void setUp()
    {
        asparagus = new Asparagus(0.000027, 0.0049, 20, Color.BLUE);
    }

    @Test
    void grow_negativeLux_throws()
    {
        assertThrows(IllegalArgumentException.class, () -> {
            asparagus.grow(-1, 1, 1);
        });
    }

    @Test
    void grow_negativeMm_throws()
    {
        assertThrows(IllegalArgumentException.class, () -> {
            asparagus.grow(1, -1, 1);
        });
    }

    @Test
    void grow_negativeAmountOfDays_throws()
    {
        assertThrows(IllegalArgumentException.class, () -> {
            asparagus.grow(-1, 1, -1);
        });
    }

    @Test
    void grow_allArgumentsNegative_throws()
    {
        assertThrows(IllegalArgumentException.class, () -> {
            asparagus.grow(-1, -1, -1);
        });
    }

    @Test
    void grow_properValues_doesNotThrow()
    {
        assertDoesNotThrow(() -> asparagus.grow(1, 1, 1));
    }

    @Test
    void grow_1cmLuxAndMmFor1day_expectsSizeOfPoint004927()
    {
        asparagus.grow(1, 1, 1);
        assertEquals(0.004927, asparagus.getSizeInCm());
    }

    @Test
    void grow_13mm10Days_toBeDestroyed()
    {
        asparagus.grow(1, 13, 10);
        assertEquals(Status.DESTROYED, asparagus.getStatus());
    }


}
