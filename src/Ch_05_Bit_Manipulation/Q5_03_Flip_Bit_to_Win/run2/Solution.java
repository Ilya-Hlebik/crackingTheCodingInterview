package Ch_05_Bit_Manipulation.Q5_03_Flip_Bit_to_Win.run2;

public class Solution {
    public static void main(String[] args) {
        int[][] ranges = {{Integer.MIN_VALUE, 1000}, {Integer.MAX_VALUE - 2333, 5333},
                {-10000, 20000}};
        for (int[] range : ranges) {
            if (!checkRange(range[0], range[1])) {
                System.out.println("ERROR");
            } else {
                int end = range[0] + range[1];
                System.out.println("SUCCESS: " + range[0] + " -> " + end);
            }
        }
    }

    public static boolean checkRange(int start, int range) {
        for (int i = 0; i < range; i++) {
            int value = start + i;
            int seqA = flipBit(value);
            System.out.println(value + " : " + seqA);
   /*         if (seqA != seqB) {
                System.out.println("FAILURE on value " + value);
                String xs = Integer.toBinaryString(value);
                System.out.println(xs);
                System.out.println("A: " + seqA);
                System.out.println("B: " + seqB);
                return false;
            }*/
        }
        return true;
    }

    private static int flipBit(int a) {
        if (~a == 0) {
            return Integer.BYTES * 8;
        }
        int currentLength = 0;
        int previousLength = 0;
        int maxLength = 0;
        while (a != 0) {
            if ((a & 1) == 1) {
                currentLength++;
            } else {
                previousLength = (a & 2) == 0 ? 0 : currentLength;
                currentLength = 0;
            }
            maxLength = Math.max(previousLength + currentLength + 1, maxLength);
            a >>>= 1;
        }
        return maxLength;
    }

}
