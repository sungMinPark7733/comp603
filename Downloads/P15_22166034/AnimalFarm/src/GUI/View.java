package GUI;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
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
    private JPanel showAnimal;
    private JPanel feedAnimalPanel;
    private JPanel sellAnimalPanel;

    private JButton newGameButton;
    private JButton loadGameButton;
    private JButton menuButton1;
    private JButton menuButton2;
    private JButton menuButton3;
    private JButton menuButton4;
    private JButton menuButton5;
    private JButton menuButton6;
    private JButton menuButton7;
    private JButton menuButton8;
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
    private JButton cancelButton3;
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
    
    private CardLayout cardLayout;

    public View() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1080, 960);
        cardLayout = new CardLayout();

        containerPanel = new JPanel();
        containerPanel.setLayout(cardLayout);

        loadGameButton = new JButton("Load Game");
        newGameButton = new JButton("New Game");
        menuButton1 = new JButton("1. Manage animals");
        menuButton2 = new JButton("2. Show Coin");
        menuButton3 = new JButton("3. Upgrade farm");
        menuButton4 = new JButton("4. Show buildings");
        menuButton5 = new JButton("5. Save game");
        menuButton6 = new JButton("6. Instructions");
        menuButton7 = new JButton("7. Quit");
        menuButton8 = new JButton("8. Reset");
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
        cancelButton3 = new JButton("Cancel");
        cancelButton4 = new JButton("Cancel");
        cancelButton5 = new JButton("Cancel");
        feedChickenButton = new JButton("Feed chicken");
        feedpigButton = new JButton("Feed pig");
        feedsheepButton = new JButton("Feed sheep");
        feedhorseButton = new JButton("Feed horse");
        feedcattleButton = new JButton("Feed cattle");
        sellChickenButton = new JButton("Sell chicken");
        sellPigButton = new JButton("Sell pig");;
        sellSheepButton = new JButton("Sell sheep");;
        sellHorseButton = new JButton("Sell horse");;
        sellCattleButton = new JButton("Sell cattle");;

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

        firstPanel = new JPanel();

        firstPanel.add(newGameButton);

        firstPanel.add(loadGameButton);

        containerPanel.add(firstPanel,
                "firstPanel");

        buttonPanel = new JPanel();

        buttonPanel.setLayout(
                new GridLayout(3, 3));
        buttonPanel.add(menuButton1);
        buttonPanel.add(menuButton2);
        buttonPanel.add(menuButton3);
        buttonPanel.add(menuButton4);
        buttonPanel.add(menuButton5);
        buttonPanel.add(menuButton6);
        buttonPanel.add(menuButton7);
        buttonPanel.add(menuButton8);

        containerPanel.add(buttonPanel,
                "buttonPanel");

        coinPanel = new JPanel(new GridBagLayout());
        coinLabel = new JLabel();

        coinPanel.add(coinLabel);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.gridx = 0; // Set the column index to 0

        coinPanel.add(coinLabel, gbc);
        gbc.gridy = 1; // Set the row index to 1

        coinPanel.add(cancelButton1, gbc);

        coinLabel.setFont(coinLabel.getFont().deriveFont(Font.BOLD, 24));
        containerPanel.add(coinPanel,
                "showCoin");

        animalManager = new JPanel();

        animalManager.setLayout(new GridLayout(3, 3));
        animalManager.add(manageAnimalButton1);

        animalManager.add(manageAnimalButton2);

        animalManager.add(manageAnimalButton3);

        animalManager.add(manageAnimalButton4);

        animalManager.add(manageAnimalButton5);

        containerPanel.add(animalManager, "animalManager");

        showAnimal = new JPanel();
        JPanel hungryAnimalLabelPanel = new JPanel();
        JPanel fullAnimalLabelPanel = new JPanel();

        hungryAnimalLabelPanel.setLayout(
                new GridLayout(1, 5));
        fullAnimalLabelPanel.setLayout(
                new GridLayout(1, 5));

        JLabel hungryLabel = new JLabel("Hungry: ");

        hungryAnimalLabelPanel.add(hungryLabel);
        JLabel fullLable = new JLabel("Full: ");

        fullAnimalLabelPanel.add(fullLable);

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

        containerPanel.add(showAnimal,
                "showAnimal");

        feedAnimalPanel = new JPanel();
        JPanel animalFeedPanel = new JPanel();
        JPanel animalFeedButtonPanel = new JPanel();

        animalFeedPanel.setLayout(new GridLayout(1, 5));
        animalFeedPanel.add(warningLabel3);

        chickenIcon = new ImageIcon("chicken.png");
        chickenIcon = resizeImageIcon(chickenIcon, 100, 100);
        chickenLabel = new JLabel(chickenIcon);

        animalFeedPanel.add(chickenLabel);
        animalFeedButtonPanel.add(feedChickenButton);

        pigIcon = new ImageIcon("pig.png");
        pigIcon = resizeImageIcon(pigIcon, 100, 100);
        pigLabel = new JLabel(pigIcon);

        animalFeedPanel.add(pigLabel);
        animalFeedButtonPanel.add(feedpigButton);

        sheepIcon = new ImageIcon("sheep.png");
        sheepIcon = resizeImageIcon(sheepIcon, 100, 100);
        sheepLabel = new JLabel(sheepIcon);

        animalFeedPanel.add(sheepLabel);
        animalFeedButtonPanel.add(feedsheepButton);

        horseIcon = new ImageIcon("horse.png");
        horseIcon = resizeImageIcon(horseIcon, 100, 100);
        horseLabel = new JLabel(horseIcon);

        animalFeedPanel.add(horseLabel);
        animalFeedButtonPanel.add(feedhorseButton);

        cattleIcon = new ImageIcon("cow.png");
        cattleIcon = resizeImageIcon(cattleIcon, 100, 100);
        cattleLabel = new JLabel(cattleIcon);

        animalFeedPanel.add(cattleLabel);
        animalFeedButtonPanel.add(feedcattleButton);

        feedAnimalPanel.add(animalFeedPanel, BorderLayout.NORTH);
        feedAnimalPanel.add(animalFeedButtonPanel, BorderLayout.CENTER);
        feedAnimalPanel.add(cancelButton4, BorderLayout.SOUTH);

        containerPanel.add(feedAnimalPanel,
                "feedAnimal");

        sellAnimalPanel = new JPanel();
        JPanel animalSellPanel = new JPanel();

        animalSellPanel.setLayout(new GridLayout(1, 5));

        animalSellPanel.add(warningLabel4);

        chickenIcon = new ImageIcon("chicken.png");
        chickenIcon = resizeImageIcon(chickenIcon, 100, 100);
        chickenLabel = new JLabel(chickenIcon);

        animalSellPanel.add(chickenLabel);
        animalSellPanel.add(sellChickenButton);

        pigIcon = new ImageIcon("pig.png");
        pigIcon = resizeImageIcon(pigIcon, 100, 100);
        pigLabel = new JLabel(pigIcon);

        animalSellPanel.add(pigLabel);
        animalSellPanel.add(sellPigButton);

        sheepIcon = new ImageIcon("sheep.png");
        sheepIcon = resizeImageIcon(sheepIcon, 100, 100);
        sheepLabel = new JLabel(sheepIcon);

        animalSellPanel.add(sheepLabel);
        animalSellPanel.add(sellSheepButton);

        horseIcon = new ImageIcon("horse.png");
        horseIcon = resizeImageIcon(horseIcon, 100, 100);
        horseLabel = new JLabel(horseIcon);

        animalSellPanel.add(horseLabel);
        animalSellPanel.add(sellHorseButton);

        cattleIcon = new ImageIcon("cow.png");
        cattleIcon = resizeImageIcon(cattleIcon, 100, 100);
        cattleLabel = new JLabel(cattleIcon);

        animalSellPanel.add(cattleLabel);
        animalSellPanel.add(sellCattleButton);

        sellAnimalPanel.add(animalSellPanel, BorderLayout.NORTH);

        sellAnimalPanel.add(cancelButton5, BorderLayout.CENTER);

        containerPanel.add(sellAnimalPanel,
                "sellAnimal");

        farmUpgrade = new JPanel();
        JPanel farmUpgradeButtonPanel = new JPanel();
        JPanel farmUpgradeLabelPanel = new JPanel();

        farmUpgradeLabelPanel.add(warningLabel2);

        farmUpgradeButtonPanel.setLayout(new GridLayout(3, 3));
        farmUpgradeButtonPanel.add(farmUpgradeButton1);
        farmUpgradeButtonPanel.add(farmUpgradeButton2);
        farmUpgradeButtonPanel.add(farmUpgradeButton3);
        farmUpgradeButtonPanel.add(farmUpgradeButton4);
        farmUpgradeButtonPanel.add(farmUpgradeButton5);
        farmUpgrade.add(farmUpgradeLabelPanel, BorderLayout.NORTH);
        farmUpgrade.add(farmUpgradeButtonPanel, BorderLayout.SOUTH);
        containerPanel.add(farmUpgrade, "farmUpgrade");

        showFarm = new JPanel(new BorderLayout());
        JPanel labelPanel = new JPanel();

        labelPanel.setLayout(
                new GridLayout(1, 4));

        pigstyIcon = new ImageIcon("pigsty.png");
        pigstyIcon = resizeImageIcon(pigstyIcon, 100, 100);
        pigstyLabel = new JLabel(pigstyIcon);

        labelPanel.add(pigstyLabel);

        labelPanel.add(pigstyownedLabel);

        sheepPenIcon = new ImageIcon("sheepPen.png");
        sheepPenIcon = resizeImageIcon(sheepPenIcon, 100, 100);
        sheepPenLabel = new JLabel(sheepPenIcon);

        labelPanel.add(sheepPenLabel);

        labelPanel.add(sheeppenOwnedLabel);

        cattleShedIcon = new ImageIcon("cattleShed.png");
        cattleShedIcon = resizeImageIcon(cattleShedIcon, 100, 100);
        cattleShedLabel = new JLabel(cattleShedIcon);

        labelPanel.add(cattleShedLabel);

        labelPanel.add(cattleshedOwnedLabel);

        stableIcon = new ImageIcon("stable.png");
        stableIcon = resizeImageIcon(stableIcon, 100, 100);
        stableLabel = new JLabel(stableIcon);

        labelPanel.add(stableLabel);

        labelPanel.add(stableOwnedLabel);

        showFarm.add(labelPanel, BorderLayout.NORTH);

        showFarm.add(cancelButton3, BorderLayout.CENTER);

        containerPanel.add(showFarm,
                "showFarm");

        buyAnimal = new JPanel();

        buyAnimal.setLayout(
                new GridLayout(3, 3));
        buyAnimal.add(buyAnimalButton1);

        buyAnimal.add(buyAnimalButton2);

        buyAnimal.add(buyAnimalButton3);

        buyAnimal.add(buyAnimalButton4);

        buyAnimal.add(buyAnimalButton5);

        buyAnimal.add(buyAnimalButton6);

        buyAnimal.add(warningLabel1);

        containerPanel.add(buyAnimal,
                "buyAnimal");

        this.add(containerPanel, BorderLayout.CENTER);

        cardLayout.show(containerPanel,
                "firstPanel");
    }

    private ImageIcon resizeImageIcon(ImageIcon icon, int width, int height) {
        Image image = icon.getImage();
        Image resizedImage = image.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        return new ImageIcon(resizedImage);
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
        this.menuButton8.addActionListener(listener);
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
        this.cancelButton3.addActionListener(listener);
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
}
