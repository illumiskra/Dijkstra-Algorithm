//entry...
import javax.swing.*;
import java.awt.*;
import java.util.List;

public class GraphPanel extends JPanel {
    private List<Vertex> vertices;
    private List<Vertex> path;
    private boolean showWeights;

    public void updateGraph(List<Vertex> vertices, List<Vertex> path, boolean showWeights) {
        this.vertices = vertices;
        this.path = path;
        this.showWeights = showWeights;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        if (vertices == null) return;

        int radius = 20;
        int[][] positions = {
                {100, 100}, // A
                {200, 200}, // B
                {300, 100}, // C
                {400, 200}, // D
                {500, 100}, // E
                {350, 30}  // F
        };

        for (int i = 0; i < vertices.size(); i++) {
            Vertex v = vertices.get(i);
            int x = positions[i][0];
            int y = positions[i][1];

            for (Road road : v.adjacencies) {
                Vertex target = road.target;
                int targetIndex = vertices.indexOf(target);
                int targetX = positions[targetIndex][0];
                int targetY = positions[targetIndex][1];

                g2.drawLine(x + radius / 2, y + radius / 2, targetX + radius / 2, targetY + radius / 2);

                // Draw the weight of the road if showWeights is true
                if (showWeights) {
                    int midX = (x + targetX) / 2;
                    int midY = (y + targetY) / 2;
                    g2.setColor(Color.BLUE);
                    g2.drawString(Double.toString(road.weight), midX, midY);
                    g2.setColor(Color.BLACK);
                }
            }
        }

        for (int i = 0; i < vertices.size(); i++) {
            Vertex v = vertices.get(i);
            int x = positions[i][0];
            int y = positions[i][1];
            g2.setColor(Color.WHITE);
            g2.fillOval(x, y, radius, radius);
            g2.setColor(Color.BLACK);
            g2.drawOval(x, y, radius, radius);
            g2.drawString(v.name, x + radius / 4, y + radius / 2);
        }

        if (path != null && showWeights) {
            g2.setColor(Color.RED);
            for (int i = 0; i < path.size() - 1; i++) {
                Vertex v = path.get(i);
                Vertex next = path.get(i + 1);
                int indexV = vertices.indexOf(v);
                int indexNext = vertices.indexOf(next);

                int x1 = positions[indexV][0] + radius / 2;
                int y1 = positions[indexV][1] + radius / 2;
                int x2 = positions[indexNext][0] + radius / 2;
                int y2 = positions[indexNext][1] + radius / 2;

                g2.drawLine(x1, y1, x2, y2);
            }
        }
    }
}
