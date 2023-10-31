package Ch_08_Recursion_and_Dynamic_Programming.Q8_12_Eight_Queens.run2;

import java.util.ArrayList;

public class Solution {
    public static int GRID_SIZE = 8;

    public static void main(String[] args) {
        ArrayList<Integer[]> results = new ArrayList<>();
        Integer[] columns = new Integer[GRID_SIZE];
        clear(columns);
        placeQueens(0, columns, results);
        printBoards(results);
        System.out.println(results.size());
    }

    private static void placeQueens(int row, Integer[] columns, ArrayList<Integer[]> results) {
        if (row == GRID_SIZE) {
            results.add(columns.clone());
            return;
        }
        for (int j = 0; j < GRID_SIZE; j++) {
            if (checkValid(columns, row, j)) {
                columns[row] = j;
                placeQueens(row + 1, columns, results);
            }
        }
    }

    private static boolean checkValid(Integer[] columns, int row, int column) {
        for (int i = 0; i < row; i++) {
            Integer tempColumn = columns[i];
            if (tempColumn == column) {
                return false;
            }
            if (Math.abs(row - i) == Math.abs(column - tempColumn)) {
                return false;
            }
        }
        return true;
    }

    public static void clear(Integer[] columns) {
        for (int i = 0; i < GRID_SIZE; i++) {
            columns[i] = -1;
        }
    }

    public static void printBoards(ArrayList<Integer[]> boards) {
        for (int i = 0; i < boards.size(); i++) {
            Integer[] board = boards.get(i);
            printBoard(board);
        }
    }

    public static void printBoard(Integer[] columns) {
        drawLine();
        for (int i = 0; i < GRID_SIZE; i++) {
            System.out.print("|");
            for (int j = 0; j < GRID_SIZE; j++) {
                if (columns[i] == j) {
                    System.out.print("Q|");
                } else {
                    System.out.print(" |");
                }
            }
            System.out.print("\n");
            drawLine();
        }
        System.out.println("");
    }

    private static void drawLine() {
        StringBuilder line = new StringBuilder();
        for (int i = 0; i < GRID_SIZE * 2 + 1; i++)
            line.append('-');
        System.out.println(line.toString());
    }
}
