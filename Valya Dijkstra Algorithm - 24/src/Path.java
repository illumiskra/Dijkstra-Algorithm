// Road class
// This class represents an edge in the graph with a target vertex and a weight.
// It is used to define the connections between vertices.

public class Path {
    public final Vertex target; // Target vertex of the edge
    public final double weight; // Weight of the edge

    // Constructor to initialize the edge with a target vertex and weight
    public Path(Vertex target, double weight) {
        this.target = target;
        this.weight = weight;
    }
}
