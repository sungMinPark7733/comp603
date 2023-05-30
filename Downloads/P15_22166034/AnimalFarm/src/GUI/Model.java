package GUI;

import animalfarm.Animal;
import animalfarm.Building;
import animalfarm.cattleShed;
import animalfarm.pigsty;
import animalfarm.sheepPen;
import animalfarm.stable;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Observable;

public class Model extends Observable {

    private Connection conn;
    private String url;
    private String username;
    private String password;
    private ArrayList<Animal> animals;
    private int coin;
    private Building pigsty;
    private Building sheepPen;
    private Building cattleShed;
    private Building stable;

    public Model() {
        this.stable = new stable();
        this.cattleShed = new cattleShed();
        this.sheepPen = new sheepPen();
        this.pigsty = new pigsty();
        this.url = "jdbc:derby:CarDB; create=true";
        this.conn = null;
        this.username = null;
        this.password = null;
        animals = new ArrayList<>();
        coin = 5;
    }

    
    
    /**
     * @return the animals
     */
    public ArrayList<Animal> getAnimals() {
        return animals;
    }

    /**
     * @param animals the animals to set
     */
    public void setAnimals(ArrayList<Animal> animals) {
        this.animals = animals;
        setChanged();
        notifyObservers(animals);
    }

    /**
     * @return the coin
     */
    public int getCoin() {
        return coin;
    }
}
