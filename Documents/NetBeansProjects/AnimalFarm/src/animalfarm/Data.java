
package animalfarm;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Data extends AnimalList{
    
//  This method saves the current state of the AnimalList object to a file. 
//    It uses a FileWriter and PrintWriter to write the data to a file.
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
    
 //    This method loads the AnimalList object from a file. 
//    It uses a FileReader and BufferedReader to read the data from the file and populate the AnimalList object with the data.
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
}
