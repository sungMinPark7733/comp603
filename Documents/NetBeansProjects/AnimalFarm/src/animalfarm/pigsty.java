
package animalfarm;

public class pigsty extends Building {

    public pigsty() {
        owned = false;
        buildingCost = 10;
    }

    @Override
    public String toString() {
        return "Pigsty owned: " + super.toString();
    }
}
