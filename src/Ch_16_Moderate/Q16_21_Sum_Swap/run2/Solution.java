package Ch_16_Moderate.Q16_21_Sum_Swap.run2;

import java.util.Arrays;
import java.util.HashSet;

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
        int sum1 = Arrays.stream(array1).sum();
        HashSet<Integer> arraySet = new HashSet<>();
        int sum2 = Arrays.stream(array2).peek(arraySet::add).sum();
        if ((sum1 - sum2) % 2 != 0) {
            return null;
        }
        for (int a : array1) {
            int b = ((sum2 - sum1) / 2 + a);
            if (arraySet.contains(b)) {
                return new int[]{a, b};
            }
        }
        return null;
    }
}
