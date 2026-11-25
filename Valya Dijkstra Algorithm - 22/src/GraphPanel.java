import javax.swing.*;
import java.awt.*;
import java.util.List;

public class GraphPanel extends JPanel {
    private List<Vertex> vertices; // List of vertices to be drawn
    private List<List<Vertex>> paths; // List of shortest paths to be highlighted
    private boolean showWeights; // Flag to indicate if edge weights should be displayed
    private String shortestPathText; // Text to display the shortest path(s)
    private JLabel pathLabel; // JLabel to display the shortest path(s)

    // Array of colors to use for different paths
    private final Color[] pathColors = {Color.GREEN, Color.PINK, Color.CYAN};

    // Constructor to set up the panel
    public GraphPanel() {
        setLayout(null); // Use null layout to manually position components
        pathLabel = new JLabel();
        pathLabel.setBounds(10, 400, 780, 30); // Position the label manually
        add(pathLabel);
    }

    // Method to update the graph with new vertices, paths, and shortest path text
    public void updateGraph(List<Vertex> vertices, List<List<Vertex>> paths, boolean showWeights, String shortestPathText) {
        this.vertices = vertices;
        this.paths = paths;
        this.showWeights = showWeights;
        this.shortestPathText = shortestPathText;
        pathLabel.setText(shortestPathText);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Return if there are no vertices to draw
        if (vertices == null) return;

        int radius = 20; // Radius of the vertex circles
        int[][] positions = {
                {100, 150}, // Position of vertex A
                {200, 250}, // Position of vertex B
                {300, 150}, // Position of vertex C
                {400, 250}, // Position of vertex D
                {500, 150}, // Position of vertex E
                {350, 70}   // Position of vertex F
        };

        // Draw edges between vertices
        for (int i = 0; i < vertices.size(); i++) {
            Vertex v = vertices.get(i);
            int x = positions[i][0];
            int y = positions[i][1];

            // Draw lines between vertices to represent edges
            for (Road road : v.adjacencies) {
                Vertex target = road.target;
                int targetIndex = vertices.indexOf(target);
                int targetX = positions[targetIndex][0];
                int targetY = positions[targetIndex][1];

                g2.drawLine(x + radius / 2, y + radius / 2, targetX + radius / 2, targetY + radius / 2);

                // Display the weight of the edges
                if (showWeights) {
                    int midX = (x + targetX) / 2;
                    int midY = (y + targetY) / 2;//ints for the coordinates
                    g2.setColor(Color.BLUE); //in blue
                    g2.drawString(Double.toString(road.weight), midX, midY); //Write the weights using previously gotten coordinates
                    g2.setColor(Color.BLACK); //set color back to black
                }
            }
        }

        // Draw vertices as circles
        for (int i = 0; i < vertices.size(); i++) {
            Vertex v = vertices.get(i);//get the vertex
            int x = positions[i][0]; //Horizontal position + vertical position of the circles
            int y = positions[i][1];
            g2.setColor(Color.WHITE);//fill in white
            g2.fillOval(x, y, radius, radius);
            g2.setColor(Color.BLACK); //black outline
            g2.drawOval(x, y, radius, radius);
            g2.drawString(v.name, x + radius / 4, y + radius / 2); //write name of the string component, current Vertex name
        }

        // Draw paths with different colors
        if (paths != null && showWeights) {
            for (int i = 0; i < paths.size(); i++) {
                List<Vertex> path = paths.get(i);//get path
                g2.setColor(pathColors[i % pathColors.length]); //get the color (from an Array above) for the shortest path (s)
                for (int j = 0; j < path.size() - 1; j++) {
                    Vertex v = path.get(j); //get path
                    Vertex next = path.get(j + 1);
                    int indexV = vertices.indexOf(v);//current
                    int indexNext = vertices.indexOf(next);//next vertex

                    //get the Xs and Ys of the line
                    int x1 = positions[indexV][0] + radius / 2; //radius/2 because it will start in the middle of a circle
                    int y1 = positions[indexV][1] + radius / 2;
                    int x2 = positions[indexNext][0] + radius / 2;
                    int y2 = positions[indexNext][1] + radius / 2;

                    g2.drawLine(x1, y1, x2, y2);//draw the line
                }
            }
        }
    }
}
