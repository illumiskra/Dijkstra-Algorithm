import java.util.ArrayList;
import java.util.List;


public class Vertex implements Comparable<Vertex>{
    String Name;
    static boolean Visited;
    static List<Road> Neighbours;
    double distance;
    Vertex predecessor;


    public Vertex(String name){
        this.Name = name;
        Neighbours = new ArrayList<>();
        distance = Double.MAX_VALUE;
        predecessor = null;
    }

    //getters and setters:


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

    public void AddNeighbour(Road e){
        Neighbours.add(e);
    }

    public String getName() {

        return Name;
    }

    public boolean isVisited() {

        return Visited;
    }

    public void setVisited(boolean visited)
    {
        Visited = visited;
    }

    public List<Road> getNeighbours() {

        return Neighbours;
    }

    public void setNeighbours(List<Road> neighbours) {

        Neighbours = neighbours;
    }

    @Override
    public int compareTo(Vertex o) {
        return Double.compare(this.getDistance(), o.getDistance());
    }
}
