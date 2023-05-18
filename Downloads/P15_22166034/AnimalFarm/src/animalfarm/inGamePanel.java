package animalfarm;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

public class inGamePanel extends JPanel {

    public inGamePanel() {
        
        JButton button1 = new JButton("1. Manage animals");
        JButton button2 = new JButton("2. Show Coin");
        JButton button3 = new JButton("3. Upgrade farm");
        JButton button4 = new JButton("4. Show buildings");
        JButton button5 = new JButton("5. Save game");
        JButton button6 = new JButton("6. Instructions");
        JButton button7 = new JButton("7. Quit");

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(3,4));
        buttonPanel.add(button1);
        buttonPanel.add(button2);
        buttonPanel.add(button3);
        buttonPanel.add(button4);
        buttonPanel.add(button5);
        buttonPanel.add(button6);
        buttonPanel.add(button7);
        add(buttonPanel, BorderLayout.SOUTH);
    }
}
