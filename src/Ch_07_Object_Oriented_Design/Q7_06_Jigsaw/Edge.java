package Ch_07_Object_Oriented_Design.Q7_06_Jigsaw;

public class Edge {
    private Shape shape;
    private Piece parentPiece;
    private String code;

    public Edge(Shape shape, String code) {
        this.shape = shape;
        this.code = code;
    }

    public Shape getShape() {
        return shape;
    }

    public void setShape(Shape shape) {
        this.shape = shape;
    }

    public Piece getParentPiece() {
        return parentPiece;
    }

    public void setParentPiece(Piece parentPiece) {
        this.parentPiece = parentPiece;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String toString() {
        return code;
    }
}
