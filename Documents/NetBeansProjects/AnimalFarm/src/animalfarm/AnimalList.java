package animalfarm;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author park6
 */
public class AnimalList {

    private ArrayList<Animal> animals;
    private int coin = 1;
    Scanner scanner = new Scanner(System.in);
    Building pigsty = new pigsty(false);
    Building sheepPen = new sheepPen(false);
    Building cattleShed = new cattleShed(false);
    Building stable = new stable(false);

    public AnimalList() {
        this.animals = new ArrayList<>();
    }
//This method displays the current number of coins the player has

    public void showCoin() {
        System.out.println("You have " + coin + " coin");
    }
//This method displays the list of animals the player owns, along with their respective indices

    public void showAnimal() {
        if (animals.isEmpty()) {
            System.out.println("There is no animals");
        } else {
            int count = animals.size();
            for (int i = 0; i < count; i++) {
                System.out.println((i + 1) + ". " + animals.get(i));
            }
        }
    }
//This method allows the player to buy a new animal based on their choice. 
//It deducts the cost of the animal from the player's coins and adds the animal to the list of owned animals. 
//It also checks if the player owns the required building (e.g., pigsty, sheepPen) before allowing the purchase of certain animals.

    public void buyAnimal() {
        System.out.println("Please choose which animal to buy:\n"
                + "1. New chicken: 1 coins\n"
                + "2. New Pig: 2 coins\n"
                + "3. New Sheep: 2 coins\n"
                + "4. New cattle: 3 coins\n"
                + "5. New horse: 3 coins\n"
                + "6. Cancel\n");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                Animal chicken = new chicken(null);
                if (chicken.cost > coin) {
                    System.out.println("You don't have enough coins to buy this animal.\n");
                } else {
                    coin -= chicken.cost;
                    System.out.println("You bought an animal! Your remaining coins:\n " + coin + "\n");
                    animals.add(chicken);
                }
                break;
            case 2:
                Animal pig = new pig(null);
                if (pig.cost > coin) {
                    System.out.println("You don't have enough coins to buy this animal\n");
                } else if (pigsty.isOwned() == false) {
                    System.out.println("You don't own pigsty! Build pigsty first to buy pig!");
                } else {
                    coin -= pig.cost;
                    System.out.println("You bought an animal! Your remaining coins:\n " + coin + "\n");
                    animals.add(pig);
                }
                break;
            case 3:
                Animal sheep = new sheep(null);
                if (sheep.cost > coin) {
                    System.out.println("You don't have enough coins to buy this animal\n");
                } else if (sheepPen.isOwned() == false) {
                    System.out.println("You don't own sheepPen! Build sheepPen first to buy sheep!");
                } else {
                    coin -= sheep.cost;
                    System.out.println("You bought an animal! Your remaining coins:\n " + coin + "\n");
                    animals.add(sheep);
                }
                break;
            case 4:
                Animal cattle = new cattle(null);
                if (cattle.cost > coin) {
                    System.out.println("You don't have enough coins to buy this animal\n");
                } else if (cattleShed.isOwned() == false) {
                    System.out.println("You don't own cattleShed! Build cattleShed first to buy cattle!");
                } else {
                    coin -= cattle.cost;
                    System.out.println("You bought an animal! Your remaining coins:\n " + coin + "\n");
                    animals.add(cattle);
                }
                break;
            case 5:
                Animal horse = new horse(null);
                if (horse.cost > coin) {
                    System.out.println("You don't have enough coins to buy this animal\n");
                } else if (stable.isOwned() == false) {
                    System.out.println("You don't own stable! Build stable first to buy horse!");
                } else {
                    coin -= horse.cost;
                    System.out.println("You bought an animal! Your remaining coins:\n " + coin + "\n");
                    animals.add(horse);
                }
                break;
            case 6:
                break;

            default:
                System.out.println("Please enter valid number\n");
                break;
        }
    }
//This method allows the player to feed an animal from their list of owned animals. It displays the list of animals and prompts the player to choose an animal to feed. If the chosen animal is not already at full status, it calls the feed() method on the animal object, updating its status.

    public void feedAnimal() {
        try {
            int count = animals.size();
            if (animals.isEmpty()) {
                System.out.println("There is no animals.\n");
            } else {
                System.out.println("Choose an animal to feed:");
                for (int i = 0; i < count; i++) {
                    System.out.println((i + 1) + ". " + animals.get(i));
                }
                System.out.println(animals.size() + 1 + ". Cancel");

                int choice = scanner.nextInt();
                if (choice - 1 <= animals.size()) {
                    Animal selectedAnimal = animals.get(choice - 1);
                    if (selectedAnimal.status.equalsIgnoreCase("Full")) {
                        System.out.println("This animal is already full!\n");
                    } else {
                        selectedAnimal.feed();
                        System.out.println("You fed the " + selectedAnimal.getClass().getSimpleName() + "!\n");
                    }
                } else {
                    System.out.println("Please enter a valid number.\n");
                }
            }
        } catch (IndexOutOfBoundsException | InputMismatchException e) {

        }
    }
//This method allows the player to sell an animal from their list of owned animals. It displays the list of animals and prompts the player to choose an animal to sell. It then removes the chosen animal from the list of owned animals and adds the animal's value to the player's coins.

    public void sellAnimal() {
        try {
            int count = animals.size();
            if (animals.isEmpty()) {
                System.out.println("There are no animals.\n");
            } else {
                System.out.println("Choose an animal to sell:");
                for (int i = 0; i < count; i++) {
                    System.out.println((i + 1) + ". " + animals.get(i));
                }
                System.out.println((count + 1) + ". Cancel");

                int choice = scanner.nextInt();

                if (choice == (count + 1)) {
                    System.out.println();
                } else {
                    Animal selectedAnimal = animals.get(choice - 1);

                    if (selectedAnimal.status.equalsIgnoreCase("full")) {
                        int coin = 0;
                        if (selectedAnimal instanceof chicken) {
                            coin += 2;
                        }
                        if (selectedAnimal instanceof pig || selectedAnimal instanceof sheep) {
                            coin += 4;
                        }
                        if (selectedAnimal instanceof cattle || selectedAnimal instanceof horse) {
                            coin += 6;
                        }
                        System.out.println("Sold " + selectedAnimal.getClass().getSimpleName() + " for " + coin + " coin\n"
                                + "You have " + coin + " coin(s)\n");
                        animals.remove(selectedAnimal);
                    } else {
                        System.out.println(selectedAnimal.getClass().getSimpleName() + " is not full and cannot be sold\n");
                    }
                }
            }
        } catch (IndexOutOfBoundsException | InputMismatchException e) {
            System.out.println("Please enter a valid input\n");
        }
    }

    //This method allows the player to build a new building based on their choice. It deducts the cost of the building from the player's coins and sets the corresponding building object as owned.
    public void buyBuildings() {
        System.out.println("Choose which building to buy:\n"
                + "1. Pigsty: 10 coins\n"
                + "2. Sheep pen: 10 coins\n"
                + "3. Cattle shed: 20 coins\n"
                + "4. Stable: 20 coins\n"
                + "5. Cancel\n"
        );
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                if (pigsty.buildingCost > coin) {
                    System.out.println("You don't have enough coins to construct this building\n");
                } else if (pigsty.isOwned() == true) {
                    System.out.println("You already own a pigsty!");
                } else {
                    coin -= pigsty.buildingCost;
                    System.out.println("You constructed a pigsty! Now you can buy pig! Your remaining coins:\n " + coin + "\n");
                    pigsty.purchsed();
                }
                break;
            case 2:
                if (sheepPen.buildingCost > coin) {
                    System.out.println("You don't have enough coins to construct this building\n");
                } else if (sheepPen.isOwned() == true) {
                    System.out.println("You already own a sheepPen!");
                } else {
                    coin -= sheepPen.buildingCost;
                    System.out.println("You constructed a sheepPen! Now you can buy sheep! Your remaining coins:\n " + coin + "\n");
                    sheepPen.purchsed();
                }
                break;
            case 3:
                if (cattleShed.buildingCost > coin) {
                    System.out.println("You don't have enough coins to construct this building\n");
                } else if (cattleShed.isOwned() == true) {
                    System.out.println("You already own a cattleShed!");
                } else {
                    coin -= cattleShed.buildingCost;
                    System.out.println("You constructed a cattleShed! Now you can buy cattle! Your remaining coins:\n " + coin + "\n");
                    cattleShed.purchsed();
                }
                break;
            case 4:
                if (stable.buildingCost > coin) {
                    System.out.println("You don't have enough coins to construct this building\n");
                } else if (stable.isOwned() == true) {
                    System.out.println("You already own a stable!");
                } else {
                    coin -= stable.buildingCost;
                    System.out.println("You constructed a stable! Now you can buy horse! Your remaining coins:\n " + coin + "\n");
                    stable.purchsed();
                }
                break;
            case 5:
                break;
            default:
                System.out.println("Please enter a valid input\n");
        }
    }

//This method displays the list of buildings the player owns, along with their respective statuses (owned or not owned).
    public void showBuilding() {
        System.out.println(pigsty.toString());
        System.out.println(sheepPen.toString());
        System.out.println(cattleShed.toString());
        System.out.println(stable.toString());
    }
//This method saves the current state of the AnimalList object to a file. It uses a FileWriter and PrintWriter to write the data to a file in a formatted manner.

    public void saveGame() {
        try (PrintWriter writer = new PrintWriter(new FileWriter("C:\\Users\\park6\\Documents\\NetBeansProjects\\AnimalFarm\\src\\animalfarm\\savedFile.txt"))) {
            writer.println("Coin number:" + coin);
            writer.println("Pigsty owned: " + pigsty.isOwned());
            writer.println("Sheep pen owned: " + sheepPen.isOwned());
            writer.println("Cattle shed owned: " + cattleShed.isOwned());
            writer.println("Stable owned: " + stable.isOwned());
            for (Animal animal : animals) {
                writer.println(animal.getClass().getSimpleName() + " status: " + animal.getStatus("C:\\Users\\park6\\Documents\\NetBeansProjects\\AnimalFarm\\src\\animalfarm\\savedFile.txt"));
            }
            System.out.println("Game saved successfully.\n");
        } catch (IOException e) {
            System.out.println("Error saving the game.\n");
        }
    }
// This method loads the state of the AnimalList object from a file. It uses a FileReader and BufferedReader to read the data from the file and populate the AnimalList object with the data.

    public void loadGame() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\park6\\Documents\\NetBeansProjects\\AnimalFarm\\src\\animalfarm\\savedFile.txt"));
            String line = reader.readLine();
            while (line != null) {
                if (line.startsWith("Coin number:")) {
                    String[] parts = line.split("Coin number: ");
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
                line = reader.readLine();
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
                return new chicken(null);
            case "pig":
                return new pig(null);
            case "sheep":
                return new sheep(null);
            case "cattle":
                return new cattle(null);
            case "horse":
                return new horse(null);
            default:
                System.out.println("Unknown animal type: " + animalType);
                return null;
        }
    }

    public void loadInstruction() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\park6\\Documents\\NetBeansProjects\\AnimalFarm\\src\\animalfarm\\instruction"));
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
}
