/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package animalfarm;

/**
 *
 * @author park6
 */
abstract class Building {

    private boolean owned;
    protected int buildingCost;
    private String check;

    public Building(boolean owned) {
        this.owned = false;
        this.buildingCost = 0;
    }

    @Override
    public String toString() {
        check = String.valueOf(this.owned);
        return this.check;
    }

    /**
     * @return the owned
     */
    public boolean isOwned() {
        return this.owned;
    }

    /**
     * @param owned the owned to set
     */
    public void setOwned(boolean owned) {
        this.owned = owned;
    }

    public void purchsed() {
        this.owned = true;
    }

}
