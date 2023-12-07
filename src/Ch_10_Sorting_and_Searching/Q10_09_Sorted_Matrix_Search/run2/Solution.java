package Ch_10_Sorting_and_Searching.Q10_09_Sorted_Matrix_Search.run2;

import CtCILibrary.AssortedMethods;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Random;

public class Solution {
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

    private static boolean findElement(int[][] matrix, int v) {
        int maxI = matrix.length;
        int maxJ = matrix[maxI - 1].length;
        for (int i = 0; i < maxI; i++) {
            for (int j = 0; j < maxJ; j++) {
                if (matrix[i][j] == v) {
                    System.out.println(i + " " + j);
                    return true;
                }
                if (matrix[i][j] > v) {
                    maxJ = j;
                    break;
                }
            }
        }
        return false;
    }
}
