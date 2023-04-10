/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package animalfarm;

/**
 *
 * @author park6
 */
public class stable extends Building {

    public stable(boolean owned) {
        super(owned);
        buildingCost = 20;
    }

    @Override
    public String toString() {
        return "stable owned: " + super.toString();
    }
}
