//entry....

import java.util.*;

public class Vertex implements Comparable<Vertex> {
    public final String name;
    public List<Road> adjacencies = new ArrayList<>();
    public double minDistance = Double.POSITIVE_INFINITY;
    public Vertex previous;

    public Vertex(String name) {
        this.name = name;
    }

    public String toString() {
        return name;
    }

    public int compareTo(Vertex other) {
        return Double.compare(minDistance, other.minDistance);
    }
}
