// Algorithm class
// This class contains the implementation of Dijkstra's algorithm.
// It computes the shortest paths from a source vertex to all other vertices
// and retrieves all possible shortest paths to a target vertex.

//import
import java.util.*;

public class Algorithm {
    // Method to compute the shortest paths from the source vertex
    public void computePaths(Vertex source) {
        source.minDistance = 0.; // Set the source distance to zero
        PriorityQueue<Vertex> vertexQueue = new PriorityQueue<>(); // Priority queue to process vertices
        vertexQueue.add(source); // Add the source vertex to the queue

        // Process vertices in the priority queue
        while (!vertexQueue.isEmpty()) {
            Vertex u = vertexQueue.poll(); // Get the vertex with the smallest distance

            // Visit each edge adjacent to the current vertex
            for (Path e : u.adjacencies) {
                Vertex v = e.target; // Get the target vertex of the edge
                double weight = e.weight; // Get the weight of the edge
                double distanceThroughU = u.minDistance + weight; // Calculate the new distance

                // If the new distance is shorter, update the target vertex
                if (distanceThroughU < v.minDistance) {
                    vertexQueue.remove(v); // Remove the target vertex from the queue
                    v.minDistance = distanceThroughU; // Update the minimum distance
                    v.previous.clear(); // Clear previous vertices
                    v.previous.add(u); // Add the current vertex as a predecessor
                    vertexQueue.add(v); // Add the target vertex back to the queue
                } else if (distanceThroughU == v.minDistance) {
                    v.previous.add(u); // If the distance is the same, add the current vertex as an additional predecessor
                }
            }
        }
    }

    // Method to get all shortest paths to the target vertex
    public List<List<Vertex>> getAllShortestPathsTo(Vertex target) {
        List<List<Vertex>> paths = new ArrayList<>(); // List to hold all shortest paths
        getAllPathsRecursive(target, new ArrayList<>(), paths); // Recursive method to build paths
        return paths; // Return the list of shortest paths
    }

    // Recursive method to build all paths from the source to the target
    private void getAllPathsRecursive(Vertex vertex, List<Vertex> currentPath, List<List<Vertex>> paths) {
        currentPath.add(vertex); // Add the current vertex to the path
        // If there are no predecessors, the path is complete
        if (vertex.previous.isEmpty()) {
            List<Vertex> path = new ArrayList<>(currentPath); // Create a new path list
            Collections.reverse(path); // Reverse the path to get the correct order
            paths.add(path); // Add the path to the list of paths
        } else {
            // Recursively build paths from each predecessor
            for (Vertex prev : vertex.previous) {
                getAllPathsRecursive(prev, new ArrayList<>(currentPath), paths);
            }
        }
    }
}
