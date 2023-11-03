package Ch_05_Bit_Manipulation.Q5_07_Pairwise_Swap.run2;

import CtCILibrary.AssortedMethods;

public class Solution {
    public static void main(String[] args) {
        int a = 234321;
        System.out.println(a + ": " + AssortedMethods.toFullBinaryString(a));
        int b = swapOddEvenBits(a);
        System.out.println(b + ": " + AssortedMethods.toFullBinaryString(b));
    }

    private static int swapOddEvenBits(int a) {
        String string = Integer.toBinaryString(a);
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < string.length()-1; i+=2) {
            result.append(string.charAt(i+1)).append(string.charAt(i));
        }
        return Integer.parseInt(result.toString(), 2);
    }
}
