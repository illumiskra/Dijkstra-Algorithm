import java.util.PriorityQueue;

public class Algorithm {

    //PriorityQueue<Vertex> queue;

    public void dijkstra(Vertex sourceVertex) {
        sourceVertex.setDistance(0);
        PriorityQueue<Vertex> vertexQueue = new PriorityQueue<>();
        vertexQueue.add(sourceVertex);
        sourceVertex.setVisited(true);

        while (!vertexQueue.isEmpty()) {
            Vertex currentVertex = vertexQueue.poll();

            for (Road road : currentVertex.getAdjacenciesList()) {
                Vertex adjacentVertex = road.getTargetVertex();
                double edgeWeight = road.getWeight();
                double newDistance = currentVertex.getDistance() + edgeWeight;

                if (newDistance < adjacentVertex.getDistance()) {
                    vertexQueue.remove(adjacentVertex);
                    adjacentVertex.setDistance(newDistance);
                    adjacentVertex.setPredecessor(currentVertex);
                    vertexQueue.add(adjacentVertex);
                }
            }
            currentVertex.setVisited(true);
        }
    }

    /*
    public Algorithm(){
        queue = new PriorityQueue<>();
    }

    public void Compute(Vertex source){


        source.setDistance(0);
        queue.add(source);

        while (queue.isEmpty()){
            Vertex current = queue.poll();
            for (Road e : current.getNeighbours()){
                Vertex end = e.getEnd();
                double l = e.getLength(); //l is for length (I didn't want to make the variables names too similar)

                if (!end.isVisited()){
                    if(current.getDistance() + l < end.getDistance()){
                        end.setDistance(current.getDistance() + l);
                        if(queue.contains(end)){
                            queue.remove((end));
                        queue.add(end);
                        end.setPredecessor(current);
                        }
                    }
                }
            }
            current.setVisited(true);\
        }
    }
    */
    //check if the vertex = visited
    //infinite length towards other vertexes changes to the distance + new distance
    //
}
