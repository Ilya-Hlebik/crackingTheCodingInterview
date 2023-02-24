package Ch_01_Arrays_and_Strings.Q1_08_Zero_Matrix;

import static Ch_01_Arrays_and_Strings.Q1_07_Rotate_Matrix.Solution.printMatrix;
import static Ch_01_Arrays_and_Strings.Q1_07_Rotate_Matrix.Solution.randomMatrix;
import static Ch_01_Arrays_and_Strings.Q1_08_Zero_Matrix.Solution.cloneMatrix;
import static Ch_01_Arrays_and_Strings.Q1_08_Zero_Matrix.Solution.matricesAreEqual;

public class Solution2 {

    public static void setZeros(int[][] matrix) {
        int rowsLength = matrix.length;
        int columnsLength = matrix[rowsLength - 1].length;
        boolean[] zeroRows = new boolean[rowsLength];
        boolean[] zeroColumns = new boolean[columnsLength];
        for (int i = 0; i < rowsLength; i++) {
            for (int j = 0; j < columnsLength; j++) {
                if (matrix[i][j] == 0) {
                    zeroRows[i] = true;
                    zeroColumns[j] = true;
                }
            }
        }
        for (int i = 0; i < zeroRows.length; i++) {
            if (zeroRows[i]) {
                for (int j = 0; j < columnsLength; j++) {
                    matrix[i][j] = 0;
                }
            }
        }
        for (int i = 0; i < zeroColumns.length; i++) {
            if (zeroColumns[i]) {
                for (int j = 0; j < rowsLength; j++) {
                    matrix[j][i] = 0;
                }
            }
        }
        System.out.println();
    }



    public static void main(String[] args) {
        int nrows = 10;
        int ncols = 15;
        int[][] matrix1 = randomMatrix(nrows, ncols, -10, 10);
        int[][] matrix2 = cloneMatrix(matrix1);

        printMatrix(matrix1);

        Solution.setZeros(matrix1);
        setZeros(matrix2);

        System.out.println();

        printMatrix(matrix1);
        System.out.println();
        printMatrix(matrix2);

        if (matricesAreEqual(matrix1, matrix2)) {
            System.out.println("Equal");
        } else {
            System.out.println("Not Equal");
        }
    }
}
