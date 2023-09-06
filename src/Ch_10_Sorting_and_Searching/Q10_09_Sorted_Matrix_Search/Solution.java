package Ch_10_Sorting_and_Searching.Q10_09_Sorted_Matrix_Search;

import CtCILibrary.AssortedMethods;

public class Solution {
    public static void main(String[] args) {
        int M = 10;
        int N = 5;
        int[][] matrix = new int[M][N];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                matrix[i][j] = 10 * i + j;
            }
        }

        AssortedMethods.printMatrix(matrix);

        for (int i = -1; i < M; i++) {
            for (int j = -1; j < M; j++) {
                int v = 10 * i + j;
                System.out.println(v + ": " + findElement(matrix, v));
            }
        }
    }

    private static boolean findElement(int[][] matrix, int elem) {
        int row = 0;
        for (int i = 0; i < matrix.length; i++) {
            if (elem == matrix[i][0]) {
                return true;
            } else if (elem < matrix[i][0] || i == matrix.length - 1) {
                row = i == matrix.length - 1 || i == 0 ? i : i - 1;
                return binarySearch(matrix[row], elem);
            }
        }
        return false;
    }

    private static boolean binarySearch(int[] matrix, int elem) {
        return binarySearch(matrix, elem, 0, matrix.length - 1);
    }

    private static boolean binarySearch(int[] matrix, int elem, int start, int finish) {
        if (finish < start) {
            return false;
        }
        int middle = start + (finish - start) / 2;
        if (matrix[middle] == elem) {
            return true;
        } else if (matrix[middle] > elem) {
            return binarySearch(matrix, elem, start, middle - 1);
        } else {
            return binarySearch(matrix, elem, middle + 1, finish);
        }
    }
}
