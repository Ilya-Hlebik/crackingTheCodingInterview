package Ch_16_Moderate.Q16_17_Contiguous_Sequence;

public class Solution {
    public static void main(String[] args) {
        int[] a = {2, -8, 3, -2, 4, -10};
        System.out.println(getMaxSum(a));
    }

    public static int getMaxSum(int[] a) {
        int maxSum = 0;
        int currentMaxSum = 0;
        for (int i = 0; i < a.length; i++) {
            maxSum = Math.max(maxSum, currentMaxSum += a[i]);
            if (currentMaxSum < 0) {
                currentMaxSum = 0;
            }
        }
        return maxSum;
    }
}
