
package animalfarm;

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
