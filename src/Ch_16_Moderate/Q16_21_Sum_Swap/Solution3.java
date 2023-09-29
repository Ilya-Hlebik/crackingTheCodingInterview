package Ch_16_Moderate.Q16_21_Sum_Swap;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class Solution3 {
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
        if (array1Size == array2Size) {
            return null;
        }
        boolean isMinus = array1Size > array2Size;
        Set<Integer> collect = Arrays.stream(array2)
                .boxed()
                .collect(Collectors.toSet());
        int diff = Math.abs(array1Size - array2Size);
        for (int a : array1) {
            int b = Math.abs(a + (diff / 2 * (isMinus ? -1 : 1)));
            if (collect.contains(b)) {
                return new int[]{a, b};
            }
        }
        return null;
    }
}
