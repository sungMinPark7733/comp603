package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller implements ActionListener {

    private Model model;
    private View view;

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
        this.view.addActionListener(this); // Add Actionlistener (the instance of this class) to View.
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand(); // Obtain the text displayed on the component.
        switch (command) {
            case "Start Game":
                String username = view.unInput.getText(); // Obtain username.
                String password = view.pwInput.getText(); // Obtain password.  
                model.checkName(username, password);
                view.getCardLayout().show(view.getContainerPanel(), "buttonPanel");
                break;
            case "1. Manage animals":
                view.getCardLayout().show(view.getContainerPanel(), "animalManager");
                break;
            case "2. Show Coin":
                view.getCardLayout().show(view.getContainerPanel(), "showCoin");
                view.getCoinLabel().setText("Current coin: " + String.valueOf(model.getCoin()));
                break;
            case "3. Upgrade farm":
                view.getCardLayout().show(view.getContainerPanel(), "farmUpgrade");
                break;
            case "4. Save game":
                model.saveGame();
                break;
            case "5. Instructions":
                view.getCardLayout().show(view.getContainerPanel(), "loadInstruction");
                break;
            case "5. Quit":
                view.dispose();
                break;
            case "6. Reset":
                model.reset();
                view.getwarningLabel1().setText(" ");
                view.getWarningLabel2().setText(" ");
                view.getWarningLabel2().setText(" ");
                view.getWarningLabel2().setText(" ");
                view.getPigstyownedLabel().setText("Owned: False");
                view.getSheeppenOwnedLabel().setText("owend: False");
                view.getCattleshedOwnedLabel().setText("Owend: False");
                view.getStableOwnedLabel().setText("Owned: False");
                break;
            case "1. New animal":
                view.getCardLayout().show(view.getContainerPanel(), "buyAnimal");
                break;
            case "2. Show animal":
                view.getCardLayout().show(view.getContainerPanel(), "showAnimal");
                break;
            case "3. Feed animal":
                view.getCardLayout().show(view.getContainerPanel(), "feedAnimal");
                break;
            case "4. Sell animal":
                view.getCardLayout().show(view.getContainerPanel(), "sellAnimal");
                break;
            case "5. Cancel":
                view.getCardLayout().show(view.getContainerPanel(), "buttonPanel");
                break;

            case "1. New chicken: 1 coins":
                if (model.getCoin() >= 1) {
                    model.addHungryChicken();
                    view.getHungrychickenNumberLabel().setText("Hungry chicken: " + model.getHungryChickenNumber());
                    view.getwarningLabel1().setText("Remaining coin: " + model.getCoin());

                } else {
                    view.getwarningLabel1().setText("No enough coin");
                }
                break;

            case "2. New Pig: 2 coins":
                if (model.getCoin() >= 2 && model.pigsty.owned == true) {
                    model.addHungryPig();
                    view.getHungrypigNumberLabel().setText("Hungry pig: " + model.getHungryPigNumber());
                    view.getwarningLabel1().setText("Remaining coin: " + model.getCoin());
                } else {
                    view.getwarningLabel1().setText("No enough coin or no required building");
                }
                break;

            case "3. New Sheep: 2 coins":
                if (model.getCoin() >= 2 && model.sheepPen.owned == true) {
                    model.addHungrySheep();
                    view.getHungrysheepNumberLabel().setText("Hungry Sheep: " + model.getHungrySheepNumber());
                    view.getwarningLabel1().setText("Remaining coin: " + model.getCoin());
                } else {
                    view.getwarningLabel1().setText("No enough coin or no required building");
                }
                break;

            case "4. New cattle: 3 coins":
                if (model.getCoin() >= 3 && model.cattleShed.owned == true) {
                    model.addHungryCattle();
                    view.getHungrycattleNumberLabel().setText("Hungry cattle: " + model.getHungryCattleNumber());
                    view.getwarningLabel1().setText("Remaining coin: " + model.getCoin());
                } else {
                    view.getwarningLabel1().setText("No enough coin or no required building");
                }
                break;

            case "5. New horse: 3 coins":
                if (model.getCoin() >= 3 && model.stable.owned == true) {
                    model.addHungryHorse();
                    view.getHungryhorseNumberLabel().setText("Hungry horse: " + model.getHungryHorseNumber());
                    view.getwarningLabel1().setText("Remaining coin: " + model.getCoin());
                } else {
                    view.getwarningLabel1().setText("No enough coin or no required building");
                }
                break;

            case "6. Cancel":
                view.getCardLayout().show(view.getContainerPanel(), "buttonPanel");
                break;

            case "1. Pigsty: 10 coins":
                if (model.getCoin() >= 10 && model.pigsty.owned == false) {
                    model.addPigsty();
                    view.getPigstyownedLabel().setText("Owned: True");
                } else if (model.pigsty.owned == true) {
                    view.getWarningLabel2().setText("Already owned");
                } else {
                    view.getWarningLabel2().setText("No enough coin");
                }
                break;

            case "2. Sheep pen: 10 coins":
                if (model.getCoin() >= 10 && model.sheepPen.owned == false) {
                    model.addSheeppen();
                    view.getSheeppenOwnedLabel().setText("owend: True");
                } else if (model.sheepPen.owned == true) {
                    view.getWarningLabel2().setText("Already owned");
                } else {
                    view.getWarningLabel2().setText("No enough coin");
                }

                break;
            case "3. Cattle shed: 20 coins":
                if (model.getCoin() >= 20 && model.cattleShed.owned == false) {
                    model.addCattleshed();
                    view.getCattleshedOwnedLabel().setText("Owend: True");
                } else if (model.cattleShed.owned == true) {
                    view.getWarningLabel2().setText("Already owned");
                } else {
                    view.getWarningLabel2().setText("No enough coin");
                }

                break;
            case "4. Stable: 20 coins":
                if (model.getCoin() >= 20 && model.stable.owned == false) {
                    model.addStable();
                    view.getStableOwnedLabel().setText("Owned: True");
                } else if (model.stable.owned == true) {
                    view.getWarningLabel2().setText("Already owned");
                } else {
                    view.getWarningLabel2().setText("No enough coin");
                }

                break;
            case "Cancel":
                view.getCardLayout().show(view.getContainerPanel(), "buttonPanel");
                break;
            case "Feed chicken":
                boolean containsChicken = false;
                for (Animal animal : model.getAnimals()) {
                    if (animal instanceof chicken) {
                        containsChicken = true;
                        break;
                    }
                }
                if (model.getHungryChickenNumber() >= 1) {
                    if (containsChicken) {
                        model.addFullChicken();
                        view.getFullchickenNumberLabel().setText("Full chicken: " + model.getFullChickenNumber());
                        view.getHungrychickenNumberLabel().setText("Hungry chicken: " + model.getHungryChickenNumber());
                        view.getWarningLabel3().setText("Remaining hungry chicken: " + model.getHungryChickenNumber());
                    }
                } else {
                    view.getWarningLabel3().setText("No hungry chicken");
                }

                break;

            case "Feed pig":
                boolean containsPig = false;
                for (Animal animal : model.getAnimals()) {
                    if (animal instanceof pig) {
                        containsPig = true;
                        break;
                    }
                }
                if (model.getHungryPigNumber() >= 1) {
                    if (containsPig) {
                        model.addFullPig();
                        view.getFullpigNumberLabel().setText("Full pig: " + model.getFullPigNumber());
                        view.getHungrypigNumberLabel().setText("Hungry pig: " + model.getHungryPigNumber());
                        view.getWarningLabel3().setText("Remaining hungry pig: " + model.getHungryPigNumber());
                    }
                } else {
                    view.getWarningLabel3().setText("No hungry pig");
                }
                break;

            case "Feed sheep":
                boolean containsSheep = false;
                for (Animal animal : model.getAnimals()) {
                    if (animal instanceof sheep) {
                        containsPig = true;
                        break;
                    }
                }
                if (model.getHungrySheepNumber() >= 1) {
                    if (containsSheep) {
                        model.addFullSheep();
                        view.getFullsheepNumberLabel().setText("Full sheep: " + model.getFullSheepNumber());
                        view.getHungrysheepNumberLabel().setText("Hungry Sheep: " + model.getHungrySheepNumber());
                        view.getWarningLabel3().setText("Remaining hungry sheep: " + model.getHungrySheepNumber());
                    }
                } else {
                    view.getWarningLabel3().setText("No hungry sheep");
                }
                break;

            case "Feed horse":
                boolean containsHorse = false;
                for (Animal animal : model.getAnimals()) {
                    if (animal instanceof horse) {
                        containsHorse = true;
                        break;
                    }
                }
                if (model.getHungryHorseNumber() >= 1) {
                    if (containsHorse) {
                        model.addFullHorse();
                        view.getFullhorseNumberLabel().setText("Full horse: " + model.getFullHorseNumber());
                        view.getHungryhorseNumberLabel().setText("Hungry horse: " + model.getHungryHorseNumber());
                        view.getWarningLabel3().setText("Remaining hungry horse: " + model.getHungryHorseNumber());
                    }
                } else {
                    view.getWarningLabel3().setText("No hungry horse");
                }

                break;

            case "Feed cattle":
                boolean containsCattle = false;
                for (Animal animal : model.getAnimals()) {
                    if (animal instanceof horse) {
                        containsCattle = true;
                        break;
                    }
                }
                if (model.getHungryCattleNumber() >= 1) {
                    if (containsCattle) {
                        model.addFullCattle();
                        view.getFullcattleNumberLabel().setText("Full cattle: " + model.getFullCattleNumber());
                        view.getHungrycattleNumberLabel().setText("Hungry cattle: " + model.getHungryCattleNumber());
                        view.getWarningLabel3().setText("Remaining hungry cattle: " + model.getHungryCattleNumber());
                    }
                } else {
                    view.getWarningLabel3().setText("No hungry cattle");
                }
                break;
            case "Sell chicken":
                if (model.getFullChickenNumber() >= 1) {
                    model.sellChicken();
                    view.getFullchickenNumberLabel().setText("Full chicken: " + model.getFullChickenNumber());
                    view.getHungrychickenNumberLabel().setText("Hungry chicken: " + model.getHungryChickenNumber());
                    view.getWarningLabel4().setText("Remaining full chicken: " + model.getFullChickenNumber());
                } else {
                    view.getWarningLabel4().setText("No full chicken");
                }
                break;
            case "Sell pig":
                if (model.getFullPigNumber() >= 1) {
                    model.sellPig();
                    view.getFullpigNumberLabel().setText("Full pig: " + model.getFullPigNumber());
                    view.getHungrypigNumberLabel().setText("Hungry pig: " + model.getHungryPigNumber());
                    view.getWarningLabel4().setText("Remaining full pig: " + model.getFullPigNumber());
                } else {
                    view.getWarningLabel4().setText("No full pig");
                }
                break;
            case "Sell sheep":
                if (model.getFullSheepNumber() >= 1) {
                    model.sellSheep();
                    view.getFullsheepNumberLabel().setText("Full sheep: " + model.getFullSheepNumber());
                    view.getHungrysheepNumberLabel().setText("Hungry Sheep: " + model.getHungrySheepNumber());
                    view.getWarningLabel4().setText("Remaining full sheep: " + model.getFullSheepNumber());
                } else {
                    view.getWarningLabel4().setText("No full sheep");
                }
                break;
            case "Sell horse":
                if (model.getFullHorseNumber() >= 1) {
                    model.sellHorse();
                    view.getFullhorseNumberLabel().setText("Full horse: " + model.getFullHorseNumber());
                    view.getHungryhorseNumberLabel().setText("Hungry horse: " + model.getHungryHorseNumber());
                    view.getWarningLabel4().setText("Remaining full horse: " + model.getFullHorseNumber());
                } else {
                    view.getWarningLabel4().setText("No full horse");
                }
                break;
            case "Sell cattle":
                if (model.getFullCattleNumber() >= 1) {
                    model.sellCattle();
                    view.getFullcattleNumberLabel().setText("Full cattle: " + model.getFullCattleNumber());
                    view.getHungrycattleNumberLabel().setText("Hungry cattle: " + model.getHungryCattleNumber());
                    view.getWarningLabel4().setText("Remaining full cattle: " + model.getFullCattleNumber());
                } else {
                    view.getWarningLabel4().setText("No full cattle");
                }
                break;
        }
    }
}
