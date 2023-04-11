package Ch_05_Bit_Manipulation.Q5_03_Flip_Bit_to_Win;

import java.util.Stack;

public class Solution {
    public static boolean checkRange(int start, int range) {
        for (int i = 0; i < range; i++) {
            int value = start + i;
            int seqA = longestSequence(value);
            int seqB = longestSequence2(value);

            if (seqA != seqB) {
                System.out.println("FAILURE on value " + value);
                String xs = Integer.toBinaryString(value);
                System.out.println(xs);
                System.out.println("A: " + seqA);
                System.out.println("B: " + seqB);
                return false;
            }
        }
        return true;
    }

    private static int longestSequence2(int value) {
        return 0;
    }

    private static int longestSequence(int value) {
        Stack<Integer> strings = new Stack<>();
        while (value != 0){
            strings.push(value%2);
            value = value/2;
        }
        StringBuilder stringBuilder = new StringBuilder();
        while (!strings.isEmpty()){
            stringBuilder.append(Math.abs(strings.pop()));
        }
        System.out.println(stringBuilder.toString());
        return 0;
    }

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
}
