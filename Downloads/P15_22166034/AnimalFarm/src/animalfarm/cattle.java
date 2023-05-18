
package animalfarm;

public class cattle extends Animal {

    public cattle() {
        status = "hungry";
        cost = 3;
    }

    @Override
    public String toString() {
        return "Cattle status: " + super.toString();
    }

}
