package Ch_16_Moderate.Q16_22_Langtons_Ant.run2;

import Ch_16_Moderate.Q16_22_Langtons_Ant.Direction;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        printKMoves(15);
    }

    private static void printKMoves(int k) {
        int row = 0;
        int column = 0;
        Direction direction = Direction.RIGHT;
        Set<Map.Entry<Integer, Integer>> blackSet = new HashSet<>();
        int minRow = Integer.MAX_VALUE;
        int minColumn = Integer.MAX_VALUE;
        int maxRow = Integer.MIN_VALUE;
        int maxColumn = Integer.MIN_VALUE;
        for (int i = 0; i < k; i++) {
            if (!blackSet.contains(Map.entry(row, column))) {
                blackSet.add(Map.entry(row, column));
                direction = direction.moveClockWise();
                Map.Entry<Integer, Integer> entry = moveForward(row, column, direction);
                row = entry.getKey();
                column = entry.getValue();
            } else {
                blackSet.remove(Map.entry(row, column));
                direction = direction.moveCounterClockWise();
                Map.Entry<Integer, Integer> entry = moveForward(row, column, direction);
                row = entry.getKey();
                column = entry.getValue();
            }
            minRow = Math.min(row, minRow);
            minColumn = Math.min(column, minColumn);
            maxRow = Math.max(row, maxRow);
            maxColumn = Math.max(column, maxColumn);
        }
        for (int i = minRow; i <= maxRow; i++) {
            for (int j = minColumn; j <= maxColumn; j++) {
                if (i == row && j == column) {
                    System.out.print(direction.toString().substring(0, 1));
                } else if (!blackSet.contains(Map.entry(i, j))) {
                    System.out.print("_");
                } else {
                    System.out.print("X");
                }
            }
            System.out.println();
        }
    }

    private static Map.Entry<Integer, Integer> moveForward(int row, int column, Direction direction) {
        switch (direction) {
            case UP:
                return Map.entry(row - 1, column);
            case DOWN:
                return Map.entry(row + 1, column);
            case LEFT:
                return Map.entry(row, column - 1);
            default:
                return Map.entry(row, column + 1);
        }
    }
}
