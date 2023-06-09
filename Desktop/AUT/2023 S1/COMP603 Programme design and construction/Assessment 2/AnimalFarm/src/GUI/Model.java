package GUI;

import java.util.ArrayList;
import java.util.Observable;

public class Model extends Observable {

    public String username;
    private Database db;
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
        this.data = new Data();
        this.animals = new ArrayList<>();
    }

// reset the game data
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
        this.animals = new ArrayList<>();
    }

//    check username
    public void checkName(String username, String password) {
        this.username = username;
        this.data = this.db.checkName(username, password);
        this.coin = this.data.coin; // Update the coin value in the Model class
        this.setChanged();
        this.notifyObservers(this.data);
    }

//  save the gaem data using database
    public void saveGame() {
        this.db.saveGame(this.coin, this.username);
        this.data.coin = this.coin; // Update the coin value in the Model class
        this.setChanged();
        this.notifyObservers(this.data);
    }

//    add hungry chicken and dedudct coin
    public void addHungryChicken() {
        Animal chicken = new chicken();
        animals.add(chicken);
        hungryChickenNumber++;
        setCoin(getCoin() - chicken.cost);
    }

    //    add hungry pig and dedudct coin
    public void addHungryPig() {
        Animal pig = new pig();
        animals.add(pig);
        hungryPigNumber++;
        setCoin(getCoin() - pig.cost);
    }

//    add hungry sheep and dedudct coin
    public void addHungrySheep() {
        Animal sheep = new sheep();
        animals.add(sheep);
        hungrySheepNumber++;
        setCoin(getCoin() - sheep.cost);
    }

    //    add hungry hosre and dedudct coin
    public void addHungryHorse() {
        Animal horse = new horse();
        animals.add(horse);
        hungryHorseNumber++;
        setCoin(getCoin() - horse.cost);

    }

//    add hungry cattle and dedudct coin
    public void addHungryCattle() {
        Animal cattle = new cattle();
        animals.add(cattle);
        hungryCattleNumber++;
        setCoin(getCoin() - cattle.cost);
    }

//    add full chicken and dedudct number of hungry chicken
    public void addFullChicken() {
        fullChickenNumber++;
        hungryChickenNumber--;
    }

    //    add full pig and dedudct number of hungry pig
    public void addFullPig() {
        fullPigNumber++;
        hungryPigNumber--;
    }

//    add full chicken and sheep number of hungry sheep
    public void addFullSheep() {
        hungrySheepNumber--;
        fullSheepNumber++;
    }

//    add full horse and dedudct number of hungry horse
    public void addFullHorse() {
        fullHorseNumber++;
        hungryHorseNumber--;
    }

    //    add full cattle and dedudct number of hungry cattle
    public void addFullCattle() {
        hungryCattleNumber--;
        fullCattleNumber++;
    }

//    add pigsty and change it's status to owned
    public void addPigsty() {
        pigsty.owned = true;
        setCoin(coin - pigsty.buildingCost);
    }

    //    add sheeppen and change it's status to owned
    public void addSheeppen() {
        sheepPen.owned = true;
        setCoin(coin - sheepPen.buildingCost);
    }

    //    add stable and change it's status to owned
    public void addStable() {
        stable.owned = true;
        setCoin(coin - stable.buildingCost);
    }

    //    add cattleshed and change it's status to owned
    public void addCattleshed() {
        cattleShed.owned = true;
        setCoin(coin - cattleShed.buildingCost);
    }

    //    sell chicken and add coin
    public void sellChicken() {
        fullChickenNumber--;
        setCoin(getCoin() + 2);
    }

    //    sell pig and add coin
    public void sellPig() {
        fullPigNumber--;
        setCoin(getCoin() + 4);
    }

    //    sell sheep and add coin
    public void sellSheep() {
        fullSheepNumber--;
        setCoin(getCoin() + 4);
    }

    //    sell horse and add coin
    public void sellHorse() {
        fullHorseNumber--;
        setCoin(getCoin() + 6);
    }

    //    sell cattle and add coin
    public void sellCattle() {
        fullCattleNumber--;
        setCoin(getCoin() + 6);
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

    /**
     * @param coin the coin to set
     */
    public void setCoin(int coin) {
        this.coin = coin;
    }

    /**
     * @return the db
     */
    public Database getDb() {
        return db;
    }

}
