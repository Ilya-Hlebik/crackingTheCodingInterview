package Ch_16_Moderate.Q16_22_Langtons_Ant;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {

        for (int i = 0; i < 1; i++) {
            printKmoves(15);
        }
    }

    private static void printKmoves(int k) {
        int currentRow = 0;
        int currentColumn = 0;
        int minRow = 0;
        int minColumn = 0;
        int maxRow = 0;
        int maxColumn = 0;
        Direction currentDirection = Direction.RIGHT;
        Set<Point> points = new HashSet<>();
        for (int i = 0; i < k; i++) {
            Point point = new Point(currentRow, currentColumn);
            if (points.contains(point)) {
                points.remove(point);
                currentDirection = currentDirection.moveCounterClockWise();
                currentRow += calculateRow(currentDirection);
                currentColumn += calculateColumn(currentDirection);
            } else {
                points.add(point);
                currentDirection = currentDirection.moveClockWise();
                currentRow += calculateRow(currentDirection);
                currentColumn += calculateColumn(currentDirection);
            }
            minRow = Math.min(minRow, currentRow);
            minColumn = Math.min(minColumn, currentColumn);
            maxRow = Math.max(maxRow, currentRow);
            maxColumn = Math.max(maxColumn, currentColumn);
        }
        if (minRow < 0) {
            maxRow += -minRow;
        }
        if (minColumn < 0) {
            maxColumn += -minColumn;
        }
        printBoard(minRow, minColumn, maxRow, maxColumn, points);
        System.out.println();
    }

    private static void printBoard(int minRow, int minColumn, int maxRow, int maxColumn, Set<Point> points) {
        String[][] board = new String[maxRow + 1][maxColumn + 1];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (points.contains(new Point(i + minRow, j + minColumn))) {
                    board[i][j] = "X";
                } else {
                    board[i][j] = "_";
                }
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
    }

    private static int calculateColumn(Direction currentDirection) {
        if (currentDirection == Direction.LEFT) {
            return -1;
        } else if (currentDirection == Direction.RIGHT) {
            return 1;
        }
        return 0;
    }

    private static int calculateRow(Direction currentDirection) {
        if (currentDirection == Direction.DOWN) {
            return 1;
        } else if (currentDirection == Direction.UP) {
            return -1;
        }
        return 0;
    }
}

enum Direction {
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

class Point {
    int row;
    int column;

    public Point(int row, int column) {
        this.row = row;
        this.column = column;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return row == point.row &&
                column == point.column;
    }

    @Override
    public int hashCode() {
        return Objects.hash(row, column);
    }
}
