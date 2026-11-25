public class Road {
    Vertex start;
    Vertex end;
    double length;

    public Road(Vertex start, Vertex end, double length) {
        this.start = start;
        this.end = end;
        this.length = length;
    }

    public Vertex getStart() {
        return start;
    }

    public void setStart(Vertex start) {
        this.start = start;
    }

    public Vertex getEnd() {
        return end;
    }

    public void setEnd(Vertex end) {
        this.end = end;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }
}
