package Ch_10_Sorting_and_Searching.Q10_07_Missing_Int.run2;

import java.util.BitSet;

public class Solution {
    public static void main(String[] args) {
        int arr[] = new int[]{0, 1, 3, 5, 4, 7, 8, 2, 4};
        findOpenNUmber(arr);
    }

    private static void findOpenNUmber(int[] arr) {
        BitSet bitSet = new BitSet(Integer.MAX_VALUE);
        for (int i = 0; i < arr.length; i++) {
            bitSet.set(arr[i], true);
        }
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            if (!bitSet.get(i)) {
                System.out.println(i);
                return;
            }
        }
    }
}
