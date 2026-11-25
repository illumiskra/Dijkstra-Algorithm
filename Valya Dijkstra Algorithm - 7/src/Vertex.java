import java.util.ArrayList;
import java.util.List;


public class Vertex implements Comparable<Vertex>{
    private String name;
    private List<Road> adjacenciesList;
    private boolean visited;
    private Vertex predecessor;
    private double distance = Double.MAX_VALUE;


    public Vertex(String name) {
        this.name = name;
        this.adjacenciesList = new ArrayList<>();
    }

    //getters and setters:
    public void addNeighbour(Road road) {
        this.adjacenciesList.add(road);
    }

    public String getName() {
        return name;
    }

    public List<Road> getAdjacenciesList() {
        return adjacenciesList;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public Vertex getPredecessor() {
        return predecessor;
    }

    public void setPredecessor(Vertex predecessor) {
        this.predecessor = predecessor;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    @Override
    public int compareTo(Vertex otherVertex) {
        return Double.compare(this.distance, otherVertex.getDistance());
    }

    @Override
    public String toString() {
        return this.name;
    }
}
