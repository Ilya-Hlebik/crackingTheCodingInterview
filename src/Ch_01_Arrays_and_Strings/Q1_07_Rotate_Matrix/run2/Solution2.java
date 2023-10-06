package Ch_01_Arrays_and_Strings.Q1_07_Rotate_Matrix.run2;

import CtCILibrary.AssortedMethods;

public class Solution2 {
    public static void main(String[] args) {
        int[][] matrix = AssortedMethods.randomMatrix(4, 4, 0, 9);
        AssortedMethods.printMatrix(matrix);
        rotate2(matrix);
        System.out.println();
        AssortedMethods.printMatrix(matrix);
    }

    /*
        1,2,3,4
        5,6,7,8
        9,8,7,5

     *     1, 2, 3
     *     4, 5, 6
     *     7, 8, 9
     *
     *     7, 4, 1
     *     8, 5, 2
     *     9, 6, 3
     *
     *    [0, 0] - > [0,2]
     *    [0, 1] - > [1,2]
     *    [0,2] -  > [2,2]
     *
     *    [1, 0] - > [0,1]
     *    [1, 1] - > [1,1]
     *    [1, 2] - > [2,1]
     *
     *    [2, 0] - > [0,0]
     *    [2, 1] - > [1,0]
     *    [2, 2] - > [2,0]
     *
     * */

    private static void rotate(int[][] matrix) {
        int lengthOfMatrix = matrix.length;
        for (int layer = 0; layer < lengthOfMatrix / 2; layer++) {
            int last = lengthOfMatrix - 1 - layer;
            for (int i = layer; i < last; i++) {
                int offset = i - layer;
                int top = matrix[layer][i];
                matrix[layer][i] = matrix[last - offset][layer];
                matrix[last - offset][layer] = matrix[last][last - offset];
                matrix[last][last - offset] = matrix[i][last];
                matrix[i][last] = top;
            }

        }
    }

    private static void rotate2(int[][] matrix) {
        int lengthOfMatrix = matrix.length;
        int[][] matrix_copy = new int[matrix.length][matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0, p = lengthOfMatrix - 1; j < matrix[i].length && p >= 0; j++, p--) {
                matrix_copy[i][j] = matrix[p][i];
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = matrix_copy[i][j];
            }
        }
    }
}
