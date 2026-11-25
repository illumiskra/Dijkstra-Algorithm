//entry...

// Road.java
// This class represents an edge in the graph with a target vertex and a weight

public class Road {
    public final Vertex target;
    public final double weight;

    public Road(Vertex target, double weight) {
        this.target = target;
        this.weight = weight;
    }
}

