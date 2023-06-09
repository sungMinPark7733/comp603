
package animalfarm;

public abstract class Animal {

    String status;
    int cost;

    public Animal() {
        status = "hungry";
        cost = 0;
    }

    @Override
    public String toString() {
        return this.getStatus();
    }

    public String getStatus(String status) {
        return this.getStatus();
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void feed() {
        this.setStatus("full");
    }

    /**
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @return the cost
     */
    public int getCost() {
        return cost;
    }
}
