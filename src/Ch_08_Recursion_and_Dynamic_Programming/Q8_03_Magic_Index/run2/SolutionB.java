package Ch_08_Recursion_and_Dynamic_Programming.Q8_03_Magic_Index.run2;

import CtCILibrary.AssortedMethods;

import static Ch_08_Recursion_and_Dynamic_Programming.Q8_03_Magic_Index.SolutionB.getSortedArray;

public class SolutionB {
    public static void main(String[] args) {
        for (int i = 0; i < 1000; i++) {
            int size = AssortedMethods.randomIntInRange(5, 20);
            int[] array = getSortedArray(size);
            int v2 = magicFast(array);
            if (v2 == -1 && magicSlow(array) != -1) {
                int v1 = magicSlow(array);
                System.out.println("Incorrect value: index = -1, actual = " + v1 + " " + i);
                System.out.println(AssortedMethods.arrayToString(array));
                break;
            } else if (v2 > -1 && array[v2] != v2) {
                System.out.println("Incorrect values: index= " + v2 + ", value " + array[v2]);
                System.out.println(AssortedMethods.arrayToString(array));
                break;
            }
        }
    }

    private static int magicSlow(int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == i) {
                return i;
            }
        }
        return -1;
    }

    private static int magicFast(int[] array) {
        return magicFast(array, 0, array.length - 1);
    }

    private static int magicFast(int[] array, int min, int max) {
        if (max < min) {
            return -1;
        }
        int mid = (min + max) / 2;
        int midValue = array[mid];
        if (mid == midValue) {
            return mid;
        }
        int leftIndex = Math.min(mid - 1, midValue);
        int left = magicFast(array, min, leftIndex);
        if (left != -1) {
            return left;
        }
        int rightIndex = Math.max(mid + 1, midValue);
        return magicFast(array, rightIndex, max);
    }
}
