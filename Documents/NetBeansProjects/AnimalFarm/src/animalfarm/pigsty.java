/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package animalfarm;

/**
 *
 * @author park6
 */
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
