package Ch_05_Bit_Manipulation.Q5_07_Pairwise_Swap;

import CtCILibrary.AssortedMethods;

public class Solution {
    public static void main(String[] args) {
        int a = 234321;
        System.out.println(a + ": " + AssortedMethods.toFullBinaryString(a));
        int b = swapOddEvenBits2(a);
        System.out.println(b + ": " + AssortedMethods.toFullBinaryString(b));
    }

    private static int swapOddEvenBits(int a) {
        return (a & 0xaaaaaaaa) >>> 1 | (a & 0x55555555) << 1;
    }

    private static int swapOddEvenBits2(int a) {
        StringBuilder stringBuilder = new StringBuilder(Integer.toBinaryString(a));
        for (int i = 0; i < stringBuilder.length() - 1; i += 2) {
            char temp = stringBuilder.charAt(i);
            stringBuilder.setCharAt(i, stringBuilder.charAt(i + 1));
            stringBuilder.setCharAt(i + 1, temp);
        }
        return Integer.parseInt(stringBuilder.toString(), 2);
    }
}
