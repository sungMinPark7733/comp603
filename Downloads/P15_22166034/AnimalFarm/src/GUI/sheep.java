
package GUI;


public class sheep extends Animal {

    public sheep() {
        status = "hungry";
        cost = 2;
    }

    @Override
    public String toString() {
        return "Sheep status: " + super.toString();
    }
}
