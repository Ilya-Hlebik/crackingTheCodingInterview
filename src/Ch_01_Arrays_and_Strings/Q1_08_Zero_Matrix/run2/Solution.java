package Ch_01_Arrays_and_Strings.Q1_08_Zero_Matrix.run2;


import CtCILibrary.AssortedMethods;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        int nrows = 10;
        int ncols = 15;
        int[][] matrix1 = AssortedMethods.randomMatrix(nrows, ncols, -10, 10);

        AssortedMethods.printMatrix(matrix1);

        setZeros(matrix1);

        System.out.println();

        AssortedMethods.printMatrix(matrix1);
    }

    public static void setZeros(int[][] matrix) {
        Set<Integer> columnsTobeZero = new HashSet<>();
        Set<Integer> rowsTobeZero = new HashSet<>();

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    columnsTobeZero.add(j);
                    rowsTobeZero.add(i);
                }
            }
        }
        for (Integer column : columnsTobeZero) {
            for (int j = 0; j < matrix.length; j++) {
                matrix[j][column] = 0;
            }
        }
        for (Integer row : rowsTobeZero) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[row][j] = 0;
            }
        }
    }
}
