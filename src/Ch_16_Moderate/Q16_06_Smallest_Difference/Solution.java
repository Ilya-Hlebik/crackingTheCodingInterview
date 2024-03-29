package Ch_16_Moderate.Q16_06_Smallest_Difference;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        int[] array1 = {1, 3, 15, 11, 2};
        int[] array2 = {23, 127, 234, 19, 8};
        int difference = findSmallestDifference(array1, array2);
        System.out.println(difference);
    }

    private static int findSmallestDifference(int[] arrayA, int[] arrayB) {
        if (arrayA.length == 0 || arrayB.length == 0) return -1;

        Arrays.sort(arrayA);
        Arrays.sort(arrayB);
        int indexA = 0;
        int indexB = 0;
        int minDiff = Integer.MAX_VALUE;
        while (indexA < arrayA.length && indexB < arrayB.length) {
            minDiff = Math.min(minDiff, Math.abs(arrayA[indexA] - arrayB[indexB]));
            if (arrayA[indexA] < arrayB[indexB]) {
                indexA++;
            } else {
                indexB++;
            }
        }
        return minDiff;
    }
}
