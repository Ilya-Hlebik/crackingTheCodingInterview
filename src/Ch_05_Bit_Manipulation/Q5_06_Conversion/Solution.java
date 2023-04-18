package Ch_05_Bit_Manipulation.Q5_06_Conversion;

import CtCILibrary.AssortedMethods;

public class Solution {

    public static void main(String[] args) {
        int a = -23432;
        int b = 512132;
        System.out.println(a + ":  " + AssortedMethods.toFullBinaryString(a));
        System.out.println(b + ":  " + AssortedMethods.toFullBinaryString(b));
        System.out.println((a ^ b) + ": " + AssortedMethods.toFullBinaryString(a ^ b));
        int nbits = bitSwapRequired(a, b);
        int nbits2 = bitSwapRequired2(a, b);
        System.out.println("Required number of bits: " + nbits + " " + nbits2);
    }

    private static int bitSwapRequired(int a, int b) {
        String aString = Integer.toBinaryString(a);
        String bString = Integer.toBinaryString(b);
        int count = Math.abs(aString.length() - bString.length());
        for (int i = 0; i < Math.min(aString.length(), bString.length()); i++) {
            if ((a & (1 << i)) != (b & (1 << i))) {
                count++;
            }
        }
        return count;
    }

    private static int bitSwapRequired2(int a, int b) {
        int result = a ^ b;
        String resultString = Integer.toBinaryString(result);
        int count = 0;
        for (int i = 0; i < resultString.length(); i++) {
            if ((result & (1 << i)) != 0) {
                count++;
            }
        }
        return count;
    }
}
