package noiseremoving;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import javax.imageio.ImageIO;

public class Panel extends JPanel {

    private JLabel imageLabel;
    private JButton loadButton;
    private JButton removeNoiseButton;
    private JButton saveButton;

    private BufferedImage originalImage;
    private BufferedImage processedImage;

    public Panel() {
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(800, 600));

        imageLabel = new JLabel();
        add(imageLabel, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel();
        loadButton = new JButton("Load Image");
        removeNoiseButton = new JButton("Remove Noise");
        saveButton = new JButton("Save Image");

        buttonPanel.add(loadButton);
        buttonPanel.add(removeNoiseButton);
        buttonPanel.add(saveButton);

        add(buttonPanel, BorderLayout.SOUTH);

        loadButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                loadImage();
            }
        });

        removeNoiseButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                removeNoise();
            }
        });

        saveButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                saveImage();
            }
        });
    }

    private void loadImage() {
        JFileChooser fileChooser = new JFileChooser();
        int result = fileChooser.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            try {
                originalImage = ImageIO.read(selectedFile);
                imageLabel.setIcon(new ImageIcon(originalImage));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void removeNoise() {
        if (originalImage != null) {
            // Process the image to remove noise
            processedImage = performNoiseRemoval(originalImage);
            imageLabel.setIcon(new ImageIcon(processedImage));
        }
    }

    private void saveImage() {
        if (processedImage != null) {
            JFileChooser fileChooser = new JFileChooser();
            int result = fileChooser.showSaveDialog(this);
            if (result == JFileChooser.APPROVE_OPTION) {
                File selectedFile = fileChooser.getSelectedFile();
                try {
                    ImageIO.write(processedImage, "JPEG", selectedFile);
                    JOptionPane.showMessageDialog(this, "Image saved successfully!");
                } catch (IOException e) {
                    e.printStackTrace();
                    JOptionPane.showMessageDialog(this, "Error saving image.");
                }
            }
        }
    }

    // Perform noise removal on the provided image
    private BufferedImage performNoiseRemoval(BufferedImage image) {
        int width = image.getWidth();
        int height = image.getHeight();

        BufferedImage processedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        for (int y = 1; y < height - 1; y++) {
            for (int x = 1; x < width - 1; x++) {
                int[] redValues = new int[9];
                int[] greenValues = new int[9];
                int[] blueValues = new int[9];
                int index = 0;

                // Collect pixel values of the surrounding 3x3 neighborhood
                for (int dy = -1; dy <= 1; dy++) {
                    for (int dx = -1; dx <= 1; dx++) {
                        int rgb = image.getRGB(x + dx, y + dy);
                        redValues[index] = (rgb >> 16) & 0xFF;
                        greenValues[index] = (rgb >> 8) & 0xFF;
                        blueValues[index] = rgb & 0xFF;
                        index++;
                    }
                }

                // Sort the collected pixel values
                Arrays.sort(redValues);
                Arrays.sort(greenValues);
                Arrays.sort(blueValues);

                // Get the median values of each color channel
                int medianRed = redValues[4];
                int medianGreen = greenValues[4];
                int medianBlue = blueValues[4];

                // Set the processed pixel value in the new image
                int processedRGB = (medianRed << 16) | (medianGreen << 8) | medianBlue;
                processedImage.setRGB(x, y, processedRGB);
            }
        }

        return processedImage;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JFrame frame = new JFrame("Noise Removal Application");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.getContentPane().add(new Panel());
                frame.pack();
                frame.setVisible(true);
            }
        });
    }
}
