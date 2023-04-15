package animalfarm;

import java.util.InputMismatchException;
import java.util.Scanner;

public class AnimalApplication {

    AnimalList animals = new AnimalList();
    Scanner scanner = new Scanner(System.in);
    boolean run = true;

    public void gameStart() {
        boolean validInput = false;
        while (!validInput) {
            try {
                System.out.println("Please choose one of the followings:\n"
                        + "1. New game\n"
                        + "2. Load Game"
                );
                int selection = scanner.nextInt();
                switch (selection) {
                    case 1:
                        application();
                        validInput = true;
                        break;
                    case 2:
                        animals.loadGame();
                        application();
                        validInput = true;
                        break;
                    default:
                        System.out.println("Please enter valid number\n");
                        break;

                }
            } catch (InputMismatchException i) {
                System.out.println("Please enter valid input");
                scanner.nextLine();
            }
        }
    }

    public void manageAnimal() {
        boolean validInput = false;
        while (!validInput) {
            try {
                System.out.println("\nPlease choose one of the followings:\n"
                        + "1. New animal\n"
                        + "2. Show animal\n"
                        + "3. Feed animal\n"
                        + "4. Sell animal\n"
                        + "5. Cancel\n"
                );
                int selection = scanner.nextInt();
                switch (selection) {
                    case 1:
                        animals.buyAnimal();
                        validInput = true; 
                        break;
                    case 2:
                        animals.showAnimal();
                        validInput = true; 
                        break;
                    case 3:
                        animals.feedAnimal();
                        validInput = true; 
                        break;
                    case 4:
                        animals.sellAnimal();
                        validInput = true; 
                        break;
                    case 5:
                        validInput = true; 
                        break;
                    default:
                        System.out.println("Please enter valid number\n");
                        break;
                }
            } catch (InputMismatchException i) {
                System.out.println("Please enter valid input");
                scanner.nextLine(); 
            }
        }
    }

    public void application() {
        boolean validInput = false;
        while (run && !validInput) {
            try {
                System.out.println("\n---------------------------------------------------------\n"
                        + "Please choose one of the followings:\n"
                        + "1. Manage animals\n"
                        + "2. Show Coin\n"
                        + "3. Upgrade farm\n"
                        + "4. Show buildings\n"
                        + "5. Save game\n"
                        + "6. Instructions\n"
                        + "7. Quit\n");
                int selection = scanner.nextInt();

                switch (selection) {
                    case 1:
                        manageAnimal();
                        validInput = true; 
                        break;
                    case 2:
                        animals.showCoin();
                        validInput = true; 
                        break;
                    case 3:
                        animals.buyBuildings();
                        validInput = true; 
                        break;
                    case 4:
                        animals.showBuilding();
                        validInput = true; 
                        break;
                    case 5:
                        animals.saveGame();
                        validInput = true;
                        break;
                    case 6:
                        animals.loadInstruction();
                        validInput = true; 
                        break;
                    case 7:
                        run = false;
                        System.out.println("Quitting the game...");
                        validInput = true; 
                        break;
                    default:
                        System.out.println("Please enter valid number\n");
                        break;
                }
            } catch (InputMismatchException i) {
                System.out.println("Please enter valid input");
                scanner.nextLine(); 
            }
        }
    }

    public static void main(String[] args) {
        AnimalApplication animalApplication;
        animalApplication = new AnimalApplication();
        animalApplication.gameStart();
    }

}
