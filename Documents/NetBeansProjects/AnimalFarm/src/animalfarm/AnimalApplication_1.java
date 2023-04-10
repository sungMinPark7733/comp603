
package animalfarm;

import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author park6
 */
public class AnimalApplication_1 {

    public static void main(String[] args) throws IOException {
        AnimalList animals = new AnimalList();
        Scanner scanner = new Scanner(System.in);
        String filePath = "C:\\Users\\park6\\Documents\\NetBeansProjects\\AnimalFarm\\src\\animalfarm\\savedFile.txt";

        boolean run = true;
        while (run) {
            System.out.println("Please choose one of the followings:\n"
                    + "1. New animal\n"
                    + "2. Show animal\n"
                    + "3. Feed animal\n"
                    + "4. Sell animal\n"
                    + "5. Show Coin\n"
                    + "6. Upgrade farm\n"
                    + "7. Show buildings\n"
                    + "8. Save game\n"
                    + "9. Load game\n"
                    + "10. Instructions\n"
                    + "11. Quit\n");
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
                    animals.showCoin();
                    break;
                case 6:
                    animals.buyBuildings();
                    break;
                case 7:
                    animals.showBuilding();
                    break;
                case 8:
                    animals.saveGame();
                    break;
                case 9:
                    animals.loadGame();
                    break;
                case 10:
                    animals.loadInstruction();
                    break;
                case 11:
                    run = false;
                    System.out.println("Quitting the game...");
                    break;
                default:
                    System.out.println("Please enter valid number\n");
                    break;
            }
        }
    }
}
