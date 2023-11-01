package Ch_05_Bit_Manipulation.Q5_01_Insertion.run2;

import CtCILibrary.AssortedMethods;

import static Ch_05_Bit_Manipulation.Q5_01_Insertion.Solution.updateBits2;

public class Solution {

    public static void main(String[] args) {
        int a = 23427834;
        System.out.println(AssortedMethods.toFullBinaryString(a));
        int b = 17;
        System.out.println(AssortedMethods.toFullBinaryString(b));
        int c = updateBits(a, b, 1, 5);
        int d = updateBits2(a, b, 1, 3);
        System.out.println(AssortedMethods.toFullBinaryString(c));
        System.out.println(AssortedMethods.toFullBinaryString(d));
        System.out.println(AssortedMethods.toFullBinaryString(c).equals(AssortedMethods.toFullBinaryString(d)));
    }

    private static int updateBits(int n, int m, int i, int j) {
        return ~(j - i + 1 << i) & n | (m << i);
    }

}
