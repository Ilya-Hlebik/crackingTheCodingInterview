package Ch_08_Recursion_and_Dynamic_Programming.Q8_12_Eight_Queens;

import java.util.ArrayList;

public class Solution2 {
    public static int GRID_SIZE = 8;

    public static void main(String[] args) {
        ArrayList<Integer[][]> results = new ArrayList<>();
        Integer[][] columns = new Integer[GRID_SIZE][GRID_SIZE];
        clear(columns);
        placeQueens(0, columns, results);
        printBoards(results);
        System.out.println(results.size());
    }

    private static void placeQueens(int row, Integer[][] columns, ArrayList<Integer[][]> results) {
        if (row == GRID_SIZE) {
            results.add(columns.clone());
        } else {
            for (int col = 0; col < GRID_SIZE; col++) {
                if (checkValid(columns, row, col)) {
                    columns[row] = col;
                    placeQueens(row + 1, columns, results);
                }

            }
        }
    }

    private static boolean checkValid(Integer[][] columns, int row, int col) {
        for (int i = 0; i < row; i++) {
            Integer value = columns[i][col];
            if (value != -1) {
                return false;
            }

            columns[i][]

        }
        Integer tempColumn = columns[i];

        if (tempColumn == col) {
            return false;
        }

        if (Math.abs(row - i) == Math.abs(tempColumn - col)) {
            return false;
        }


    }
        return true;
}

    public static void clear(Integer[][] columns) {
        for (int i = 0; i < GRID_SIZE; i++) {
            for (int j = 0; j < GRID_SIZE; j++) {
                columns[i][j] = -1;
            }

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
