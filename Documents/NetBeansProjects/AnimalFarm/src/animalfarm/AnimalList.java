package animalfarm;

import java.util.ArrayList;

public class AnimalList {

    public static ArrayList<Animal> animals;
    public static int coin;
    public static Building pigsty = new pigsty();
    public static Building sheepPen = new sheepPen();
    public static Building cattleShed = new cattleShed();
    public static Building stable = new stable();
    
    public AnimalList() {
        animals = new ArrayList<>();
        coin = 10;
    }
}
