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
            case "Load Game":
                view.getCardLayout().show(view.getContainerPanel(), "buttonPanel");
                break;
            case "New Game":
                view.getCardLayout().show(view.getContainerPanel(), "buttonPanel");
                break;
            case "1. Manage animals":
                view.getCardLayout().show(view.getContainerPanel(), "animalManager");
                break;
            case "2. Show Coin":
                view.getCardLayout().show(view.getContainerPanel(), "showCoin");
                view.getCoinLabel().setText("Current coin: "+ String.valueOf(model.getCoin()));
                break;
            case "3. Upgrade farm":
                view.getCardLayout().show(view.getContainerPanel(), "farmUpgrade");
                break;
            case "4. Show buildings":
                view.getCardLayout().show(view.getContainerPanel(), "showFarm");
                break;
            case "5. Save game":
            case "6. Instructions":
            case "7. Quit":
                view.dispose();
                break;
            case "1. New animal":
                view.getCardLayout().show(view.getContainerPanel(), "buyAnimal");
                break;
            case "2. Show animal":
                
            case "3. Feed animal":
            case "4. Sell animal":
            case "5. Cancel":
                view.getCardLayout().show(view.getContainerPanel(), "buttonPanel");
                break;
            case "1. New chicken: 1 coins":

            case "2. New Pig: 2 coins":
            case "3. New Sheep: 2 coins":
            case "4. New cattle: 3 coins":
            case "5. New horse: 3 coins":
            case "6. Cancel":
                view.getCardLayout().show(view.getContainerPanel(), "buttonPanel");
                break;
            case "1. Pigsty: 10 coins":
            case "2. Sheep pen: 10 coins":
            case "3. Cattle shed: 20 coins":
            case "4. Stable: 20 coins":

        }
    }
}
