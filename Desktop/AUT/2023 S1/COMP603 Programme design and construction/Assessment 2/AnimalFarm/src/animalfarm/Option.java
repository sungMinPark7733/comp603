package animalfarm;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Option extends AnimalList {

    Scanner scanner = new Scanner(System.in);

    //This method displays the current number of coins
    public void showCoin() {
        System.out.println("You have " + coin + " coin");
    }

//This method displays the list of animals the player has along with their status
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

//This method allows the player to buy a new animal. 
//It deducts the cost of the animal from the player's coins and adds the animal to the list of owned animals. 
//It also checks if the player owns the required building (e.g., pigsty, sheepPen) before allowing the purchase of certain animals.
    public void buyAnimal() {
        try {
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
                    Animal chicken = new chicken();
                    if (chicken.getCost() > coin) {
                        System.out.println("You don't have enough coins to buy this animal.\n");
                    } else {
                        coin -= chicken.getCost();
                        System.out.println("You bought an animal! Your remaining coins:\n " + coin + "\n");
                        animals.add(chicken);
                    }
                    break;
                case 2:
                    Animal pig = new pig();
                    if (pig.getCost() > coin) {
                        System.out.println("You don't have enough coins to buy this animal\n");
                    } else if (pigsty.isOwned() == false) {
                        System.out.println("You don't own pigsty! Build pigsty first to buy pig!");
                    } else {
                        coin -= pig.getCost();
                        System.out.println("You bought an animal! Your remaining coins:\n " + coin + "\n");
                        animals.add(pig);
                    }
                    break;
                case 3:
                    Animal sheep = new sheep();
                    if (sheep.getCost() > coin) {
                        System.out.println("You don't have enough coins to buy this animal\n");
                    } else if (sheepPen.isOwned() == false) {
                        System.out.println("You don't own sheepPen! Build sheepPen first to buy sheep!");
                    } else {
                        coin -= sheep.getCost();
                        System.out.println("You bought an animal! Your remaining coins:\n " + coin + "\n");
                        animals.add(sheep);
                    }
                    break;
                case 4:
                    Animal cattle = new cattle();
                    if (cattle.getCost() > coin) {
                        System.out.println("You don't have enough coins to buy this animal\n");
                    } else if (cattleShed.isOwned() == false) {
                        System.out.println("You don't own cattleShed! Build cattleShed first to buy cattle!");
                    } else {
                        coin -= cattle.getCost();
                        System.out.println("You bought an animal! Your remaining coins:\n " + coin + "\n");
                        animals.add(cattle);
                    }
                    break;
                case 5:
                    Animal horse = new horse();
                    if (horse.getCost() > coin) {
                        System.out.println("You don't have enough coins to buy this animal\n");
                    } else if (stable.isOwned() == false) {
                        System.out.println("You don't own stable! Build stable first to buy horse!");
                    } else {
                        coin -= horse.getCost();
                        System.out.println("You bought an animal! Your remaining coins:\n " + coin + "\n");
                        animals.add(horse);
                    }
                    break;
                case 6:
                    System.out.println("Cancelled");
                    break;

                default:
                    System.out.println("Please enter valid number\n");
                    break;
            }
        } catch (InputMismatchException e) {
            System.out.println("Please enter a valid input\n");
            scanner.next();
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Please enter a valid input\n");
        }
    }

//    This method allows the player to feed an animal from their list of owned animals. It displays the list of animals and prompts the player to choose an animal to feed. 
//    If the chosen animal's status is not full, it calls the feed() method on the animal object, updating its status.
    public void feedAnimal() {
        try {
            int count = animals.size();
            if (animals.isEmpty()) {
                System.out.println("There are no animals.\n");
            } else {
                System.out.println("Choose an animal to feed:");
                for (int i = 0; i < count; i++) {
                    System.out.println((i + 1) + ". " + animals.get(i));
                }
                System.out.println((animals.size() + 1) + ". Cancel");

                int choice = scanner.nextInt();
                if (choice <= animals.size()) {
                    Animal selectedAnimal = animals.get(choice - 1);
                    if (selectedAnimal.getStatus().equalsIgnoreCase("Full")) {
                        System.out.println("This animal is already full!\n");
                    } else {
                        selectedAnimal.feed();
                        System.out.println("You fed the " + selectedAnimal.getClass().getSimpleName() + "!\n");
                    }
                } else if (choice == animals.size() + 1) {
                    System.out.println("Cancelled\n");
                } else {
                    System.out.println("Please enter a valid number.\n");
                }
            }
        } catch (InputMismatchException e) {
            System.out.println("Please enter a valid input\n");
            scanner.next();
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Please enter a valid input\n");
        }
    }

//  This method allows the player to sell an animal from their list of owned animals. It displays the list of animals and prompts the player to choose an animal to sell. 
//  It then removes the chosen animal from the list of owned animals and adds the animal's value to the player's coins.
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
                    System.out.println("Cancelled\n");
                } else {
                    Animal selectedAnimal = animals.get(choice - 1);

                    if (selectedAnimal.getStatus().equalsIgnoreCase("full")) {
                        if (selectedAnimal instanceof chicken) {
                            coin += 2;
                        }
                        if (selectedAnimal instanceof pig || selectedAnimal instanceof sheep) {
                            coin += 4;
                        }
                        if (selectedAnimal instanceof cattle || selectedAnimal instanceof horse) {
                            coin += 6;
                        }
                        System.out.println("Sold " + selectedAnimal.getClass().getSimpleName() + ". You have " + coin + " coin(s)\n");
                        animals.remove(selectedAnimal);
                    } else {
                        System.out.println(selectedAnimal.getClass().getSimpleName() + " is not full and cannot be sold\n");
                    }
                }
            }
        } catch (InputMismatchException e) {
            System.out.println("Please enter a valid input\n");
            scanner.next();
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Please enter a valid input\n");
        }
    }

//  This method allows the player to build a new building based on their choice. 
//  It deducts the cost of the building from the player's coins and sets the corresponding building object as owned.
    public void buyBuildings() {
        try {
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
                    System.out.println("Cancelled");
                    break;

                default:
                    System.out.println("Please enter a valid input\n");
            }
        } catch (InputMismatchException e) {
            System.out.println("Please enter a valid input\n");
            scanner.next();
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Please enter a valid input\n");
        }
    }

//  This method displays the list of buildings the player owns
    public void showBuilding() {
        System.out.println(pigsty.toString());
        System.out.println(sheepPen.toString());
        System.out.println(cattleShed.toString());
        System.out.println(stable.toString());
    }
}
