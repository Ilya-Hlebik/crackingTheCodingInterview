package Ch_10_Sorting_and_Searching.Q10_11_Peaks_and_Valleys.run2;

import CtCILibrary.AssortedMethods;

public class Solution {
    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            int[] originalArray = AssortedMethods.randomArray(23321, 0, 100);
            int[] arrayA = originalArray.clone();
            sortValleyPeak(arrayA);
            if (!confirmValleyPeak(arrayA)) {
                System.out.println(AssortedMethods.arrayToString(originalArray));
                System.out.println(AssortedMethods.arrayToString(arrayA));
                break;
            }
        }
    }

    private static boolean confirmValleyPeak(int[] arrayA) {
        boolean shouldBePeak = true;
        for (int i = 0; i < arrayA.length - 1; i++) {
            if (shouldBePeak ?
                    !isPeak(arrayA[i], i == 0 ? null : arrayA[i - 1], arrayA[i + 1])
                    : !isValley(arrayA[i], arrayA[i - 1], arrayA[i + 1])) {
                return false;
            }
            shouldBePeak = !shouldBePeak;
        }
        return true;
    }

    private static boolean isPeak(int elem, Integer left, Integer right) {
        return (left == null || elem >= left) && (right == null || elem >= right);
    }

    private static boolean isValley(int elem, Integer left, Integer right) {
        return (left == null || elem <= left) && (right == null || elem <= right);
    }

    private static void sortValleyPeak(int[] arrayA) {
        for (int i = 0; i < arrayA.length; i += 2) {
            if (i > 0 && arrayA[i] < arrayA[i - 1]) {
                int temp = arrayA[i];
                arrayA[i] = arrayA[i - 1];
                arrayA[i - 1] = temp;
            }
            if (i < arrayA.length - 1 && arrayA[i] < arrayA[i + 1]) {
                int temp = arrayA[i];
                arrayA[i] = arrayA[i + 1];
                arrayA[i + 1] = temp;
            }
        }
    }
}
