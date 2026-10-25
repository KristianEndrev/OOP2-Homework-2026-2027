package com.nhlstenden.smartbbq;

import com.nhlstenden.smartbbq.fridge.*;
import com.nhlstenden.smartbbq.meat.*;
import com.nhlstenden.smartbbq.temperature.Thermometer;
import com.nhlstenden.smartbbq.vegetable.*;

public class Main
{
    public static void Main()
    {
        SmartBBQ smartBBQ = new SmartBBQ();
        Corn corn1 = new Corn(1, 1);
        Corn corn2 = new Corn(2, 2);
        Corn corn3 = new Corn(3, 3);
        BellPepper bellPepper1 = new BellPepper(1, 1);
        BellPepper bellPepper2 = new BellPepper(1, 1);
        Fridge fridge = new Fridge();

        fridge.addFood(corn1);
        fridge.addFood(corn2);
        fridge.addFood(corn3);
        fridge.addFood(bellPepper1);
        fridge.addFood(bellPepper2);

        Hamburger hamburger1 = new Hamburger(1, MeatType.COW, 1);
        Hamburger hamburger2 = new Hamburger(2, MeatType.COW, 2);
        Sausage sausage1 = new Sausage(1, MeatType.PIG, 1);
        Sausage sausage2 = new Sausage(2, MeatType.PIG, 3);
        Sausage sausage3 = new Sausage(2, MeatType.PIG, 3);

        fridge.addFood(hamburger1);
        fridge.addFood(hamburger2);
        fridge.addFood(sausage1);
        fridge.addFood(sausage2);
        fridge.addFood(sausage3);

        smartBBQ.addFood(hamburger1);
        smartBBQ.addFood(hamburger2);
        smartBBQ.addFood(sausage1);

        smartBBQ.turnOn(180);
        hamburger1.getCurrentTemperature();
        smartBBQ.turnOn(200);
        hamburger1.getCurrentTemperature();
    }
}
