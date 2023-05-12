package Ch_07_Object_Oriented_Design.Q7_06_Jigsaw;

import java.util.HashMap;

public class Piece {
    private final static int NUMBER_OF_EDGES = 4;
    private HashMap<Orientation, Edge> edges = new HashMap<>();

    public HashMap<Orientation, Edge> getEdges() {
        return edges;
    }

    public void setEdges(HashMap<Orientation, Edge> edges) {
        this.edges = edges;
    }
}
