package Ch_05_Bit_Manipulation.Q5_06_Conversion;

import CtCILibrary.AssortedMethods;

public class Solution2 {
    public static void main(String[] args) {
        int a = -23432;
        int b = 512132;
        System.out.println(a + ": " + AssortedMethods.toFullBinaryString(a));
        System.out.println(b + ": " + AssortedMethods.toFullBinaryString(b));
        int nbits = bitSwapRequired(a, b);
        int nbits2 = bitSwapRequired2(a, b);
        System.out.println("Required number of bits: " + nbits + " " + nbits2);
    }

    private static int bitSwapRequired2(int a, int b) {
        int count = 0;
        for (int i = a ^ b; i != 0; i = i & (i - 1)) {
            count++;
        }
        return count;
    }

    private static int bitSwapRequired(int a, int b) {
        int count = 0;
        for (int i = a ^ b; i != 0; i >>>= 1) {
            count += i & 1;
        }
        return count;
    }
}
