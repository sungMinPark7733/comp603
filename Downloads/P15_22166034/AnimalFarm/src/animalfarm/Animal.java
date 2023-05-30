
package animalfarm;

public abstract class Animal {

    String status;
    protected int cost;

    public Animal() {
        status = "hungry";
        cost = 0;
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
