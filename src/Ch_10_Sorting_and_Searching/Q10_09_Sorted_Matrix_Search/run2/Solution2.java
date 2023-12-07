package Ch_10_Sorting_and_Searching.Q10_09_Sorted_Matrix_Search.run2;

import CtCILibrary.AssortedMethods;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Random;

public class Solution2 {
    public static void main(String[] args) {
        int M = 4;
        int N = 4;
        Queue<Integer> queue = new LinkedList<>();
        queue.addAll(List.of(15, 20, 40, 85, 20, 35, 80, 95, 30, 55, 95, 105, 40, 80, 100, 120));
        int[][] matrix = new int[M][N];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                matrix[i][j] = queue.poll();
            }
        }


        AssortedMethods.printMatrix(matrix);
        Random random = new Random();

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                boolean addAdditionalNumber = random.nextBoolean();
                System.out.println((matrix[i][j] + (addAdditionalNumber?1:0))  + ": " + findElement(matrix, (matrix[i][j] + (addAdditionalNumber?1:0))));
            }
        }
    }

    private static boolean findElement(int[][] matrix, int elem) {
        for (int i = 0; i < matrix.length; i++) {
            if (elem >= matrix[i][0] && elem <= matrix[i][matrix[i].length - 1]) {
                Response response = binarySearch(matrix[i], 0, matrix[i].length - 1, elem);
                if (response.isSuccess) {
                    System.out.println(i + " " + response.row);
                    return true;
                }
            }
        }
        return false;
    }

    private static Response binarySearch(int[] matrix, int min, int max, int elem) {
        if (min > max) {
            return new Response(false);
        }
        int middle = min + (max - min) / 2;
        if (matrix[middle] == elem) {
            return new Response(true, middle);
        } else if (matrix[middle] > elem) {
            return binarySearch(matrix, min, middle - 1, elem);
        }
        return binarySearch(matrix, middle + 1, max, elem);
    }
}

class Response {
    boolean isSuccess;
    int row;

    public Response(boolean isSuccess) {
        this.isSuccess = isSuccess;
    }

    public Response(boolean isSuccess, int row) {
        this.isSuccess = isSuccess;
        this.row = row;
    }
}
