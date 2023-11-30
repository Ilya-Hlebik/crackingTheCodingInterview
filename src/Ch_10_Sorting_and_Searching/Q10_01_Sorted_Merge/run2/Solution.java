package Ch_10_Sorting_and_Searching.Q10_01_Sorted_Merge.run2;

import CtCILibrary.AssortedMethods;

public class Solution {
    public static void main(String[] args) {
        int[] a = {2, 3, 4, 5, 6, 8, 10, 100, 0, 0, 0, 0, 0, 0};
        int[] b = {1, 4, 5, 6, 7, 7};
        merge(a, b, 8, 6);
        System.out.println(AssortedMethods.arrayToString(a));
    }

    private static void merge(int[] a, int[] b, int aLength, int bLength) {
        for (int i = a.length - 1, j = bLength - 1; i >= 0; i--) {
            if (aLength > 0 && a[aLength - 1] > b[j]) {
                a[i] = a[aLength - 1];
                aLength--;
            } else {
                a[i] = b[j];
                j--;
            }
        }
    }
}
