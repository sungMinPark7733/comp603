
package animalfarm;

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
