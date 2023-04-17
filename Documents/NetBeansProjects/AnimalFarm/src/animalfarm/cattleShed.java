
package animalfarm;

public class cattleShed extends Building {

    public cattleShed() {
        owned = false;
        buildingCost = 20;
    }


    @Override
    public String toString() {
        return "Cattle shed owned: " + super.toString();
    }
}
