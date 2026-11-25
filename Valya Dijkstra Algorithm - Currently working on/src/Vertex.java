// Vertex class
// This class represents a node in the graph.
// It stores the vertex name, adjacency list (edges), minimum distance from the source,
// and a list of previous vertices in the shortest paths.

import java.util.ArrayList;
import java.util.List;

public class Vertex implements Comparable<Vertex> {
    public final String name; // Name of the vertex
    public List<Path> adjacencies; // List of edges (roads) from this vertex to others
    public double minDistance = Double.POSITIVE_INFINITY; // Minimum distance from the source vertex
    public List<Vertex> previous;  // List to track multiple predecessors for shortest paths

    // Constructor to initialize the vertex with a name
    public Vertex(String name) {
        this.name = name;
        this.adjacencies = new ArrayList<>();
        this.previous = new ArrayList<>();
    }

    @Override
    public int compareTo(Vertex other) {
        // Compare vertices based on their minimum distance for priority queue ordering
        return Double.compare(minDistance, other.minDistance);
    }

    @Override
    public String toString() {
        return name; // Return the name of the vertex
    }
}
