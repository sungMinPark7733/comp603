/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package animalfarm;

/**
 *
 * @author park6
 */
public class cattle extends Animal {

    public cattle(String status) {
        super(status);
        cost = 3;
    }

    @Override
    public String toString() {
        return "Cattle status: " + super.toString();
    }

}
