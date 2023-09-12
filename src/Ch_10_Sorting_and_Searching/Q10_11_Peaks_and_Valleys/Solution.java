package Ch_10_Sorting_and_Searching.Q10_11_Peaks_and_Valleys;

import CtCILibrary.AssortedMethods;

public class Solution {
    public static boolean confirmValleyPeak(int[] array) {
        for (int i = 1; i < array.length - 1; i++) {
            int prev = array[i - 1];
            int curr = array[i];
            int next = array[i + 1];
            if ((prev > curr || curr < next) && (prev < curr || curr > next)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            int[] originalArray = AssortedMethods.randomArray(10, 0, 100);
            int[] arrayA = originalArray.clone();
            sortValleyPeak(arrayA);
            if (!confirmValleyPeak(arrayA)) {
                System.out.println(AssortedMethods.arrayToString(originalArray));
                System.out.println(AssortedMethods.arrayToString(arrayA));
                break;
            }
        }
    }

    private static void sortValleyPeak(int[] arrayA) {
        for (int i = 0; i < arrayA.length; i += 2) {
            if (i > 0 && arrayA[i] < arrayA[i - 1]) {
                swap(arrayA, i, i - 1);
            }
            if (i < arrayA.length - 1 && arrayA[i] < arrayA[i + 1]) {
                swap(arrayA, i, i + 1);
            }
        }
    }

    private static void swap(int[] arrayA, int i, int j) {
        int temp = arrayA[i];
        arrayA[i] = arrayA[j];
        arrayA[j] = temp;
    }
}
