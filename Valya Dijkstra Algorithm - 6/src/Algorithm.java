import java.util.PriorityQueue;

public class Algorithm {

    PriorityQueue<Vertex> queue;

    public Algorithm(){
        queue = new PriorityQueue<>();
    }

    public void Compute(Vertex source){

        /*
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
            current.setVisited(true);
            */
        }
    }
    //check if the vertex = visited
    //infinite length towards other vertexes changes to the distance + new distance
    //
}
