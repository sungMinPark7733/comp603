package animalfarm;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {

    Data data = new Data();
    Option option = new Option();
    Scanner scanner = new Scanner(System.in);
    boolean run = true;
    String filepath = "src/animalfarm/savedFile.txt";

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
                        data.loadGame(filepath);
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
                    option.buyAnimal();
                    break;
                case 2:

                    option.showAnimal();
                    break;
                case 3:

                    option.feedAnimal();
                    break;
                case 4:

                    option.sellAnimal();
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
                    option.showCoin();
                    break;
                case 3:
                    option.buyBuildings();
                    break;
                case 4:
                    option.showBuilding();
                    break;
                case 5:
                    data.saveGame(filepath);
                    break;
                case 6:
                    data.loadInstruction();
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
}
