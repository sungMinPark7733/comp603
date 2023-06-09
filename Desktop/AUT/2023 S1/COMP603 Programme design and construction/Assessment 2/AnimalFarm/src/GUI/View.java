package GUI;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class View extends JFrame implements Observer {

    private JPanel containerPanel;
    private JPanel firstPanel;
    private JPanel secondPanel;
    private JPanel buttonPanel;
    private JPanel animalManager;
    private JPanel farmUpgrade;
    private JPanel buyAnimal;
    private JPanel coinPanel;
    private JPanel showAnimal;
    private JPanel feedAnimalPanel;
    private JPanel sellAnimalPanel;

    private JButton StartButton;
    private JButton menuButton1;
    private JButton menuButton2;
    private JButton menuButton3;
    private JButton menuButton4;
    private JButton menuButton5;
    private JButton menuButton6;
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
    private JButton cancelButton1;
    private JButton cancelButton2;
    private JButton cancelButton4;
    private JButton cancelButton5;
    private JButton feedChickenButton;
    private JButton feedpigButton;
    private JButton feedsheepButton;
    private JButton feedhorseButton;
    private JButton feedcattleButton;
    private JButton sellChickenButton;
    private JButton sellPigButton;
    private JButton sellSheepButton;
    private JButton sellHorseButton;
    private JButton sellCattleButton;

    private ImageIcon pigstyIcon;
    private JLabel pigstyLabel;
    private ImageIcon sheepPenIcon;
    private JLabel sheepPenLabel;
    private ImageIcon cattleShedIcon;
    private JLabel cattleShedLabel;
    private ImageIcon stableIcon;
    private JLabel stableLabel;

    private ImageIcon chickenIcon;
    private ImageIcon pigIcon;
    private ImageIcon sheepIcon;
    private ImageIcon horseIcon;
    private ImageIcon cattleIcon;
    private JLabel titleLabel;
    private JLabel coinLabel;
    private JLabel chickenLabel;
    private JLabel pigLabel;
    private JLabel sheepLabel;
    private JLabel horseLabel;
    private JLabel cattleLabel;
    private JLabel hungrychickenNumberLabel;
    private JLabel hungrypigNumberLabel;
    private JLabel hungrysheepNumberLabel;
    private JLabel hungryhorseNumberLabel;
    private JLabel hungrycattleNumberLabel;
    private JLabel fullchickenNumberLabel;
    private JLabel fullpigNumberLabel;
    private JLabel fullsheepNumberLabel;
    private JLabel fullhorseNumberLabel;
    private JLabel fullcattleNumberLabel;
    private JLabel warningLabel1;
    private JLabel warningLabel2;
    private JLabel warningLabel3;
    private JLabel warningLabel4;
    private JLabel pigstyownedLabel;
    private JLabel sheeppenOwnedLabel;
    private JLabel cattleshedOwnedLabel;
    private JLabel stableOwnedLabel;
    private JPanel instructionPanel;
    private JLabel instructionLabel;

    public JTextField unInput;
    public JTextField pwInput;

    private CardLayout cardLayout;

    public View() {

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1200, 960);
        Font font = new Font("Arial", Font.BOLD, 24);

        cardLayout = new CardLayout();
        containerPanel = new JPanel();
        containerPanel.setLayout(cardLayout);

        StartButton = new JButton("Start Game");
        menuButton1 = new JButton("1. Manage animals");
        menuButton2 = new JButton("2. Show Coin");
        menuButton3 = new JButton("3. Upgrade farm");
        menuButton4 = new JButton("4. Save game");
        menuButton5 = new JButton("5. Quit");
        menuButton6 = new JButton("6. Reset");
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
        cancelButton1 = new JButton("Cancel");
        cancelButton2 = new JButton("Cancel");
        cancelButton4 = new JButton("Cancel");
        cancelButton5 = new JButton("Cancel");
        feedChickenButton = new JButton("Feed chicken");
        feedpigButton = new JButton("Feed pig");
        feedsheepButton = new JButton("Feed sheep");
        feedhorseButton = new JButton("Feed horse");
        feedcattleButton = new JButton("Feed cattle");
        sellChickenButton = new JButton("Sell chicken");
        sellPigButton = new JButton("Sell pig");
        sellSheepButton = new JButton("Sell sheep");
        sellHorseButton = new JButton("Sell horse");
        sellCattleButton = new JButton("Sell cattle");

        titleLabel = new JLabel("ANIMAL FARM");
        hungrychickenNumberLabel = new JLabel("Hungry chicken: 0");
        hungrypigNumberLabel = new JLabel("Hungry pig: 0");
        hungrysheepNumberLabel = new JLabel("Hungry sheep: 0");
        hungryhorseNumberLabel = new JLabel("Hungry horse: 0");
        hungrycattleNumberLabel = new JLabel("Hungry cattle: 0");
        fullchickenNumberLabel = new JLabel("Full chicken: 0");
        fullpigNumberLabel = new JLabel("Full pig: 0");
        fullsheepNumberLabel = new JLabel("Full sheep: 0");
        fullhorseNumberLabel = new JLabel("Full horse: 0");
        fullcattleNumberLabel = new JLabel("Full cattle: 0");
        warningLabel1 = new JLabel();
        warningLabel2 = new JLabel();
        warningLabel3 = new JLabel();
        warningLabel4 = new JLabel();
        pigstyownedLabel = new JLabel("Owned: False");
        sheeppenOwnedLabel = new JLabel("Owned: False");
        cattleshedOwnedLabel = new JLabel("Owned: False");
        stableOwnedLabel = new JLabel("Owned: False");

//  Panel to choose whether to start a new game or load the existing data        
        firstPanel = new JPanel();
        JPanel loginPanel = new JPanel();
        JPanel titlePanel = new JPanel();
        titleLabel.setFont(font);
        titlePanel.add(titleLabel);
        pwInput = new JTextField(10);
        unInput = new JTextField(10);
        loginPanel.add(pwInput);
        loginPanel.add(unInput);
        loginPanel.add(StartButton);
        firstPanel.add(titlePanel, BorderLayout.NORTH);
        firstPanel.add(loginPanel, BorderLayout.CENTER);
        containerPanel.add(firstPanel, "firstPanel");

//        Panel to select the action
        secondPanel = new JPanel(new BorderLayout());
        JPanel upperPanel = new JPanel();
        buttonPanel = new JPanel(new GridLayout(3, 3));
        buttonPanel.add(menuButton1);
        buttonPanel.add(menuButton2);
        buttonPanel.add(menuButton3);
        buttonPanel.add(menuButton4);
        buttonPanel.add(menuButton5);
        buttonPanel.add(menuButton6);
        secondPanel.add(upperPanel, BorderLayout.NORTH);
        secondPanel.add(buttonPanel, BorderLayout.SOUTH);
        containerPanel.add(secondPanel, "buttonPanel");

//        Panel to show remaining coin
        coinPanel = new JPanel(new BorderLayout());
        JPanel upperPanel2 = new JPanel();
        JPanel buttonPanel2 = new JPanel(new GridLayout(3, 3));
        coinLabel = new JLabel();
        upperPanel2.add(coinLabel);
        buttonPanel2.add(cancelButton1);
        coinPanel.add(upperPanel2, BorderLayout.CENTER);
        coinPanel.add(buttonPanel2, BorderLayout.SOUTH);
        coinLabel.setFont(font);
        containerPanel.add(coinPanel, "showCoin");

//        Panel to manage animals        
        animalManager = new JPanel(new BorderLayout());
        JPanel upperPanel3 = new JPanel();
        JPanel buttonPanel = new JPanel(new GridLayout(3, 3));
        buttonPanel.add(manageAnimalButton1);
        buttonPanel.add(manageAnimalButton2);
        buttonPanel.add(manageAnimalButton3);
        buttonPanel.add(manageAnimalButton4);
        buttonPanel.add(manageAnimalButton5);
        animalManager.add(upperPanel3, BorderLayout.CENTER);
        animalManager.add(buttonPanel, BorderLayout.SOUTH);
        containerPanel.add(animalManager, "animalManager");

//        Panel to show number of animals
        showAnimal = new JPanel(new BorderLayout());
        JPanel hungryAnimalLabelPanel = new JPanel();
        JPanel fullAnimalLabelPanel = new JPanel();
        hungryAnimalLabelPanel.setLayout(new GridLayout(1, 5));
        fullAnimalLabelPanel.setLayout(new GridLayout(1, 5));

        chickenIcon = new ImageIcon("chicken.png");
        chickenIcon = resizeImageIcon(chickenIcon, 100, 100);
        chickenLabel = new JLabel(chickenIcon);
        hungryAnimalLabelPanel.add(chickenLabel);
        hungryAnimalLabelPanel.add(hungrychickenNumberLabel);

        ImageIcon chickenIcon2 = new ImageIcon("chicken.png");
        chickenIcon2 = resizeImageIcon(chickenIcon2, 100, 100);
        JLabel chickenLabel2 = new JLabel(chickenIcon2);

        fullAnimalLabelPanel.add(chickenLabel2);
        fullAnimalLabelPanel.add(fullchickenNumberLabel);

        pigIcon = new ImageIcon("pig.png");
        pigIcon = resizeImageIcon(pigIcon, 100, 100);
        pigLabel = new JLabel(pigIcon);

        hungryAnimalLabelPanel.add(pigLabel);
        hungryAnimalLabelPanel.add(hungrypigNumberLabel);

        ImageIcon pigIcon2 = new ImageIcon("pig.png");
        pigIcon2 = resizeImageIcon(pigIcon2, 100, 100);
        JLabel pigLabel2 = new JLabel(pigIcon2);

        fullAnimalLabelPanel.add(pigLabel2);
        fullAnimalLabelPanel.add(fullpigNumberLabel);

        sheepIcon = new ImageIcon("sheep.png");
        sheepIcon = resizeImageIcon(sheepIcon, 100, 100);
        sheepLabel = new JLabel(sheepIcon);

        hungryAnimalLabelPanel.add(sheepLabel);
        hungryAnimalLabelPanel.add(hungrysheepNumberLabel);

        ImageIcon sheepIcon2 = new ImageIcon("sheep.png");
        sheepIcon2 = resizeImageIcon(sheepIcon2, 100, 100);
        JLabel sheepLabel2 = new JLabel(sheepIcon2);

        fullAnimalLabelPanel.add(sheepLabel2);
        fullAnimalLabelPanel.add(fullsheepNumberLabel);

        horseIcon = new ImageIcon("horse.png");
        horseIcon = resizeImageIcon(horseIcon, 100, 100);
        horseLabel = new JLabel(horseIcon);

        hungryAnimalLabelPanel.add(horseLabel);
        hungryAnimalLabelPanel.add(hungryhorseNumberLabel);

        ImageIcon horseIcon2 = new ImageIcon("horse.png");
        horseIcon2 = resizeImageIcon(horseIcon2, 100, 100);
        JLabel horseLabel2 = new JLabel(horseIcon2);

        fullAnimalLabelPanel.add(horseLabel2);
        fullAnimalLabelPanel.add(fullhorseNumberLabel);

        cattleIcon = new ImageIcon("cow.png");
        cattleIcon = resizeImageIcon(cattleIcon, 100, 100);
        cattleLabel = new JLabel(cattleIcon);

        hungryAnimalLabelPanel.add(cattleLabel);
        hungryAnimalLabelPanel.add(hungrycattleNumberLabel);

        ImageIcon cattleIcon2 = new ImageIcon("cow.png");
        cattleIcon2 = resizeImageIcon(cattleIcon2, 100, 100);
        JLabel cattleLabel2 = new JLabel(cattleIcon2);

        fullAnimalLabelPanel.add(cattleLabel2);
        fullAnimalLabelPanel.add(fullcattleNumberLabel);

        showAnimal.add(hungryAnimalLabelPanel, BorderLayout.NORTH);
        showAnimal.add(fullAnimalLabelPanel, BorderLayout.CENTER);
        showAnimal.add(cancelButton2, BorderLayout.SOUTH);
        containerPanel.add(showAnimal, "showAnimal");

//        Panel to feed hungry animals
        feedAnimalPanel = new JPanel(new BorderLayout());
        JPanel warningPanel = new JPanel();
        JPanel animalFeedPanel = new JPanel();
        JPanel ButtonPanel3 = new JPanel(new GridLayout(3, 3));

        animalFeedPanel.setLayout(new GridLayout(1, 5));
        warningPanel.add(warningLabel3);

        chickenIcon = new ImageIcon("chicken.png");
        chickenIcon = resizeImageIcon(chickenIcon, 100, 100);
        chickenLabel = new JLabel(chickenIcon);

        animalFeedPanel.add(chickenLabel);
        ButtonPanel3.add(feedChickenButton);

        pigIcon = new ImageIcon("pig.png");
        pigIcon = resizeImageIcon(pigIcon, 100, 100);
        pigLabel = new JLabel(pigIcon);

        animalFeedPanel.add(pigLabel);
        ButtonPanel3.add(feedpigButton);

        sheepIcon = new ImageIcon("sheep.png");
        sheepIcon = resizeImageIcon(sheepIcon, 100, 100);
        sheepLabel = new JLabel(sheepIcon);

        animalFeedPanel.add(sheepLabel);
        ButtonPanel3.add(feedsheepButton);

        horseIcon = new ImageIcon("horse.png");
        horseIcon = resizeImageIcon(horseIcon, 100, 100);
        horseLabel = new JLabel(horseIcon);

        animalFeedPanel.add(horseLabel);
        ButtonPanel3.add(feedhorseButton);

        cattleIcon = new ImageIcon("cow.png");
        cattleIcon = resizeImageIcon(cattleIcon, 100, 100);
        cattleLabel = new JLabel(cattleIcon);

        animalFeedPanel.add(cattleLabel);
        ButtonPanel3.add(feedcattleButton);
        ButtonPanel3.add(cancelButton4);

        warningLabel3.setFont(font);
        feedAnimalPanel.add(warningPanel, BorderLayout.NORTH);
        feedAnimalPanel.add(animalFeedPanel, BorderLayout.CENTER);
        feedAnimalPanel.add(ButtonPanel3, BorderLayout.SOUTH);

        containerPanel.add(feedAnimalPanel, "feedAnimal");

//        Panel to sell full animals
        sellAnimalPanel = new JPanel(new BorderLayout());
        JPanel warningPanel2 = new JPanel();
        JPanel animalSellPanel = new JPanel(new GridLayout(1, 5));
        JPanel animalSellButtonPanel = new JPanel(new GridLayout(3, 3));
        warningPanel2.add(warningLabel4);

        chickenIcon = new ImageIcon("chicken.png");
        chickenIcon = resizeImageIcon(chickenIcon, 100, 100);
        chickenLabel = new JLabel(chickenIcon);

        animalSellPanel.add(chickenLabel);
        animalSellButtonPanel.add(sellChickenButton);

        pigIcon = new ImageIcon("pig.png");
        pigIcon = resizeImageIcon(pigIcon, 100, 100);
        pigLabel = new JLabel(pigIcon);

        animalSellPanel.add(pigLabel);
        animalSellButtonPanel.add(sellPigButton);

        sheepIcon = new ImageIcon("sheep.png");
        sheepIcon = resizeImageIcon(sheepIcon, 100, 100);
        sheepLabel = new JLabel(sheepIcon);

        animalSellPanel.add(sheepLabel);
        animalSellButtonPanel.add(sellSheepButton);

        horseIcon = new ImageIcon("horse.png");
        horseIcon = resizeImageIcon(horseIcon, 100, 100);
        horseLabel = new JLabel(horseIcon);

        animalSellPanel.add(horseLabel);
        animalSellButtonPanel.add(sellHorseButton);

        cattleIcon = new ImageIcon("cow.png");
        cattleIcon = resizeImageIcon(cattleIcon, 100, 100);
        cattleLabel = new JLabel(cattleIcon);

        animalSellPanel.add(cattleLabel);
        animalSellButtonPanel.add(sellCattleButton);
        animalSellButtonPanel.add(cancelButton5);
        warningLabel4.setFont(font);

        sellAnimalPanel.add(warningPanel2, BorderLayout.NORTH);
        sellAnimalPanel.add(animalSellPanel, BorderLayout.CENTER);
        sellAnimalPanel.add(animalSellButtonPanel, BorderLayout.SOUTH);
        containerPanel.add(sellAnimalPanel, "sellAnimal");

//        Panel to show the instruction
        instructionPanel = new JPanel();
        instructionLabel = new JLabel();
        instructionLabel.setFont(font);
        instructionPanel.add(instructionLabel);
        containerPanel.add(instructionPanel, "loadInstruction");

//        Panel to buy buildings to unlock new animals        
        farmUpgrade = new JPanel(new BorderLayout());
        JPanel warningPanel3 = new JPanel();
        JPanel farmUpgradeLabelPanel = new JPanel(new GridLayout(1, 4));
        JPanel farmUpgradeButtonPanel = new JPanel(new GridLayout(3, 3));

        pigstyIcon = new ImageIcon("pigsty.png");
        pigstyIcon = resizeImageIcon(pigstyIcon, 100, 100);
        pigstyLabel = new JLabel(pigstyIcon);
        farmUpgradeLabelPanel.add(pigstyLabel);
        farmUpgradeLabelPanel.add(pigstyownedLabel);

        sheepPenIcon = new ImageIcon("sheepPen.png");
        sheepPenIcon = resizeImageIcon(sheepPenIcon, 100, 100);
        sheepPenLabel = new JLabel(sheepPenIcon);
        farmUpgradeLabelPanel.add(sheepPenLabel);
        farmUpgradeLabelPanel.add(sheeppenOwnedLabel);

        cattleShedIcon = new ImageIcon("cattleShed.png");
        cattleShedIcon = resizeImageIcon(cattleShedIcon, 100, 100);
        cattleShedLabel = new JLabel(cattleShedIcon);
        farmUpgradeLabelPanel.add(cattleShedLabel);
        farmUpgradeLabelPanel.add(cattleshedOwnedLabel);

        stableIcon = new ImageIcon("stable.png");
        stableIcon = resizeImageIcon(stableIcon, 100, 100);
        stableLabel = new JLabel(stableIcon);
        farmUpgradeLabelPanel.add(stableLabel);
        farmUpgradeLabelPanel.add(stableOwnedLabel);

        warningPanel3.add(warningLabel2);
        warningLabel2.setFont(font);

        farmUpgradeButtonPanel.add(farmUpgradeButton1);
        farmUpgradeButtonPanel.add(farmUpgradeButton2);
        farmUpgradeButtonPanel.add(farmUpgradeButton3);
        farmUpgradeButtonPanel.add(farmUpgradeButton4);
        farmUpgradeButtonPanel.add(farmUpgradeButton5);

        farmUpgrade.add(warningPanel3, BorderLayout.NORTH);
        farmUpgrade.add(farmUpgradeLabelPanel, BorderLayout.CENTER);
        farmUpgrade.add(farmUpgradeButtonPanel, BorderLayout.SOUTH);
        containerPanel.add(farmUpgrade, "farmUpgrade");

//      Panel to buy animals
        buyAnimal = new JPanel(new BorderLayout());
        JPanel warningPanel4 = new JPanel();
        warningPanel4.add(warningLabel1);
        JPanel buyAnimalButtonPanel = new JPanel(new GridLayout(3, 3));
        buyAnimalButtonPanel.add(buyAnimalButton1);
        buyAnimalButtonPanel.add(buyAnimalButton2);
        buyAnimalButtonPanel.add(buyAnimalButton3);
        buyAnimalButtonPanel.add(buyAnimalButton4);
        buyAnimalButtonPanel.add(buyAnimalButton5);
        buyAnimalButtonPanel.add(buyAnimalButton6);
        warningLabel1.setFont(font);
        buyAnimal.add(warningPanel4, BorderLayout.NORTH);
        buyAnimal.add(buyAnimalButtonPanel, BorderLayout.SOUTH);
        containerPanel.add(buyAnimal, "buyAnimal");
        this.add(containerPanel, BorderLayout.CENTER);
        cardLayout.show(containerPanel, "firstPanel");

    }

    private ImageIcon resizeImageIcon(ImageIcon icon, int width, int height) {
        Image image = icon.getImage();
        Image resizedImage = image.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        return new ImageIcon(resizedImage);
    }

    public void addActionListener(ActionListener listener) {
        this.StartButton.addActionListener(listener);
        this.menuButton1.addActionListener(listener);
        this.menuButton2.addActionListener(listener);
        this.menuButton3.addActionListener(listener);
        this.menuButton4.addActionListener(listener);
        this.menuButton5.addActionListener(listener);
        this.menuButton6.addActionListener(listener);
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
        this.cancelButton1.addActionListener(listener);
        this.cancelButton2.addActionListener(listener);
        this.cancelButton4.addActionListener(listener);
        this.cancelButton5.addActionListener(listener);
        this.feedChickenButton.addActionListener(listener);
        this.feedpigButton.addActionListener(listener);
        this.feedsheepButton.addActionListener(listener);
        this.feedhorseButton.addActionListener(listener);
        this.feedcattleButton.addActionListener(listener);
        this.sellChickenButton.addActionListener(listener);
        this.sellPigButton.addActionListener(listener);
        this.sellSheepButton.addActionListener(listener);
        this.sellHorseButton.addActionListener(listener);
        this.sellCattleButton.addActionListener(listener);
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

    /**
     * @return the hungrychickenNumberLabel
     */
    public JLabel getHungrychickenNumberLabel() {
        return hungrychickenNumberLabel;
    }

    /**
     * @return the hungrypigNumberLabel
     */
    public JLabel getHungrypigNumberLabel() {
        return hungrypigNumberLabel;
    }

    /**
     * @return the hungrysheepNumberLabel
     */
    public JLabel getHungrysheepNumberLabel() {
        return hungrysheepNumberLabel;
    }

    /**
     * @return the hungryhorseNumberLabel
     */
    public JLabel getHungryhorseNumberLabel() {
        return hungryhorseNumberLabel;
    }

    /**
     * @return the hungrycattleNumberLabel
     */
    public JLabel getHungrycattleNumberLabel() {
        return hungrycattleNumberLabel;
    }

    /**
     * @return the fullchickenNumberLabel
     */
    public JLabel getFullchickenNumberLabel() {
        return fullchickenNumberLabel;
    }

    /**
     * @return the fullpigNumberLabel
     */
    public JLabel getFullpigNumberLabel() {
        return fullpigNumberLabel;
    }

    /**
     * @return the fullsheepNumberLabel
     */
    public JLabel getFullsheepNumberLabel() {
        return fullsheepNumberLabel;
    }

    /**
     * @return the fullhorseNumberLabel
     */
    public JLabel getFullhorseNumberLabel() {
        return fullhorseNumberLabel;
    }

    /**
     * @return the fullcattleNumberLabel
     */
    public JLabel getFullcattleNumberLabel() {
        return fullcattleNumberLabel;
    }

    /**
     * @return the warningLabel1
     */
    public JLabel getwarningLabel1() {
        return warningLabel1;
    }

    /**
     * @return the pigstyownedLabel
     */
    public JLabel getPigstyownedLabel() {
        return pigstyownedLabel;
    }

    /**
     * @return the sheeppenOwnedLabel
     */
    public JLabel getSheeppenOwnedLabel() {
        return sheeppenOwnedLabel;
    }

    /**
     * @return the cattleshedOwnedLabel
     */
    public JLabel getCattleshedOwnedLabel() {
        return cattleshedOwnedLabel;
    }

    /**
     * @return the stableOwnedLabel
     */
    public JLabel getStableOwnedLabel() {
        return stableOwnedLabel;
    }

    /**
     * @return the warningLabel2
     */
    public JLabel getWarningLabel2() {
        return warningLabel2;
    }

    /**
     * @return the warningLabel3
     */
    public JLabel getWarningLabel3() {
        return warningLabel3;
    }

    /**
     * @return the warningLabel4
     */
    public JLabel getWarningLabel4() {
        return warningLabel4;
    }

    /**
     * @return the instructionLabel
     */
    public JLabel getInstructionLabel() {
        return instructionLabel;
    }
}
