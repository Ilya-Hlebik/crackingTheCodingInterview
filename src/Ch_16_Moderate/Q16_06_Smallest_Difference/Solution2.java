package Ch_16_Moderate.Q16_06_Smallest_Difference;

public class Solution2 {
    public static void main(String[] args) {
        int[] array1 = {1, 3, 15, 11, 2};
        int[] array2 = {23, 127, 234, 19, 8};
        int difference = findSmallestDifference(array1, array2);
        System.out.println(difference);
    }

    private static int findSmallestDifference(int[] arrayA, int[] arrayB) {
        if (arrayA.length == 0 || arrayB.length == 0) return -1;

        int minDiff = Integer.MAX_VALUE;
        for (int aValue : arrayA) {
            for (int bValue : arrayB) {
                minDiff = Math.min(minDiff, Math.abs(aValue - bValue));
            }
        }
        return minDiff;
    }
}
