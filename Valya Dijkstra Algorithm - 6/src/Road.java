public class Road {
    private double weight;
    private Vertex targetVertex;

    public Road(double weight, Vertex targetVertex) {
        this.weight = weight;
        this.targetVertex = targetVertex;
    }

    public double getWeight() {
        return weight;
    }

    public Vertex getTargetVertex() {
        return targetVertex;
    }
}
