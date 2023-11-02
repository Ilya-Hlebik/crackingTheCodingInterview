package Ch_05_Bit_Manipulation.Q5_01_Insertion.run2;

import CtCILibrary.AssortedMethods;

import static Ch_05_Bit_Manipulation.Q5_01_Insertion.Solution.updateBits2;

public class Solution {

    public static void main(String[] args) {
        int a = 23427834;
        System.out.println(AssortedMethods.toFullBinaryString(a));
        int b = 31;
        System.out.println(AssortedMethods.toFullBinaryString(b));
        int c = updateBits(a, b, 2, 7);
        int d = updateBits2(a, b, 2, 7);
        System.out.println(AssortedMethods.toFullBinaryString(c));
        System.out.println(AssortedMethods.toFullBinaryString(d));
        System.out.println(AssortedMethods.toFullBinaryString(c).equals(AssortedMethods.toFullBinaryString(d)));
    }

    private static int updateBits(int n, int m, int i, int j) {
        return (~(~0 << i) | (~0 << j + 1)) & n | (m << i);
    }

}
