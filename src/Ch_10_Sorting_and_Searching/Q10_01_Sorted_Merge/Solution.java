package Ch_10_Sorting_and_Searching.Q10_01_Sorted_Merge;

import CtCILibrary.AssortedMethods;

public class Solution {
    public static void main(String[] args) {
        int[] a = {2, 3, 4, 5, 6, 8, 10, 100, 0, 0, 0, 0, 0, 0};
        int[] b = {1, 4, 5, 6, 7, 7};
        merge(a, b, 8, 6);
        System.out.println(AssortedMethods.arrayToString(a));
    }

    /**
     * Merges array
     *
     * @param a      first array
     * @param b      second array
     * @param countA number of "real" elements in a
     * @param countB number of "real" elements in b
     */
    public static void merge(int[] a, int[] b, int countA, int countB) {
        for (int bIndex = countB - 1; bIndex >= 0; bIndex--) {
            for (int aIndex = countA - 1; aIndex >= 0; aIndex--) {
                if (a[aIndex] <= b[bIndex] || (a[aIndex] > b[bIndex] && aIndex == 0)) {
                    for (int j = a.length - 1; j > aIndex; j--) {
                        a[j] = a[j - 1];
                    }
                    a[aIndex > 0 ? aIndex + 1 : 0] = b[bIndex];
                    countA--;
                    break;
                }
            }
        }
    }
}
