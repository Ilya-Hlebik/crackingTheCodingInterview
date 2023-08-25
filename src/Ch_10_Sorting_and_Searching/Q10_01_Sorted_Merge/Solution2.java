package Ch_10_Sorting_and_Searching.Q10_01_Sorted_Merge;

import CtCILibrary.AssortedMethods;

public class Solution2 {

    public static void main(String[] args) {
        int[] a = {2, 3, 4, 5, 6, 8, 10, 100, 0, 0, 0, 0, 0, 0};
        int[] b = {1, 4, 5, 6, 7, 7};
        merge(a, b, 8, 6);
        System.out.println(AssortedMethods.arrayToString(a));
    }

    private static void merge(int[] a, int[] b, int countA, int countB) {
        int aIndex = countA - 1;
        int bIndex = countB - 1;
        int lastAIndex = a.length - 1;

        while (bIndex >= 0) {
            if (aIndex >= 0 && a[aIndex] > b[bIndex]) {
                a[lastAIndex] = a[aIndex];
                aIndex--;
            } else {
                a[lastAIndex] = b[bIndex];
                bIndex--;
            }
            lastAIndex--;
        }
    }

}
