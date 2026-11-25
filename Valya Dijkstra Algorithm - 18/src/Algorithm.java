import java.util.*;

public class Algorithm {
    public void computePaths(Vertex source) {
        source.minDistance = 0.;
        PriorityQueue<Vertex> vertexQueue = new PriorityQueue<>();
        vertexQueue.add(source);

        while (!vertexQueue.isEmpty()) {
            Vertex u = vertexQueue.poll();

            for (Road e : u.adjacencies) {
                Vertex v = e.target;
                double weight = e.weight;
                double distanceThroughU = u.minDistance + weight;

                if (distanceThroughU < v.minDistance) {
                    vertexQueue.remove(v);
                    v.minDistance = distanceThroughU;
                    v.previous.clear();
                    v.previous.add(u);
                    vertexQueue.add(v);
                } else if (distanceThroughU == v.minDistance) {
                    v.previous.add(u);
                }
            }
        }
    }

    public List<List<Vertex>> getAllShortestPathsTo(Vertex target) {
        List<List<Vertex>> paths = new ArrayList<>();
        getAllPathsRecursive(target, new ArrayList<>(), paths);
        return paths;
    }

    private void getAllPathsRecursive(Vertex vertex, List<Vertex> currentPath, List<List<Vertex>> paths) {
        currentPath.add(vertex);
        if (vertex.previous.isEmpty()) {
            List<Vertex> path = new ArrayList<>(currentPath);
            Collections.reverse(path);
            paths.add(path);
        } else {
            for (Vertex prev : vertex.previous) {
                getAllPathsRecursive(prev, new ArrayList<>(currentPath), paths);
            }
        }
    }
}
