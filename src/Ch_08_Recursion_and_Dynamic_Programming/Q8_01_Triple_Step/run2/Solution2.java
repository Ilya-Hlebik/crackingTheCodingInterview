package Ch_08_Recursion_and_Dynamic_Programming.Q8_01_Triple_Step.run2;


public class Solution2 {
    public static void main(String[] args) {

        for (int i = 1; i < 30; i++) {
            int c1 = countWays(i, new int[i + 1]);
            System.out.println(i + ": " + c1);
        }
    }

    private static int countWays(int numberOfStairs, int[] memo) {
        if (numberOfStairs < 0) {
            return 0;
        }
        if (numberOfStairs == 0) {
            return 1;
        }
        if (memo[numberOfStairs] == 0) {
            memo[numberOfStairs] = countWays(numberOfStairs - 1, memo) + countWays(numberOfStairs - 2, memo) + countWays(numberOfStairs - 3, memo);
        }
        return memo[numberOfStairs];
    }
}
