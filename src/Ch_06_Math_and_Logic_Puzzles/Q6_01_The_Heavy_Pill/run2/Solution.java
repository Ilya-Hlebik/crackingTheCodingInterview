package Ch_06_Math_and_Logic_Puzzles.Q6_01_The_Heavy_Pill.run2;

public class Solution {
    public static void main(String[] args) {
        System.out.println(getBottleNumber(211.3));
    }

    public static int getBottleNumber(double sum) {
        for (int i = 1; i <= 20; i++) {
            double currentSum = 1.1 * i;
            for (int j = 1; j <= 20; j++) {
                if (i != j) {
                    currentSum += j;
                }
            }
            if (currentSum == sum) {
                return i;
            }
        }
        return -1;
    }
}
