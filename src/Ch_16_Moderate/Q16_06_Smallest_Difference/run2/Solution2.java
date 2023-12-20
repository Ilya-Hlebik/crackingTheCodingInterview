package Ch_16_Moderate.Q16_06_Smallest_Difference.run2;

import java.util.Arrays;

public class Solution2 {
    public static void main(String[] args) {
        int[] array1 = {1, 3, 15, 11, 2};
        int[] array2 = {23, 127, 234, 19, 8};
        int difference = findSmallestDifference(array1, array2);
        System.out.println(difference);
    }

    private static int findSmallestDifference(int[] array1, int[] array2) {
        int minDiff = Integer.MAX_VALUE;
        Arrays.sort(array1);
        Arrays.sort(array2);
        int i = 0;
        int j = 0;
        while (j < array2.length && i < array1.length) {
            int elem1 = array1[i];
            int elem2 = array2[j];
            minDiff = Math.min(Math.abs(elem1 - elem2), minDiff);
            if (elem1 > elem2) {
                j++;
            } else {
                i++;
            }
        }
        return minDiff;
    }
}
