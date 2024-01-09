package Ch_16_Moderate.Q16_22_Langtons_Ant;

public enum Direction {
    UP, DOWN, LEFT, RIGHT;

    public Direction moveClockWise() {
        switch (this) {
            case UP:
                return RIGHT;
            case RIGHT:
                return DOWN;
            case DOWN:
                return LEFT;
            default:
                return UP;
        }
    }

    public Direction moveCounterClockWise() {
        switch (this) {
            case UP:
                return LEFT;
            case LEFT:
                return DOWN;
            case DOWN:
                return RIGHT;
            default:
                return UP;
        }
    }
}
