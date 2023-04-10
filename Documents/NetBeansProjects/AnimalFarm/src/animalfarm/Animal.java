/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package animalfarm;

/**
 *
 * @author park6
 */
abstract class Animal {

    String status;
    protected int cost;

    public Animal(String status) {
        this.status = "hungry";
        this.cost = 0;
    }

    @Override
    public String toString() {
        return this.status;
    }

    public String getStatus(String status) {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void feed() {
        this.setStatus("full");
    }
}
