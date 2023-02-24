package Ch_01_Arrays_and_Strings.Q1_08_Zero_Matrix;

import java.util.ArrayList;
import java.util.List;

import static Ch_01_Arrays_and_Strings.Q1_07_Rotate_Matrix.Solution.printMatrix;
import static Ch_01_Arrays_and_Strings.Q1_07_Rotate_Matrix.Solution.randomMatrix;

public class Solution {

    public static void setZeros(int[][] matrix) {
        int rowsLength = matrix.length;
        int columnsLength = matrix[rowsLength-1].length;
        List<Pair> zeroElements = new ArrayList<>();
        for (int i = 0; i < rowsLength; i++) {
            for (int j = 0; j < columnsLength; j++) {
                if (matrix[i][j] ==0){
                    zeroElements.add(new Pair(i, j));
                }
            }
        }
        for (int i = 0; i < zeroElements.size(); i++) {

            Pair pair = zeroElements.get(i);
            int row = pair.row;
            int column = pair.column;
            //go left
            for (int l = column; l>=0; l--){
                matrix[row][l] = 0;
            }
            //go right
            for (int l = column; l< columnsLength ; l++){
                matrix[row][l] = 0;
            }
            //go up
            for (int l = row; l>=0 ; l--){
                matrix[l][column] = 0;
            }

            //go down
            for (int l = row; l< rowsLength; l++){
                matrix[l][column] = 0;
            }
        }
        System.out.println();
    }
    static class Pair {
        public int row;
        public int column;

        public Pair(int row, int column) {
            this.row = row;
            this.column = column;
        }
    }

    public static boolean matricesAreEqual(int[][] m1, int[][] m2) {
        if (m1.length != m2.length || m1[0].length != m2[0].length) {
            return false;
        }

        for (int k = 0; k < m1.length; k++) {
            for (int j = 0; j < m1[0].length; j++) {
                if (m1[k][j] != m2[k][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    public static int[][] cloneMatrix(int[][] matrix) {
        int[][] c = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                c[i][j] = matrix[i][j];
            }
        }
        return c;
    }

    public static void main(String[] args) {
        int nrows = 10;
        int ncols = 15;
        int[][] matrix1 = randomMatrix(nrows, ncols, -10, 10);

        printMatrix(matrix1);

        setZeros(matrix1);

        System.out.println();

        printMatrix(matrix1);
    }
}
