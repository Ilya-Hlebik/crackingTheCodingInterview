package Ch_10_Sorting_and_Searching.Q10_09_Sorted_Matrix_Search;

import CtCILibrary.AssortedMethods;

public class Solution3 {
    private static boolean findElement(int[][] matrix, int elem) {
        Coordinate coordinate = dioganalBinarySearch(matrix, 0, matrix[0].length - 1, elem);
        if (coordinate.elementFounded){
            return true;
        }
        int columnMin = coordinate.x +1;
        int columnMax = matrix.length;
        int maxy = coordinate.y;
        return true;
    }

    private static Coordinate dioganalBinarySearch(int[][] matrix, int low, int high, int elem) {
        if (low > high) {
            return new Coordinate(high, high, false);
        }
        int mid = low + (high - low) / 2;

        if (matrix[mid][mid] == elem) {
            return new Coordinate(mid, mid, true);
        }
        if (matrix[mid][mid] > elem) {
            return dioganalBinarySearch(matrix, low, mid - 1, elem);
        } else {
            return dioganalBinarySearch(matrix, mid + 1, high, elem);
        }
    }

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
        System.out.println(56 + ": " + findElement(matrix, 47));
        for (int i = -1; i < M; i++) {
            for (int j = -1; j < M; j++) {
                int v = 10 * i + j;
                System.out.println(v + ": " + findElement(matrix, v));
            }
        }
    }

}

class Coordinate {
    int x;
    int y;
    boolean elementFounded = false;

    public Coordinate(int x, int y, boolean elementFounded) {
        this.x = x;
        this.y = y;
        this.elementFounded = elementFounded;
    }
}
