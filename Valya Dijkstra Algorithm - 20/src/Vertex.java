import java.util.ArrayList;
import java.util.List;

public class Vertex implements Comparable<Vertex> {
    public final String name;
    public List<Road> adjacencies;
    public double minDistance = Double.POSITIVE_INFINITY;
    public List<Vertex> previous;  // Use a list to track multiple predecessors

    public Vertex(String name) {
        this.name = name;
        this.adjacencies = new ArrayList<>();
        this.previous = new ArrayList<>();
    }

    @Override
    public int compareTo(Vertex other) {
        return Double.compare(minDistance, other.minDistance);
    }

    @Override
    public String toString() {
        return name;
    }
}
