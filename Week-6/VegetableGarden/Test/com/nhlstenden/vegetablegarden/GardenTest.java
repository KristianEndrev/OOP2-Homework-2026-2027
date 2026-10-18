package com.nhlstenden.vegetablegarden;

import com.nhlstenden.vegetablegarden.environment.*;
import com.nhlstenden.vegetablegarden.vegetable.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.*;

public class GardenTest
{
    private Asparagus asparagus1;
    private Asparagus asparagus2;
    private Asparagus asparagus3;
    private Asparagus asparagus4;
    private Asparagus asparagus5;
    private Asparagus asparagus6;
    private Asparagus asparagus7;
    private Asparagus asparagus8;
    private Asparagus asparagus9;
    private Kale kale1;
    private Kale kale2;
    private Kale kale3;
    private Kale kale4;
    private Kale kale5;
    private Kale kale6;
    private Kale kale7;
    private Kale kale8;
    private Kale kale9;
    private Pepper pepper1;
    private Pepper pepper2;
    private Pepper pepper3;
    private Pepper pepper4;
    private Pepper pepper5;
    private Pepper pepper6;
    private Pepper pepper7;
    private Pepper pepper8;
    private Pepper pepper9;
    private Pepper pepper10;
    private Garden garden;
    private HashSet<Vegetable> vegetables;

    @BeforeEach
    void setUp()
    {
        asparagus1 = new Asparagus(0.000027, 0.0049, 20, Color.BLUE);
        asparagus2 = new Asparagus(0.000027, 0.0049, 20, Color.BLUE);
        asparagus3 = new Asparagus(0.000027, 0.0049, 20, Color.BLUE);
        asparagus4 = new Asparagus(0.000027, 0.0049, 20, Color.BLUE);
        asparagus5 = new Asparagus(0.000027, 0.0049, 20, Color.BLUE);
        asparagus6 = new Asparagus(0.000027, 0.0049, 20, Color.BLUE);
        asparagus7 = new Asparagus(0.000027, 0.0049, 20, Color.BLUE);
        asparagus8 = new Asparagus(0.000027, 0.0049, 20, Color.BLUE);
        asparagus9 = new Asparagus(0.000027, 0.0049, 20, Color.BLUE);
        kale1 = new Kale(0.0057, 0.032, 16, Color.YELLOW);
        kale2 = new Kale(0.0057, 0.032, 16, Color.YELLOW);
        kale3 = new Kale(0.0057, 0.032, 16, Color.YELLOW);
        kale4 = new Kale(0.0057, 0.032, 16, Color.YELLOW);
        kale5 = new Kale(0.0057, 0.032, 16, Color.YELLOW);
        kale6 = new Kale(0.0057, 0.032, 16, Color.YELLOW);
        kale7 = new Kale(0.0057, 0.032, 16, Color.YELLOW);
        kale8 = new Kale(0.0057, 0.032, 16, Color.YELLOW);
        kale9 = new Kale(0.0057, 0.032, 16, Color.YELLOW);
        pepper1 = new Pepper(0.000044, 0.0013, 7, Color.PINK);
        pepper2 = new Pepper(0.000044, 0.0013, 7, Color.PINK);
        pepper3 = new Pepper(0.000044, 0.0013, 7, Color.PINK);
        pepper4 = new Pepper(0.000044, 0.0013, 7, Color.PINK);
        pepper5 = new Pepper(0.000044, 0.0013, 7, Color.PINK);
        pepper6 = new Pepper(0.000044, 0.0013, 7, Color.PINK);
        pepper7 = new Pepper(0.000044, 0.0013, 7, Color.PINK);
        pepper8 = new Pepper(0.000044, 0.0013, 7, Color.PINK);
        pepper9 = new Pepper(0.000044, 0.0013, 7, Color.PINK);
        pepper10 = new Pepper(0.000044, 0.0013, 7, Color.PINK);
        vegetables = new HashSet<>();
        vegetables.add(asparagus1);
        vegetables.add(asparagus2);
        vegetables.add(asparagus3);
        vegetables.add(asparagus4);
        vegetables.add(asparagus5);
        vegetables.add(asparagus6);
        vegetables.add(asparagus7);
        vegetables.add(asparagus8);
        vegetables.add(asparagus9);
        vegetables.add(kale1);
        vegetables.add(kale2);
        vegetables.add(kale3);
        vegetables.add(kale4);
        vegetables.add(kale5);
        vegetables.add(kale6);
        vegetables.add(kale7);
        vegetables.add(kale8);
        vegetables.add(kale9);
        vegetables.add(pepper1);
        vegetables.add(pepper2);
        vegetables.add(pepper3);
        vegetables.add(pepper4);
        vegetables.add(pepper5);
        vegetables.add(pepper6);
        vegetables.add(pepper7);
        vegetables.add(pepper8);
        vegetables.add(pepper9);
        garden = new Garden(vegetables);
    }

    @Test
    void sizeOfVegetablesHashSetOfGarden_under27vegetables_doesNotThrow()
    {
        assertDoesNotThrow(() -> garden.setVegetables(vegetables));
    }

    @Test
    void sizeOfVegetablesHashSetOfGarden_over27vegetables_throws()
    {
        vegetables.add(pepper10);
        assertThrows(TooManyVegetablesException.class, () -> {
            garden.setVegetables(vegetables);
        });
    }
}
