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

    public stable() {
        owned = false;
        buildingCost = 20;
    }

    @Override
    public String toString() {
        return "stable owned: " + super.toString();
    }
}
