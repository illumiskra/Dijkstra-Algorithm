import java.util.ArrayList;
import java.util.List;


public class Vertex {
    String Name;
    static boolean Visited;
    static List<Road> Neighbours;

    public Vertex(String name){
        this.Name = name;
        Neighbours = new ArrayList<>();
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
}
