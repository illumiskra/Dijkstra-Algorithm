import java.util.PriorityQueue;

public class Algorithm {

    //PriorityQueue<Vertex> queue;

    public void dijkstra(Vertex sourceVertex) {
        sourceVertex.setDistance(0); //initial distance is 0
        PriorityQueue<Vertex> vertexQueue = new PriorityQueue<>(); //make a queue where I will be storing the vertexes
        vertexQueue.add(sourceVertex); //add the initial (A) Vertex to the queue
        sourceVertex.setVisited(true); //set this vertex as visited

        while (!vertexQueue.isEmpty()) { //as long as the queue is not empty
            Vertex currentVertex = vertexQueue.poll(); //last vertex
            System.out.println("check1");

            for (Road road : currentVertex.getAdjacenciesList()) {
                Vertex adjacentVertex = road.getTargetVertex();
                double edgeWeight = road.getWeight(); //get weight from Road -> Main
                double newDistance = currentVertex.getDistance() + edgeWeight; //update the distance
                System.out.println("check2");

                if (newDistance < adjacentVertex.getDistance()) { //if new distance is smaller than the prev then...
                    vertexQueue.remove(adjacentVertex); //remove the previous element from the queue
                    adjacentVertex.setDistance(newDistance);
                    adjacentVertex.setPredecessor(currentVertex);
                    vertexQueue.add(adjacentVertex); //add the new distance and set the current vertex as the last one in the queue
                    System.out.println("check3"); //this one does not work for some reason
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
