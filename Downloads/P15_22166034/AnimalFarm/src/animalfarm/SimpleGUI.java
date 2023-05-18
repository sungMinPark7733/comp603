package animalfarm;

import javax.swing.JFrame;

public class SimpleGUI {

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Panel panel = new Panel();
        inGamePanel gPanel = new inGamePanel();
        frame.add(gPanel);
        frame.setSize(500, 500);
        frame.setVisible(true);
    }
}
