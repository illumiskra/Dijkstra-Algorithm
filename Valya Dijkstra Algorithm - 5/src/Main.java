//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
//ADD FILE HEADING
//Valentina Cherkovskaya
//Year 13, term 2
//CSC335 Project
//Animation of Dijkstra algorithm
public class Main {
    public static void main(String[] args) {
        //System.out.println("God, pls help me finish this project");

        Vertex vertexA = new Vertex("A");
        Vertex vertexB = new Vertex("B");
        Vertex vertexC = new Vertex("C");
        Vertex vertexD = new Vertex("D");
        Vertex vertexE = new Vertex("E");
        Vertex vertexF = new Vertex("F");


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
        vertexA.addNeighbour(new Road(9, vertexA, vertexB));
        vertexA.addNeighbour(new Road(15, vertexA, vertexF));
        vertexA.addNeighbour(new Road(4, vertexA, vertexD));
        vertexB.addNeighbour(new Road(6, vertexB, vertexD));
        vertexB.addNeighbour(new Road(12, vertexB, vertexE));
        vertexC.addNeighbour(new Road(7, vertexC, vertexE));
        vertexD.addNeighbour(new Road(12, vertexD, vertexF));
        vertexD.addNeighbour(new Road(6, vertexD, vertexC));
        vertexF.addNeighbour(new Road(5, vertexF, vertexE));



        Algorithm dijkstraAlgorithm = new Algorithm();
        dijkstraAlgorithm.Compute(vertexA);

        System.out.println("Shortest Path from A to F: " + vertexF.getDistance());
    }
}