/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package animalfarm;

/**
 *
 * @author park6
 */
public class cattleShed extends Building {

    public cattleShed(boolean owned) {
        super(owned);
        buildingCost = 20;
    }


    @Override
    public String toString() {
        return "Cattle shed owned: " + super.toString();
    }
}
