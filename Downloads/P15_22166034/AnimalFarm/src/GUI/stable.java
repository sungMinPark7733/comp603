
package GUI;

import animalfarm.*;

public class stable extends Building {

    public stable() {
        owned = false;
        buildingCost = 20;
    }

    @Override
    public String toString() {
        return "stable owned: " + super.toString();
    }
}
