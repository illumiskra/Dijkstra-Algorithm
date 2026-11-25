import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileI0 {
    public static List<Road> readWeights(String fileName) {
        List<Road> roads = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split("\t");
                if (parts.length == 2) {
                    double weight = Double.parseDouble(parts[0].trim());
                    String[] vertices = parts[1].split(" - ");
                    if (vertices.length == 2) {
                        String start = vertices[0].trim();
                        String end = vertices[1].trim();
                        roads.add(new Road(start, end, weight));
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return roads;
    }
}