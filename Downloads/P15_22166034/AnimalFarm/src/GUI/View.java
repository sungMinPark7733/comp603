package GUI;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class View extends JFrame implements Observer {

    private JPanel containerPanel;
    private JPanel firstPanel;
    private JPanel buttonPanel;
    private JPanel animalManager;
    private JPanel farmUpgrade;
    private JPanel buyAnimal;
    private JPanel showFarm;
    private JPanel coinPanel;
    private JPanel showAnimalPanel;
    
    private JButton newGameButton;
    private JButton loadGameButton;
    private JButton menuButton1;
    private JButton menuButton2;
    private JButton menuButton3;
    private JButton menuButton4;
    private JButton menuButton5;
    private JButton menuButton6;
    private JButton menuButton7;
    private JButton manageAnimalButton1;
    private JButton manageAnimalButton2;
    private JButton manageAnimalButton3;
    private JButton manageAnimalButton4;
    private JButton manageAnimalButton5;
    private JButton buyAnimalButton1;
    private JButton buyAnimalButton2;
    private JButton buyAnimalButton3;
    private JButton buyAnimalButton4;
    private JButton buyAnimalButton5;
    private JButton buyAnimalButton6;
    private JButton farmUpgradeButton1;
    private JButton farmUpgradeButton2;
    private JButton farmUpgradeButton3;
    private JButton farmUpgradeButton4;
    private JButton farmUpgradeButton5;

    private JLabel label;
    private JLabel coinLabel;
    private CardLayout cardLayout;

    public View() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(600, 600);
        cardLayout = new CardLayout();

        containerPanel = new JPanel();
        containerPanel.setLayout(cardLayout);

        label = new JLabel();
        label.setIcon(new ImageIcon("barn.png"));
        label.setBounds(50, 30, 10, 10); //Sets the location of the image

        loadGameButton = new JButton("Load Game");
        newGameButton = new JButton("New Game");
        menuButton1 = new JButton("1. Manage animals");
        menuButton2 = new JButton("2. Show Coin");
        menuButton3 = new JButton("3. Upgrade farm");
        menuButton4 = new JButton("4. Show buildings");
        menuButton5 = new JButton("5. Save game");
        menuButton6 = new JButton("6. Instructions");
        menuButton7 = new JButton("7. Quit");
        manageAnimalButton1 = new JButton("1. New animal");
        manageAnimalButton2 = new JButton("2. Show animal");
        manageAnimalButton3 = new JButton("3. Feed animal");
        manageAnimalButton4 = new JButton("4. Sell animal");
        manageAnimalButton5 = new JButton("5. Cancel");
        buyAnimalButton1 = new JButton("1. New chicken: 1 coins");
        buyAnimalButton2 = new JButton("2. New Pig: 2 coins");
        buyAnimalButton3 = new JButton("3. New Sheep: 2 coins");
        buyAnimalButton4 = new JButton("4. New cattle: 3 coins");
        buyAnimalButton5 = new JButton("5. New horse: 3 coins");
        buyAnimalButton6 = new JButton("6. Cancel");
        farmUpgradeButton1 = new JButton("1. Pigsty: 10 coins");
        farmUpgradeButton2 = new JButton("2. Sheep pen: 10 coins");
        farmUpgradeButton3 = new JButton("3. Cattle shed: 20 coins");
        farmUpgradeButton4 = new JButton("4. Stable: 20 coins");
        farmUpgradeButton5 = new JButton("5. Cancel");

        firstPanel = new JPanel();
        firstPanel.add(newGameButton);
        firstPanel.add(loadGameButton);
        containerPanel.add(firstPanel, "firstPanel");

        buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(3, 3));
        buttonPanel.add(menuButton1);
        buttonPanel.add(menuButton2);
        buttonPanel.add(menuButton3);
        buttonPanel.add(menuButton4);
        buttonPanel.add(menuButton5);
        buttonPanel.add(menuButton6);
        buttonPanel.add(menuButton7);
        containerPanel.add(buttonPanel, "buttonPanel");

        coinPanel = new JPanel();
        coinPanel.setLayout(new GridBagLayout());  // Use GridBagLayout
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(0, 0, 0, 0); // Set the insets to 0
        coinLabel = new JLabel();
        coinLabel.setFont(coinLabel.getFont().deriveFont(Font.BOLD, 24));  // Set a bigger font size
        coinPanel.add(coinLabel, gbc);
        containerPanel.add(coinPanel, "showCoin");

        animalManager = new JPanel();
        animalManager.setLayout(new GridLayout(3, 3));
        animalManager.add(manageAnimalButton1);
        animalManager.add(manageAnimalButton2);
        animalManager.add(manageAnimalButton3);
        animalManager.add(manageAnimalButton4);
        animalManager.add(manageAnimalButton5);
        containerPanel.add(animalManager, "animalManager");

        showAnimalPanel = new JPanel();
        
        
        
        farmUpgrade = new JPanel();
        farmUpgrade.setLayout(new GridLayout(3, 3));
        farmUpgrade.add(farmUpgradeButton1);
        farmUpgrade.add(farmUpgradeButton2);
        farmUpgrade.add(farmUpgradeButton3);
        farmUpgrade.add(farmUpgradeButton4);
        farmUpgrade.add(farmUpgradeButton5);
        containerPanel.add(farmUpgrade, "farmUpgrade");

        showFarm = new JPanel();
        showFarm.add(label);
        containerPanel.add(showFarm, "showFarm");

        buyAnimal = new JPanel();
        buyAnimal.setLayout(new GridLayout(3, 3));
        buyAnimal.add(buyAnimalButton1);
        buyAnimal.add(buyAnimalButton2);
        buyAnimal.add(buyAnimalButton3);
        buyAnimal.add(buyAnimalButton4);
        buyAnimal.add(buyAnimalButton5);
        buyAnimal.add(buyAnimalButton6);
        containerPanel.add(buyAnimal, "buyAnimal");

        this.add(containerPanel, BorderLayout.CENTER);
        cardLayout.show(containerPanel, "firstPanel");
    }

    public void addActionListener(ActionListener listener) {
        this.newGameButton.addActionListener(listener);
        this.loadGameButton.addActionListener(listener);
        this.menuButton1.addActionListener(listener);
        this.menuButton2.addActionListener(listener);
        this.menuButton3.addActionListener(listener);
        this.menuButton4.addActionListener(listener);
        this.menuButton5.addActionListener(listener);
        this.menuButton6.addActionListener(listener);
        this.menuButton7.addActionListener(listener);
        this.manageAnimalButton1.addActionListener(listener);
        this.manageAnimalButton2.addActionListener(listener);
        this.manageAnimalButton3.addActionListener(listener);
        this.manageAnimalButton4.addActionListener(listener);
        this.manageAnimalButton5.addActionListener(listener);
        this.buyAnimalButton1.addActionListener(listener);
        this.buyAnimalButton2.addActionListener(listener);
        this.buyAnimalButton3.addActionListener(listener);
        this.buyAnimalButton4.addActionListener(listener);
        this.buyAnimalButton5.addActionListener(listener);
        this.buyAnimalButton6.addActionListener(listener);
        this.farmUpgradeButton1.addActionListener(listener);
        this.farmUpgradeButton2.addActionListener(listener);
        this.farmUpgradeButton3.addActionListener(listener);
        this.farmUpgradeButton4.addActionListener(listener);
        this.farmUpgradeButton5.addActionListener(listener);
    }

    @Override
    public void update(Observable o, Object animals) {

    }

    /**
     * @return the containerPanel
     */
    public JPanel getContainerPanel() {
        return containerPanel;
    }

    /**
     * @param containerPanel the containerPanel to set
     */
    public void setContainerPanel(JPanel containerPanel) {
        this.containerPanel = containerPanel;
    }

    /**
     * @return the cardLayout
     */
    public CardLayout getCardLayout() {
        return cardLayout;
    }

    /**
     * @param cardLayout the cardLayout to set
     */
    public void setCardLayout(CardLayout cardLayout) {
        this.cardLayout = cardLayout;
    }

    /**
     * @return the coinLabel
     */
    public JLabel getCoinLabel() {
        return coinLabel;
    }

    /**
     * @param coinLabel the coinLabel to set
     */
    public void setCoinLabel(JLabel coinLabel) {
        this.coinLabel = coinLabel;
    }
}
