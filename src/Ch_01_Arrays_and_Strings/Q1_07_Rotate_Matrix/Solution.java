package Ch_01_Arrays_and_Strings.Q1_07_Rotate_Matrix;

public class Solution {
    public static boolean rotate(int[][] matrix) {
        if (matrix.length == 0 || matrix.length != matrix[0].length) return false; // Not a square
        int[][] matrix_copy = new int[matrix.length][matrix.length];
        for (int j = 0; j < matrix.length; j++) {
            for (int i = matrix.length - 1, p = 0; i >= 0; i--, p++) {
                matrix_copy[j][p] = matrix[i][j];
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0;  j < matrix.length; j++) {
                matrix[i][j] = matrix_copy[i][j];
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] matrix = randomMatrix(3, 3, 0, 9);
        printMatrix(matrix);
        rotate(matrix);
        System.out.println();
        printMatrix(matrix);
    }

    public static int[][] randomMatrix(int M, int N, int min, int max) {
        int[][] matrix = new int[M][N];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                matrix[i][j] = randomIntInRange(min, max);
            }
        }
        int[][] ints = {
                {7, 2, 0}, {2, 2, 5}, {7, 5, 9}
        };
        return ints;
    }

    public static int randomIntInRange(int min, int max) {
        return randomInt(max + 1 - min) + min;
    }

    public static int randomInt(int n) {
        return (int) (Math.random() * n);
    }

    public static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] < 10 && matrix[i][j] > -10) {
                    System.out.print(" ");
                }
                if (matrix[i][j] < 100 && matrix[i][j] > -100) {
                    System.out.print(" ");
                }
                if (matrix[i][j] >= 0) {
                    System.out.print(" ");
                }
                System.out.print(" " + matrix[i][j]);
            }
            System.out.println();
        }
    }
}
