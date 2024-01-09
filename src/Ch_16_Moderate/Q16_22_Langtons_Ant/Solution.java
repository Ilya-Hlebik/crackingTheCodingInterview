package Ch_16_Moderate.Q16_22_Langtons_Ant;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        printKmoves(1000);
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
        printBoard(minRow, minColumn, maxRow, maxColumn, points);
        System.out.println();
    }

    private static void printBoard(int minRow, int minColumn, int maxRow, int maxColumn, Set<Point> points) {
        for (int i = minRow; i <= maxRow; i++) {
            for (int j = minColumn; j <= maxColumn; j++) {
                if (points.contains(new Point(i , j ))) {
                    System.out.print("X");
                } else {
                    System.out.print("_");
                }
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
