package maze;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import javax.swing.JPanel;

public class Panel extends JPanel {

    FileManager fileManager;
    int columns;
    int rows;

    public Panel() {

    }

    private List<String> findPath(String startElement, String endElement, String[] lineData) {
        // Create a queue for BFS
        Queue<String> queue = new LinkedList<>();
        // Create a map to store the parent of each element
        Map<String, String> parentMap = new HashMap<>();

        // Enqueue the start element
        queue.add(startElement);
        parentMap.put(startElement, null);

        while (!queue.isEmpty()) {
            String currentElement = queue.poll();

            if (currentElement.equals(endElement)) {
                // Path found, reconstruct and return the path
                return reconstructPath(parentMap, endElement);
            }

            // Find the index of the current element in lineData
            int currentIndex = findElementIndex(currentElement, lineData);
            if (currentIndex != -1) {
                String[] elementData = lineData[currentIndex].split(",");
                // Iterate over the adjacent elements starting from index 3
                for (int j = 3; j < elementData.length; j++) {
                    String adjacentElement = elementData[j];
                    if (!parentMap.containsKey(adjacentElement)) {
                        // Enqueue the adjacent element and mark its parent
                        queue.add(adjacentElement);
                        parentMap.put(adjacentElement, currentElement);
                    }
                }
            }
        }

        // No path found
        return Collections.emptyList();
    }

    private List<String> reconstructPath(Map<String, String> parentMap, String endElement) {
        List<String> path = new ArrayList<>();
        String current = endElement;

        while (current != null) {
            path.add(0, current);
            current = parentMap.get(current);
        }

        return path;
    }

    public void paint(Graphics g) {
        super.paint(g);

        fileManager = new FileManager("Maze1.txt");
        fileManager.readFile(null);
        String[] lineData = fileManager.lineData;

        String firstLine = lineData[0];
        String[] elements = firstLine.split(",");
        rows = Integer.parseInt(elements[2]);
        columns = Integer.parseInt(elements[1]);
        Integer.parseInt(elements[0]);

        int width = getWidth();
        int height = getHeight();

        int columnWidth = width / columns;
        int rowHeight = height / rows;

        // Draw columns
        for (int i = 1; i < columns; i++) {
            int x = i * columnWidth;
            g.drawLine(x, 0, x, height);
        }

        // Draw rows
        for (int i = 1; i < rows; i++) {
            int y = i * rowHeight;
            g.drawLine(0, y, width, y);
        }

        // Draw elements as blue circles with names above and connect them
        g.setColor(Color.BLUE);
        g.setFont(new Font("Arial", Font.BOLD, 12));

        for (int i = 0; i < lineData.length; i++) {
            String[] elementData = lineData[i].split(",");
            String name = elementData[0];
            int col = Integer.parseInt(elementData[1]);
            int row = Integer.parseInt(elementData[2]);

            int x = col * columnWidth + (columnWidth / 2);
            int y = row * rowHeight + (rowHeight / 2);

            // Draw element name above
            g.setColor(Color.BLUE);
            g.drawString(name, x - g.getFontMetrics().stringWidth(name) / 2, y - 20);

            // Draw blue circle
            g.fillOval(x - 10, y - 10, 20, 20);

            // Connect the element to the next elements
            g.setColor(Color.GREEN);

            for (int j = 3; j < elementData.length; j++) {
                String nextElement = elementData[j];
                int nextIndex = findElementIndex(nextElement, lineData);

                if (nextIndex != -1) {
                    String[] nextElementData = lineData[nextIndex].split(",");
                    int nextCol = Integer.parseInt(nextElementData[1]);
                    int nextRow = Integer.parseInt(nextElementData[2]);

                    int nextX = nextCol * columnWidth + (columnWidth / 2);
                    int nextY = nextRow * rowHeight + (rowHeight / 2);

                    // Draw a line connecting the elements
                    g.drawLine(x, y, nextX, nextY);
                }
            }
        }
        g.setColor(Color.RED);

        String[] elementsToConnect = {"START", "B", "K", "L", "N", "O", "P", "Q", "S", "U", "EXIT"};

        for (int i = 0; i < elementsToConnect.length - 1; i++) {
            String currentElement = elementsToConnect[i];
            String nextElement = elementsToConnect[i + 1];

            int currentIndex = findElementIndex(currentElement, lineData);
            int nextIndex = findElementIndex(nextElement, lineData);

            if (currentIndex != -1 && nextIndex != -1) {
                String[] currentElementData = lineData[currentIndex].split(",");
                String[] nextElementData = lineData[nextIndex].split(",");

                int currentCol = Integer.parseInt(currentElementData[1]);
                int currentRow = Integer.parseInt(currentElementData[2]);

                int nextCol = Integer.parseInt(nextElementData[1]);
                int nextRow = Integer.parseInt(nextElementData[2]);

                int currentX = currentCol * columnWidth + (columnWidth / 2);
                int currentY = currentRow * rowHeight + (rowHeight / 2);

                int nextX = nextCol * columnWidth + (columnWidth / 2);
                int nextY = nextRow * rowHeight + (rowHeight / 2);

                // Draw a red line connecting the elements
                g.drawLine(currentX, currentY, nextX, nextY);
            }
        }
        List<String> path = findPath("START", "EXIT", lineData);

        // Draw the path in red
        g.setColor(Color.RED);

        for (int i = 0; i < path.size() - 1; i++) {
            String currentElement = path.get(i);
            String nextElement = path.get(i + 1);

            int currentElementIndex = findElementIndex(currentElement, lineData);
            int nextElementIndex = findElementIndex(nextElement, lineData);

            if (currentElementIndex != -1 && nextElementIndex != -1) {
                String[] currentElementData = lineData[currentElementIndex].split(",");
                String[] nextElementData = lineData[nextElementIndex].split(",");

                int currentCol = Integer.parseInt(currentElementData[1]);
                int currentRow = Integer.parseInt(currentElementData[2]);

                int nextCol = Integer.parseInt(nextElementData[1]);
                int nextRow = Integer.parseInt(nextElementData[2]);

                int currentX = currentCol * columnWidth + (columnWidth / 2);
                int currentY = currentRow * rowHeight + (rowHeight / 2);

                int nextX = nextCol * columnWidth + (columnWidth / 2);
                int nextY = nextRow * rowHeight + (rowHeight / 2);

                // Draw a line connecting the elements
                g.drawLine(currentX, currentY, nextX, nextY);
            }
        }
    }

    private int findElementIndex(String element, String[] lineData) {
        for (int i = 0; i < lineData.length; i++) {
            String[] elementData = lineData[i].split(",");
            String name = elementData[0];
            if (name.equals(element)) {
                return i;
            }
        }
        return -1;
    }

}
