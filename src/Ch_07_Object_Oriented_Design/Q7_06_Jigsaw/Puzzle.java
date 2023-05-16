package Ch_07_Object_Oriented_Design.Q7_06_Jigsaw;

import java.util.HashMap;
import java.util.LinkedList;

public class Puzzle {
    private LinkedList<Piece> pieces;
    private Piece[][] solution;
    private int size;

    public Puzzle(int size, LinkedList<Piece> pieces) {
        this.pieces = pieces;
        this.size = size;
    }

    public boolean solve() {
        LinkedList<Piece> cornerPieces = new LinkedList<>();
        LinkedList<Piece> borderPieces = new LinkedList<>();
        LinkedList<Piece> insidePieces = new LinkedList<>();
        groupPieces(cornerPieces, borderPieces, insidePieces);
        solution = new Piece[size][size];
        for (int row = 0; row < size; row++) {
            for (int column = 0; column < size; column++) {
                LinkedList<Piece> piecesToSearch = getPieceListToSearch(cornerPieces, borderPieces, insidePieces, row, column);
                fitNextEdge(piecesToSearch, row, column);
            }
        }
        return true;
    }

    private void fitNextEdge(LinkedList<Piece> piecesToSearch, int row, int column) {
        if (row == 0 && column == 0) {
            Piece piece = piecesToSearch.remove();
            orientTopLeftCorner(piece);
            solution[0][0] = piece;
        } else {

        }
    }

    private void orientTopLeftCorner(Piece piece) {
        if (piece.isCorner()) {
            return;
        }
        Orientation[] orientations = Orientation.values();
        for (int i = 0; i < orientations.length; i++) {
            Edge current = piece.getEdgeByOrientation(orientations[i]);
            Edge next = piece.getEdgeByOrientation(orientations[(i + 1) % orientations.length]);
            if (current.getShape() == Shape.FLAT && next.getShape() == Shape.FLAT) {
                piece.setEdgeAsOrientation(current, Orientation.LEFT);
                return;
            }
        }
    }

    private LinkedList<Piece> getPieceListToSearch(LinkedList<Piece> cornerPieces, LinkedList<Piece> borderPieces, LinkedList<Piece> insidePieces, int row, int column) {
        if (isBorderIndex(row) && isBorderIndex(column)) {
            return cornerPieces;
        } else if (isBorderIndex(row) || isBorderIndex(column)) {
            return borderPieces;
        } else {
            return insidePieces;
        }
    }

    private boolean isBorderIndex(int index) {
        return index == 0 || index == size - 1;
    }

    private void groupPieces(LinkedList<Piece> cornerPieces, LinkedList<Piece> borderPieces, LinkedList<Piece> insidePieces) {
        for (Piece piece : pieces) {
            HashMap<Orientation, Edge> edges = piece.getEdges();
            int countOfFlat = 0;
            for (Edge value : edges.values()) {
                if (value.getShape().equals(Shape.FLAT)) {
                    countOfFlat++;
                }
            }
            if (countOfFlat == 0) {
                insidePieces.add(piece);
            } else if (countOfFlat == 1) {
                borderPieces.add(piece);
            } else {
                cornerPieces.add(piece);
            }
        }
    }
}
