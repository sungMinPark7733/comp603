/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package animalfarm;

/**
 *
 * @author park6
 */
public class chicken extends Animal {

    public chicken() {
        status = "hungry";
        cost = 1;
    }

    @Override
    public String toString() {
        return "Chicken status: " + super.toString();
    }
}
