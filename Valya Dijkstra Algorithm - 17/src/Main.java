// Main.java
// Entry point for Dijkstra's Algorithm Visualization
// This class sets up the GUI and handles user inputs for the graph

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Vertex A = new Vertex("A");
        Vertex B = new Vertex("B");
        Vertex C = new Vertex("C");
        Vertex D = new Vertex("D");
        Vertex E = new Vertex("E");
        Vertex F = new Vertex("F");

        Map<String, Vertex> vertexMap = new HashMap<>();
        vertexMap.put("A", A);
        vertexMap.put("B", B);
        vertexMap.put("C", C);
        vertexMap.put("D", D);
        vertexMap.put("E", E);
        vertexMap.put("F", F);

        JFrame frame = new JFrame("Dijkstra's Algorithm");
        JPanel inputPanel = new JPanel();
        GraphPanel graphPanel = new GraphPanel();

        JTextField[] weightFields = new JTextField[9];
        String[] labels = {"A-B", "A-C", "A-F", "B-C", "B-D", "C-D", "C-F", "D-E", "F-E"};
        for (int i = 0; i < weightFields.length; i++) {
            inputPanel.add(new JLabel(labels[i]));
            weightFields[i] = new JTextField(5);
            inputPanel.add(weightFields[i]);
        }

        JButton startButton = new JButton("Start");
        inputPanel.add(startButton);

        frame.setLayout(new BorderLayout());
        frame.add(inputPanel, BorderLayout.NORTH);
        frame.add(graphPanel, BorderLayout.CENTER);

        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        List<Vertex> vertices = Arrays.asList(A, B, C, D, E, F);
        graphPanel.updateGraph(vertices, null, false);
        graphPanel.repaint();

        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double[] weights = new double[9];
                    for (int i = 0; i < weightFields.length; i++) {
                        double weight = Double.parseDouble(weightFields[i].getText());
                        if (weight <= 0) throw new NumberFormatException(); // Check for zero or negative numbers
                        weights[i] = weight;
                    }

                    A.adjacencies.clear();
                    B.adjacencies.clear();
                    C.adjacencies.clear();
                    D.adjacencies.clear();
                    E.adjacencies.clear();
                    F.adjacencies.clear();

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

                    Algorithm dijkstra = new Algorithm();
                    dijkstra.computePaths(A);

                    for (Vertex v : vertices) {
                        System.out.println("Distance to " + v + ": " + v.minDistance);
                        List<Vertex> path = dijkstra.getShortestPathTo(v);
                        System.out.println("Path: " + path);
                    }

                    graphPanel.updateGraph(vertices, dijkstra.getShortestPathTo(E), true);
                    graphPanel.repaint();

                    // Remove input fields and start button after running the algorithm
                    inputPanel.removeAll();
                    frame.revalidate();
                    frame.repaint();
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Please enter valid positive weights for all roads.");
                }
            }
        });
    }
}
