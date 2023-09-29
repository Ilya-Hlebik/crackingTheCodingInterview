package Ch_16_Moderate.Q16_21_Sum_Swap;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        int[] array1 = {1, 1, 1, 2, 2, 4};
        int[] array2 = {3, 3, 3, 6};
        int[] swaps = findSwapValues(array1, array2);
        if (swaps == null) {
            System.out.println("null");
        } else {
            System.out.println(swaps[0] + " " + swaps[1]);
        }
    }

    private static int[] findSwapValues(int[] array1, int[] array2) {
        int array1Size = Arrays.stream(array1).sum();
        int array2Size = Arrays.stream(array2).sum();
        if (array1Size == array2Size){
            return null;
        }
        for (int i = 0; i < array1Size; i++) {
            for (int j = 0; j< array2Size; j++) {
                if (array1Size - array1[i] + array2[j] == array2Size - array2[j] + array1[i]){
                    return new int[]{array1[i], array2[j]};
                }
            }
        }
        return null;
    }
}
