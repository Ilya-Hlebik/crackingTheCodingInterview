package Ch_16_Moderate.Q16_17_Contiguous_Sequence.run2;

public class Solution {
    public static void main(String[] args) {
        int[] a = {2, -8, 3, -2, 4, -10};
        System.out.println(getMaxSum(a));
    }

    private static int getMaxSum(int[] a) {
        int max = 0;
        int temp = 0;
        for (int i = 0; i < a.length; i++) {
            temp = temp + a[i];
            max = Math.max(temp, max);
            if (temp < 0) {
                temp = 0;
            }
        }
        return max;
    }
}
