/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package animalfarm;

/**
 *
 * @author park6
 */
public class horse extends Animal {

    public horse() {
        status = "hungry";
        cost = 3;
    }

    @Override
    public String toString() {
        return "Horse status: " + super.toString();
    }
}
