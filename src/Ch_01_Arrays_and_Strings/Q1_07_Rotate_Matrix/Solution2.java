package Ch_01_Arrays_and_Strings.Q1_07_Rotate_Matrix;

import static Ch_01_Arrays_and_Strings.Q1_07_Rotate_Matrix.Solution.printMatrix;
import static Ch_01_Arrays_and_Strings.Q1_07_Rotate_Matrix.Solution.randomMatrix;

public class Solution2 {
    public static boolean rotate(int[][] matrix) {
        if (matrix.length == 0 || matrix.length != matrix[0].length) return false; // Not a square
        int n = matrix.length;

        for (int layer = 0; layer < n / 2; layer++) {
            int first = layer;
            int last = n - 1 - layer;
            for (int i = first; i < last; i++) {
                int offset = i - first;
                int top = matrix[first][i]; // save top

                // left -> top
                matrix[first][i] = matrix[last - offset][first];

                // bottom -> left
                matrix[last - offset][first] = matrix[last][last - offset];

                // right -> bottom
                matrix[last][last - offset] = matrix[i][last];

                // top -> right
                matrix[i][last] = top; // right <- saved top
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

}
