package GUI;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Observable;
import java.io.FileWriter;
import java.io.PrintWriter;

public class Model extends Observable {

    public Database db;
    public Data data;
    private ArrayList<Animal> animals;
    private int coin;
    public Building stable;
    public Building cattleShed;
    public Building sheepPen;
    public Building pigsty;
    private int hungryChickenNumber;
    private int hungryPigNumber;
    private int hungrySheepNumber;
    private int hungryHorseNumber;
    private int hungryCattleNumber;
    private int fullChickenNumber;
    private int fullPigNumber;
    private int fullSheepNumber;
    private int fullHorseNumber;
    private int fullCattleNumber;

    public Model() {
        this.pigsty = new pigsty();
        this.sheepPen = new sheepPen();
        this.cattleShed = new cattleShed();
        this.stable = new stable();
        this.coin = 10;
        this.fullCattleNumber = 0;
        this.fullHorseNumber = 0;
        this.fullSheepNumber = 0;
        this.fullPigNumber = 0;
        this.fullChickenNumber = 0;
        this.hungryCattleNumber = 0;
        this.hungryHorseNumber = 0;
        this.hungrySheepNumber = 0;
        this.hungryPigNumber = 0;
        this.hungryChickenNumber = 0;
        this.db = new Database();
        this.db.dbsetup();
        this.animals = new ArrayList<>();
    }

    public void reset() {
        this.pigsty = new pigsty();
        this.sheepPen = new sheepPen();
        this.cattleShed = new cattleShed();
        this.stable = new stable();
        this.coin = 10;
        this.fullCattleNumber = 0;
        this.fullHorseNumber = 0;
        this.fullSheepNumber = 0;
        this.fullPigNumber = 0;
        this.fullChickenNumber = 0;
        this.hungryCattleNumber = 0;
        this.hungryHorseNumber = 0;
        this.hungrySheepNumber = 0;
        this.hungryPigNumber = 0;
        this.hungryChickenNumber = 0;
        this.db = new Database();
        this.db.dbsetup();
        this.animals = new ArrayList<>();
    }

    public void saveGame(String filepath) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filepath))) {
            writer.println("Coin number:" + coin);
            writer.println("Pigsty owned: " + pigsty.isOwned());
            writer.println("Sheep pen owned: " + sheepPen.isOwned());
            writer.println("Cattle shed owned: " + cattleShed.isOwned());
            writer.println("Stable owned: " + stable.isOwned());
            for (Animal animal : animals) {
                writer.println(animal.getClass().getSimpleName() + " status: " + animal.getStatus(filepath));
            }
            System.out.println("Game saved successfully.\n");
        } catch (IOException e) {
            System.out.println("Error saving the game.\n");
        }
    }

    public void loadGame(String filepath) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filepath));
            String line = reader.readLine();
            while (line != null) {
                if (line.startsWith("Coin number:")) {
                    String[] parts = line.split("Coin number:");
                    int newCoin = Integer.parseInt(parts[1]);
                    coin = newCoin;
                }
                if (line.startsWith("Pigsty owned:")) {
                    String[] parts = line.split("Pigsty owned: ");
                    boolean pigstyStatus = Boolean.parseBoolean(parts[1]);
                    pigsty.setOwned(pigstyStatus);
                }
                if (line.startsWith("Sheep pen owned:")) {
                    String[] parts = line.split("Sheep pen owned: ");
                    boolean SheepPenStatus = Boolean.parseBoolean(parts[1]);
                    sheepPen.setOwned(SheepPenStatus);
                }
                if (line.startsWith("Cattle shed owned:")) {
                    String[] parts = line.split("Cattle shed owned: ");
                    boolean cattleShedStatus = Boolean.parseBoolean(parts[1]);
                    cattleShed.setOwned(cattleShedStatus);
                }
                if (line.startsWith("Stable owned:")) {
                    String[] parts = line.split("Stable owned: ");
                    boolean stableStatus = Boolean.parseBoolean(parts[1]);
                    stable.setOwned(stableStatus);
                }
                String[] parts = line.split(" status: ");
                if (parts.length == 2) {
                    String animal = parts[0];
                    String status = parts[1];
                    Animal newAnimal = createAnimal(animal);
                    newAnimal.setStatus(status);
                    animals.add(newAnimal);
                }
            }
            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("Error reading file");
        }
    }

    private Animal createAnimal(String animalType) {
        switch (animalType) {
            case "chicken":
                return new chicken();
            case "pig":
                return new pig();
            case "sheep":
                return new sheep();
            case "cattle":
                return new cattle();
            case "horse":
                return new horse();
            default:
                System.out.println("Unknown animal type: " + animalType);
                return null;
        }
    }

    public void loadInstruction() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("src/animalfarm/instruction.txt"));
            String line = reader.readLine();
            while (line != null) {
                System.out.println(line);
                line = reader.readLine();
            }
            reader.close();

        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("Error reading file");
        }
    }

    public void addHungryChicken() {
        Animal chicken = new chicken();
        animals.add(chicken);
        hungryChickenNumber++;
        coin = getCoin() - chicken.cost;
    }

    public void addHungryPig() {
        Animal pig = new pig();
        animals.add(pig);
        hungryPigNumber++;
        coin = getCoin() - pig.cost;
    }

    public void addHungrySheep() {
        Animal sheep = new sheep();
        animals.add(sheep);
        hungrySheepNumber++;
        coin = getCoin() - sheep.cost;

    }

    public void addHungryHorse() {
        Animal horse = new horse();
        animals.add(horse);
        hungryHorseNumber++;
        coin = getCoin() - horse.cost;

    }

    public void addHungryCattle() {
        Animal cattle = new cattle();
        animals.add(cattle);
        hungryCattleNumber++;
        coin = getCoin() - cattle.cost;
    }

    public void addFullChicken() {
        fullChickenNumber++;
        hungryChickenNumber--;
    }

    public void addFullPig() {
        fullPigNumber++;
        hungryPigNumber--;
    }

    public void addFullSheep() {
        hungrySheepNumber--;
        fullSheepNumber++;
    }

    public void addFullHorse() {
        fullHorseNumber++;
        hungryHorseNumber--;
    }

    public void addFullCattle() {
        hungryCattleNumber--;
        fullCattleNumber++;
    }

    public void addPigsty() {
        pigsty.isOwned();
        coin = coin - pigsty.buildingCost;
    }

    public void addSheeppen() {
        sheepPen.isOwned();
        coin = coin - sheepPen.buildingCost;
    }

    public void addStable() {
        stable.isOwned();
        coin = coin - stable.buildingCost;
    }

    public void addCattleshed() {
        cattleShed.isOwned();
        coin = coin - cattleShed.buildingCost;
    }

    public void sellChicken() {
        fullChickenNumber--;
        coin = getCoin() + 2;
    }

    public void sellPig() {
        fullPigNumber--;
        coin = getCoin() + 4;
    }

    public void sellSheep() {
        fullSheepNumber--;
        coin = getCoin() + 4;
    }

    public void sellHorse() {
        fullHorseNumber--;
        coin = getCoin() + 6;
    }

    public void sellCattle() {
        fullCattleNumber--;
        coin = getCoin() + 6;
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

    /**
     * @return the hungryChickenNumber
     */
    public int getHungryChickenNumber() {
        return hungryChickenNumber;
    }

    /**
     * @return the hungryPigNumber
     */
    public int getHungryPigNumber() {
        return hungryPigNumber;
    }

    /**
     * @return the hungrySheepNumber
     */
    public int getHungrySheepNumber() {
        return hungrySheepNumber;
    }

    /**
     * @return the hungryHorseNumber
     */
    public int getHungryHorseNumber() {
        return hungryHorseNumber;
    }

    /**
     * @return the hungryCattleNumber
     */
    public int getHungryCattleNumber() {
        return hungryCattleNumber;
    }

    /**
     * @return the fullChickenNumber
     */
    public int getFullChickenNumber() {
        return fullChickenNumber;
    }

    /**
     * @return the fullPigNumber
     */
    public int getFullPigNumber() {
        return fullPigNumber;
    }

    /**
     * @return the fullSheepNumber
     */
    public int getFullSheepNumber() {
        return fullSheepNumber;
    }

    /**
     * @return the fullHorseNumber
     */
    public int getFullHorseNumber() {
        return fullHorseNumber;
    }

    /**
     * @return the fullCattleNumber
     */
    public int getFullCattleNumber() {
        return fullCattleNumber;
    }
}
