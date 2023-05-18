
package animalfarm;

public class pig extends Animal {

    public pig() {
        status = "hungry";
        cost = 2;
    }

    @Override
    public String toString() {
        return "Pig status: " + super.toString();
    }
}
