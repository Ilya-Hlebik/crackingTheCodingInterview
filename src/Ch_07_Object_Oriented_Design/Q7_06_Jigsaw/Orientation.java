package Ch_07_Object_Oriented_Design.Q7_06_Jigsaw;

public enum Orientation {
    LEFT,TOP,RIGHT,BOTTOM;
    public Orientation getOpposite() {
        switch (this) {
            case LEFT: return RIGHT;
            case RIGHT: return LEFT;
            case TOP: return BOTTOM;
            case BOTTOM: return TOP;
            default: return null;
        }
    }
    public Orientation getNext() {
        switch (this) {
            case LEFT: return TOP;
            case TOP: return RIGHT;
            case RIGHT: return BOTTOM;
            case BOTTOM: return LEFT;
            default: return null;
        }
    }

    public static void main(String[] args) {
        System.out.println(-1 %4);
    }
}
