
package animalfarm;

public class sheepPen extends Building {

    public sheepPen() {
        owned = false;
        buildingCost = 10;
    }

    @Override
    public String toString() {
        return "Sheep pen owned: " + super.toString();
    }
}
