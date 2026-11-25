//Valentina Cherkovskaya
//Year 13 Computer Science project
//Term 2 week 1 - Term 3 week 2
//


//Import the libraries
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main { //Main class
    public static void main(String[] args) {
        // Create vertices with names A-F
        Vertex A = new Vertex("A");
        Vertex B = new Vertex("B");
        Vertex C = new Vertex("C");
        Vertex D = new Vertex("D");
        Vertex E = new Vertex("E");
        Vertex F = new Vertex("F");

        // Create a map for easy lookup of vertices by their names
        Map<String, Vertex> vertexMap = new HashMap<>(); //map string
        vertexMap.put("A", A);
        vertexMap.put("B", B);
        vertexMap.put("C", C);
        vertexMap.put("D", D);
        vertexMap.put("E", E);
        vertexMap.put("F", F);

        // Create the main frame for the application
        JFrame frame = new JFrame("Dijkstra's Algorithm"); //+name
        // Create a panel to hold the input fields for edge weights
        JPanel inputPanel = new JPanel();
        // Create a custom panel to draw the graph
        GraphPanel graphPanel = new GraphPanel();

        // Array to hold the JTextField components for edge weight inputs
        JTextField[] weightFields = new JTextField[9]; // 9 components
        // Array of labels for the input fields, representing edges between vertices
        String[] labels = {"A-B", "A-C", "A-F", "B-C", "B-D", "C-D", "C-F", "D-E", "F-E"};

        // Add labels and input fields to the input panel
        for (int i = 0; i < weightFields.length; i++) {
            inputPanel.add(new JLabel(labels[i]));
            weightFields[i] = new JTextField(5);
            inputPanel.add(weightFields[i]);
        }

        // Button to start the Dijkstra algorithm
        JButton startButton = new JButton("Start");
        inputPanel.add(startButton);

        // Set the layout of the frame and add components
        frame.setLayout(new BorderLayout());
        frame.add(inputPanel, BorderLayout.NORTH); // Input panel at the top
        frame.add(graphPanel, BorderLayout.CENTER); // Graph panel in the center

        // Set the frame size, close operation, and visibility
        frame.setSize(800, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        // List of all vertices in the graph
        List<Vertex> vertices = Arrays.asList(A, B, C, D, E, F);
        // Initialize the graph panel with vertices and no paths
        graphPanel.updateGraph(vertices, null, false, "");
        graphPanel.repaint();

        // Action listener for the start button to run Dijkstra's algorithm
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    // Array to hold the parsed weights from input fields
                    double[] weights = new double[9];
                    // Parse weights from input fields and store in weights array
                    for (int i = 0; i < weightFields.length; i++) {
                        double weight = Double.parseDouble(weightFields[i].getText());
                        // Ensure weights are positive
                        if (weight <= 0) throw new NumberFormatException();
                        weights[i] = weight;
                    }

                    // Clear existing adjacencies for all vertices
                    A.adjacencies.clear();
                    B.adjacencies.clear();
                    C.adjacencies.clear();
                    D.adjacencies.clear();
                    E.adjacencies.clear();
                    F.adjacencies.clear();

                    // Add adjacencies based on the input weights
                    A.adjacencies.add(new Road(B, weights[0]));
                    B.adjacencies.add(new Road(A, weights[0]));
                    A.adjacencies.add(new Road(C, weights[1]));
                    C.adjacencies.add(new Road(A, weights[1]));
                    A.adjacencies.add(new Road(F, weights[2]));
                    F.adjacencies.add(new Road(A, weights[2]));
                    B.adjacencies.add(new Road(C, weights[3]));
                    C.adjacencies.add(new Road(B, weights[3]));
                    B.adjacencies.add(new Road(D, weights[4]));
                    D.adjacencies.add(new Road(B, weights[4]));
                    C.adjacencies.add(new Road(D, weights[5]));
                    D.adjacencies.add(new Road(C, weights[5]));
                    C.adjacencies.add(new Road(F, weights[6]));
                    F.adjacencies.add(new Road(C, weights[6]));
                    D.adjacencies.add(new Road(E, weights[7]));
                    E.adjacencies.add(new Road(D, weights[7]));
                    F.adjacencies.add(new Road(E, weights[8]));
                    E.adjacencies.add(new Road(F, weights[8]));

                    // Create an instance of the Dijkstra algorithm and compute paths from vertex A
                    Algorithm dijkstra = new Algorithm();
                    dijkstra.computePaths(A);

                    // Print the distance and paths to all vertices
                    for (Vertex v : vertices) {
                        System.out.println("Distance to " + v + ": " + v.minDistance);
                        List<List<Vertex>> paths = dijkstra.getAllShortestPathsTo(v);
                        for (List<Vertex> path : paths) {
                            System.out.println("Path: " + path);
                        }
                    }

                    // Get the shortest paths to vertex E
                    List<List<Vertex>> shortestPaths = dijkstra.getAllShortestPathsTo(E);
                    StringBuilder shortestPathText = new StringBuilder();
                    shortestPathText.append("Shortest Path(s) to E: ");
                    // Build a string representation of the shortest paths
                    for (List<Vertex> path : shortestPaths) {
                        for (Vertex vertex : path) {
                            shortestPathText.append(vertex.name).append(" ");
                        }
                        shortestPathText.append("; ");
                    }

                    // Update the graph panel with the shortest paths and repaint
                    graphPanel.updateGraph(vertices, shortestPaths, true, shortestPathText.toString());
                    graphPanel.repaint();

                    // Refresh the input panel
                    inputPanel.removeAll();
                    frame.revalidate();
                    frame.repaint();
                } catch (NumberFormatException ex) {
                    // Show error message if input is invalid
                    JOptionPane.showMessageDialog(frame, "Please enter valid positive weights for all roads.");
                }
            }
        });
    }
}
