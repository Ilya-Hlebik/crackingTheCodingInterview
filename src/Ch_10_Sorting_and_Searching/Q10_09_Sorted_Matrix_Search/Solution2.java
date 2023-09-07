package Ch_10_Sorting_and_Searching.Q10_09_Sorted_Matrix_Search;

import CtCILibrary.AssortedMethods;

public class Solution2 {
    public static void main(String[] args) {
        int M = 4;
        int N = 4;
        int[][] matrix = new int[M][N];
        int temp = 15;
        int temp2 = 15;
        for (int i = 0; i < M; i++) {
            temp2 += 7;
            for (int j = 0; j < N; j++) {
                matrix[i][j] = temp;
                temp += 5;
            }
            temp = temp2 + 10;
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
        for (int i = matrix[0].length - 1, row =0; i >= 0 && row < matrix.length; i--) {
            if (matrix[row][i] == elem) {
                return true;
            } else if (!(matrix[row][i] > elem)) {
                i++;
                row++;
            }
        }
        return false;
    }
}
