package Ch_07_Object_Oriented_Design.Q7_06_Jigsaw;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Piece {
    private final static int NUMBER_OF_EDGES = 4;
    private HashMap<Orientation, Edge> edges = new HashMap<>();

    public Piece(List<Edge> edgeList) {
        Orientation[] orientations = Orientation.values();
        for (int i = 0; i < edgeList.size(); i++) {
            Edge edge = edgeList.get(i);
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

    private void rotateEdgesBy(int numberRotations) {
        HashMap<Orientation, Edge> rotated = new HashMap<>(edges);

        if (numberRotations < 0){
            numberRotations += NUMBER_OF_EDGES;
        }
        for (int i = 0; i < numberRotations; i++) {
            HashMap<Orientation, Edge> copy = new HashMap<>(rotated);
            for (Map.Entry<Orientation, Edge> orientationEdgeEntry : copy.entrySet()) {
                Orientation key = orientationEdgeEntry.getKey();
                Edge value = orientationEdgeEntry.getValue();
                Orientation next = key.getNext();
                rotated.put(next, value);
            }
        }
        edges = rotated;
    }


    private Orientation getOrientation(Edge current) {
        return edges.entrySet().stream()
                .filter(orientationEdgeEntry -> orientationEdgeEntry.getValue() == current)
                .map(Map.Entry::getKey)
                .findFirst().orElse(null);
    }
}
