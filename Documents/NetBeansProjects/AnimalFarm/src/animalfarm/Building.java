package animalfarm;

abstract class Building {

    public boolean owned;
    protected int buildingCost;
    private String check;

    public Building() {
        owned = false;
        buildingCost = 0;
    }

    @Override
    public String toString() {
        check = String.valueOf(this.owned);
        return this.check;
    }

    public boolean isOwned() {
        return this.owned;
    }

    public void setOwned(boolean owned) {
        this.owned = owned;
    }

    public void purchsed() {
        this.owned = true;
    }

}
