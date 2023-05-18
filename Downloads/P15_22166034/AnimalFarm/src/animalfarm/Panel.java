package animalfarm;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Panel extends JPanel implements ActionListener{
    
    private JLabel label;

    public Panel() {
        setLayout(new BorderLayout());
        JButton button1 = new JButton("New Game");
        JButton button2 = new JButton("Load Game");
        label = new JLabel("Animal Farm");
        label.setFont(new Font("Arial", Font.BOLD, 24));

        JPanel panelCenter = new JPanel();
        panelCenter.setLayout(new BoxLayout(panelCenter, BoxLayout.Y_AXIS));
        panelCenter.add(Box.createVerticalGlue());
        panelCenter.add(label);
        panelCenter.add(Box.createVerticalStrut(10));
        panelCenter.add(button1);
        panelCenter.add(Box.createVerticalStrut(10));
        panelCenter.add(button2);
        panelCenter.add(Box.createVerticalGlue());
        label.setAlignmentX(Component.CENTER_ALIGNMENT);
        button1.setAlignmentX(Component.CENTER_ALIGNMENT);
        button2.setAlignmentX(Component.CENTER_ALIGNMENT);

//        button1.addActionListener(panelSwap);
//        add(panelCenter, BorderLayout.CENTER);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }

}
