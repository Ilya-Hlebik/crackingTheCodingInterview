package Ch_10_Sorting_and_Searching.Q10_08_Find_Duplicates.run2;

import CtCILibrary.AssortedMethods;

import java.util.BitSet;

public class Solution {
    public static void main(String[] args) {
        int[] array = AssortedMethods.randomArray(32000, 1, 32000);
        System.out.println(AssortedMethods.arrayToString(array));
        checkDuplicates(array);
    }

    private static void checkDuplicates(int[] array) {
        BitSet bitSet = new BitSet(array.length);
        for (int element : array) {
            if (bitSet.get(element)) {
                System.out.println(element);
            } else {
                bitSet.set(element);
            }
        }
    }
}
