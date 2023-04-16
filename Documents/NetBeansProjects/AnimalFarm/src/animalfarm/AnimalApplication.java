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
            } catch (InputMismatchException e) {
                System.out.println("Please enter a valid input\n");
                scanner.next();   
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Please enter a valid input\n");
            }
        }
    }

    public void manageAnimal() {
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
                    break;
                case 2:

                    animals.showAnimal();
                    break;
                case 3:

                    animals.feedAnimal();
                    break;
                case 4:

                    animals.sellAnimal();
                    break;
                case 5:
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

    public void application() {
        while (run)
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
                    break;
                case 2:
                    animals.showCoin();
                    break;
                case 3:
                    animals.buyBuildings();
                    break;
                case 4:
                    animals.showBuilding();
                    break;
                case 5:
                    animals.saveGame();
                    break;
                case 6:
                    animals.loadInstruction();
                    break;
                case 7:
                    run = false;
                    System.out.println("Quitting the game...");
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

    public static void main(String[] args) {
        AnimalApplication animalApplication;
        animalApplication = new AnimalApplication();
        animalApplication.gameStart();
    }

}
