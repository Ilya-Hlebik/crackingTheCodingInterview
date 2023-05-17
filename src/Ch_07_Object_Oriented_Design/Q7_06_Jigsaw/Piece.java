package Ch_07_Object_Oriented_Design.Q7_06_Jigsaw;

import java.util.HashMap;
import java.util.Map;

public class Piece {
    private final static int NUMBER_OF_EDGES = 4;
    private HashMap<Orientation, Edge> edges = new HashMap<>();

    public Piece(Edge[] edgeList) {
        Orientation[] orientations = Orientation.values();
        for (int i = 0; i < edgeList.length; i++) {
            Edge edge = edgeList[i];
            edge.setParentPiece(this);
            edges.put(orientations[i], edge);
        }
    }

    public HashMap<Orientation, Edge> getEdges() {
        return edges;
    }

    public void setEdges(HashMap<Orientation, Edge> edges) {
        this.edges = edges;
    }

    public boolean isCorner() {
        Orientation[] orientations = Orientation.values();
        for (int i = 0; i < orientations.length; i++) {
            Shape current = edges.get(orientations[i]).getShape();
            Shape next = edges.get(orientations[(i + 1) % NUMBER_OF_EDGES]).getShape();
            if (current == Shape.FLAT && next == Shape.FLAT) {
                return true;
            }
        }
        return false;
    }

    public Edge getEdgeByOrientation(Orientation orientation) {
        return edges.get(orientation);
    }

    public void setEdgeAsOrientation(Edge current, Orientation orientation) {
        Orientation currentOrientation = getOrientation(current);
        rotateEdgesBy(orientation.ordinal() - currentOrientation.ordinal());
    }

    public void rotateEdgesBy(int numberRotations) {
        Orientation[] orientations = Orientation.values();
        HashMap<Orientation, Edge> rotated = new HashMap<Orientation, Edge>();

        numberRotations = numberRotations % NUMBER_OF_EDGES;
        if (numberRotations < 0) numberRotations += NUMBER_OF_EDGES;

        for (int i = 0; i < orientations.length; i++) {
            Orientation oldOrientation = orientations[(i - numberRotations + NUMBER_OF_EDGES) % NUMBER_OF_EDGES];
            Orientation newOrientation = orientations[i];
            rotated.put(newOrientation, edges.get(oldOrientation));
        }
        edges = rotated;
    }


    private Orientation getOrientation(Edge current) {
        return edges.entrySet().stream()
                .filter(orientationEdgeEntry -> orientationEdgeEntry.getValue() == current)
                .map(Map.Entry::getKey)
                .findFirst().orElse(null);
    }

    public Edge getMatchingEdge(Edge edgeToMatch) {
        for (Edge edge : edges.values()) {
            if (edgeToMatch.fitsWith(edge)) {
                return edge;
            }
        }
        return null;
    }


    public String toString() {
        StringBuilder sb = new StringBuilder();
        Orientation[] orientations = Orientation.values();
        for (Orientation o : orientations) {
            sb.append(edges.get(o).toString() + ",");
        }
        return "[" + sb.toString() + "]";
    }
}
