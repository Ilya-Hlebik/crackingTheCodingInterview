package Ch_10_Sorting_and_Searching.Q10_08_Find_Duplicates;

import CtCILibrary.AssortedMethods;

public class Solution {
    public static void main(String[] args) {
        int[] array = AssortedMethods.randomArray(30, 1, 30);
        System.out.println(AssortedMethods.arrayToString(array));
        checkDuplicates(array);
    }

    public static void checkDuplicates(int[] array) {
        BitSet bs = new BitSet(32000);
        for (int i = 0; i < array.length; i++) {
            int num = array[i];
            int num0 = num - 1; // bitset starts at 0, numbers start at 1
            if (bs.get(num0)) {
                System.out.println(num);
            } else {
                bs.set(num0);
            }
        }
    }
}

class BitSet {
    private int[] bitset;

    public BitSet(int size) {
        this.bitset = new int[(size >> 5) + 1];
    }

    public boolean get(int pos) {
        return (bitset[pos >> 5] & 1 << pos) != 0;
    }

    public void set(int pos) {
        bitset[pos >> 5] |= 1 << pos;
    }
}
