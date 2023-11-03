package Ch_05_Bit_Manipulation.Q5_06_Conversion.run2;

import CtCILibrary.AssortedMethods;

public class Solution {
    public static void main(String[] args) {
        int a = -23432;
        int b = 512132;
        System.out.println(a + ": " + AssortedMethods.toFullBinaryString(a));
        System.out.println(b + ": " + AssortedMethods.toFullBinaryString(b));
        int nbits = bitSwapRequired(a, b);
        System.out.println("Required number of bits: " + nbits);
    }

    private static int bitSwapRequired(int a, int b) {
        int count = 0;
        for (int c = a ^ b; c != 0; c >>>= 1) {
            count += c & 1;
        }
        return count;
    }

}
