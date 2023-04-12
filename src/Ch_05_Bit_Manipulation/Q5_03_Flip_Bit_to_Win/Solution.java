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
    public static int SEQUENCE_LENGTH = 32;

    private static int longestSequence2(int value) {
        int maxSeq = 0;

        for (int i = 0; i < SEQUENCE_LENGTH; i++) {
            maxSeq = Math.max(maxSeq,  longestSequenceOf1s(value, i));
        }

        return maxSeq;
    }
    public static boolean getBit(int num, int i) {
        return ((num & (1 << i)) != 0);
    }
    public static int longestSequenceOf1s(int n, int indexToIgnore) {
        int max = 0;
        int counter = 0;
        for (int i = 0; i < SEQUENCE_LENGTH; i++) {
            if (i == indexToIgnore || getBit(n, i)) {
                counter++;
                max = Math.max(counter, max);
            } else {
                counter = 0;
            }
        }
        return max;
    }
    private static int longestSequence(int value) {
        Stack<Integer> strings = new Stack<>();
        while (value != 0) {
            strings.push(value % 2);
            value = value / 2;
        }
        StringBuilder stringBuilder = new StringBuilder();
        while (!strings.isEmpty()) {
            stringBuilder.append(Math.abs(strings.pop()));
        }
        int longestSequence = 0;
        String[] split = stringBuilder.toString().split("0");
        int coefficient = stringBuilder.toString().contains("0") ? 1 : 0;
        for (int i = 0; i < split.length; i++) {
            if (split[i].equals("")) {
                continue;
            }
            int currentLongestSequence = 0;
            if (i + 1 < split.length && !split[i + 1].equals("")) {
                currentLongestSequence = split[i].length() + split[i + 1].length() + coefficient;
            } else {
                currentLongestSequence = split[i].length() + coefficient;
            }
            longestSequence = Math.max(currentLongestSequence, longestSequence);
        }
        return longestSequence;
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
