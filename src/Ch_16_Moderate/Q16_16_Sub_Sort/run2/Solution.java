package Ch_16_Moderate.Q16_16_Sub_Sort.run2;

import Ch_16_Moderate.Q16_16_Sub_Sort.Range;

public class Solution {
    public static void main(String[] args) {
        int[] array = {1, 2, 4, 7, 10, 11, 8, 12, 5, 6, 16, 18, 19};

        Range r = findUnsortedSequence(array);
        System.out.println(r.toString());
        System.out.println(array[r.start] + ", " + array[r.end]);
    }

    private static Range findUnsortedSequence(int[] array) {

        int min = Integer.MAX_VALUE;
        int leftIndex = 0;
        for (int i = array.length - 1; i >= 0; i--) {
            if (min < array[i]) {
                leftIndex = i;
            }
            min = Math.min(min, array[i]);
        }
        int max = Integer.MIN_VALUE;
        int rightIndex = 0;
        for (int i = 0; i < array.length; i++) {
            if (max > array[i]) {
                rightIndex = i;
            }
            max = Math.max(max, array[i]);
        }

        return new Range(leftIndex, rightIndex);
    }
}
