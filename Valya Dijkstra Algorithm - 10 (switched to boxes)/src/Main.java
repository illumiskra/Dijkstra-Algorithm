//entry comment, who where when

//Have some comments at the top of each class explaining what do I use this class for

//add reading road weights from CSV file
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Vertex A = new Vertex("A"); //make the vertexes
        Vertex B = new Vertex("B");
        Vertex C = new Vertex("C");
        Vertex D = new Vertex("D");
        Vertex E = new Vertex("E");
        Vertex F = new Vertex("F");

        JFrame frame = new JFrame("Dijkstra's Algorithm");
        JPanel inputPanel = new JPanel();
        GraphPanel graphPanel = new GraphPanel();

        JTextField[] weightFields = new JTextField[9];
        String[] labels = {"A-B", "A-C", "A-F", "B-C", "B-D", "C-D", "C-F", "D-E", "E-F"};
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

        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double wAB = Double.parseDouble(weightFields[0].getText());
                    double wAC = Double.parseDouble(weightFields[1].getText());
                    double wAF = Double.parseDouble(weightFields[2].getText());
                    double wBC = Double.parseDouble(weightFields[3].getText());
                    double wBD = Double.parseDouble(weightFields[4].getText());
                    double wCD = Double.parseDouble(weightFields[5].getText());
                    double wCF = Double.parseDouble(weightFields[6].getText());
                    double wDE = Double.parseDouble(weightFields[7].getText());
                    double wEF = Double.parseDouble(weightFields[8].getText());

                    A.adjacencies.add(new Road(B, wAB)); //Relationships between the vertexes and lengths/weights of the roads
                    A.adjacencies.add(new Road(C, wAC));
                    A.adjacencies.add(new Road(F, wAF));
                    B.adjacencies.add(new Road(A, wAB));
                    B.adjacencies.add(new Road(C, wBC));
                    B.adjacencies.add(new Road(D, wBD));
                    C.adjacencies.add(new Road(A, wAC));
                    C.adjacencies.add(new Road(B, wBC));
                    C.adjacencies.add(new Road(D, wCD));
                    C.adjacencies.add(new Road(F, wCF));
                    D.adjacencies.add(new Road(B, wBD));
                    D.adjacencies.add(new Road(C, wCD));
                    D.adjacencies.add(new Road(E, wDE));
                    E.adjacencies.add(new Road(D, wDE));
                    E.adjacencies.add(new Road(F, wEF));
                    F.adjacencies.add(new Road(A, wAF));
                    F.adjacencies.add(new Road(C, wCF));
                    F.adjacencies.add(new Road(E, wEF));

                    List<Vertex> vertices = Arrays.asList(A, B, C, D, E, F); //Array list of vertexes
                    Algorithm dijkstra = new Algorithm();
                    dijkstra.computePaths(A); //run the algorithm (computePaths public void from Algorithm class)

                    for (Vertex v : vertices) {//print out the information
                        System.out.println("Distance to " + v + ": " + v.minDistance); //print out the distance from A point to current point
                        List<Vertex> path = dijkstra.getShortestPathTo(v); //run the shortest path method
                        System.out.println("Path: " + path); //print the string of vertexes
                    }

                    graphPanel.updateGraph(vertices, dijkstra.getShortestPathTo(E));
                    graphPanel.repaint();
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Please enter valid weights for all roads.");
                }
            }
        });
    }
}
