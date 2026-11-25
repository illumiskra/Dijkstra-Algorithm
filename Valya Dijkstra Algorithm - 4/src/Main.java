//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        System.out.println("God, pls help me finish this project");

        Vertex A = new Vertex("A");
        Vertex B = new Vertex("B");
        Vertex C = new Vertex("C");
        Vertex D = new Vertex("D");
        Vertex E = new Vertex("E");
        Vertex F = new Vertex("F");


        //add the lengths of the roads between the Vertexes
        //eg A to B (9)-
        //A to F (15)-
        //A to D (4)-
        //B to E (12)-
        //B to D (6)-
        //F to E (5)-
        //D to F (12)-
        //D to C (6)
        //C to E (7)
        A.AddNeighbour(new Road(9,A,B));
        A.AddNeighbour(new Road(15,A,F));
        A.AddNeighbour(new Road(4,A,D));
        B.AddNeighbour(new Road(12,B,E));
        B.AddNeighbour(new Road(6,B,D));
        F.AddNeighbour(new Road(5,F,E));
        D.AddNeighbour(new Road(12,D,F));
        D.AddNeighbour(new Road(6,D,C));
        C.AddNeighbour(new Road(7,C,E));

        Algorithm dijkstraAlgorithm = new Algorithm();
        dijkstraAlgorithm.Compute(A); //run the algorithm
        System.out.println("Shortest Path from A to A: " + A.getDistance()); //after the algorithm is finished print out the result
    }
}