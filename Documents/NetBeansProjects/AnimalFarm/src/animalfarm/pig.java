/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package animalfarm;

/**
 *
 * @author park6
 */
public class pig extends Animal {

    public pig(String status) {
        super(status);
        cost = 2;
    }

    @Override
    public String toString() {
        return "Pig status: " + super.toString();
    }
}
