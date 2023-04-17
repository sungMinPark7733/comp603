/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package animalfarm;

/**
 *
 * @author park6
 */
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
