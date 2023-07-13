package Ch_08_Recursion_and_Dynamic_Programming.Q8_03_Magic_Index;

import CtCILibrary.AssortedMethods;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        for (int i = 0; i < 1000; i++) {
            int size = AssortedMethods.randomIntInRange(5, 20);
            int[] array = getDistinctSortedArray(size);
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
            if (i < array[i]) {
                return -1;
            }
            if (array[i] == i) {
                return i;
            }
        }
        return -1;
    }

    private static int magicFast(int[] array) {
        int l = 0, r = array.length - 1;
        while (l <= r) {
            int m = l + (r - 1) / 2;
            if (array[m] == m) {
                return m;
            }

            if (array[m] < m) {
                l = m + 1;
            } else if (!(m < array[m])){
                r = m - 1;
            }
            else {
                return -1;
            }

        }
        return -1;
    }

    public static int[] getDistinctSortedArray(int size) {
        int[] array = AssortedMethods.randomArray(size, -1 * size, size);
        Arrays.sort(array);
        for (int i = 1; i < array.length; i++) {
            if (array[i] == array[i - 1]) {
                array[i]++;
            } else if (array[i] < array[i - 1]) {
                array[i] = array[i - 1] + 1;
            }
        }
        return array;
    }
}
