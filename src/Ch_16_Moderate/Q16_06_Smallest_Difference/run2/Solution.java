package Ch_16_Moderate.Q16_06_Smallest_Difference.run2;

public class Solution {
    public static void main(String[] args) {
        int[] array1 = {1, 3, 15, 11, 2};
        int[] array2 = {23, 127, 234, 19, 8};
        int difference = findSmallestDifference(array1, array2);
        System.out.println(difference);
    }

    private static int findSmallestDifference(int[] array1, int[] array2) {
        int minDiff = Integer.MAX_VALUE;
        for (int i : array1) {
            for (int j : array2) {
                minDiff = Math.min(Math.abs(i - j), minDiff);
            }
        }
        return minDiff;
    }
}
