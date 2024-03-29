package Ch_05_Bit_Manipulation.Q5_01_Insertion;

import CtCILibrary.AssortedMethods;

public class Solution {

    public static void main(String[] args) {
        int a = ~23423;
        System.out.println(AssortedMethods.toFullBinaryString(a));
        int b = 5;
        System.out.println(AssortedMethods.toFullBinaryString(b));
        int c = updateBits(a, b, 1, 3);
        int d = updateBits2(a, b, 1, 3);
        System.out.println(AssortedMethods.toFullBinaryString(c));
        System.out.println(AssortedMethods.toFullBinaryString(d));
        System.out.println(AssortedMethods.toFullBinaryString(c).equals(AssortedMethods.toFullBinaryString(d)));
    }

    private static int updateBits(int n, int m, int i, int j) {
        return i > j || i < 0 || j >= 32 ? 0 : (((1 << i) - 1) | (~0 << j + 1)) & n | (m << i);
    }

    public static int updateBits2(int n, int m, int i, int j) {
        // Validation
        if (i > j || i < 0 || j >= 32) {
            return 0;
        }

		/* Create a mask to clear bits i through j in n
		/* EXAMPLE: i = 2, j = 4. Result should be 11100011.
		 * (Using 8 bits for this example.  This is obviously not actually 8 bits.)
		 */
        int allOnes = ~0; // allOnes = 11111111

        int left = j < 31 ? (allOnes << (j + 1)) : 0; // 1s until position j, then 0s. left = 11100000
        int right = ((1 << i) - 1); // 1s after position i.  right = 00000011
        int mask = left | right; // All 1s, except for 0s between i and j. mask = 11100011

        /* Clear i through j, then put m in there */
        int n_cleared = n & mask; // Clear bits j through i.
        int m_shifted = m << i; // Move m into correct position.

        /* OR them, and we're done! */
        return n_cleared | m_shifted;
    }
}
