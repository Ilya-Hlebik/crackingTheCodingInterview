package Ch_08_Recursion_and_Dynamic_Programming.Q8_01_Triple_Step;

public class Solution {
    public static void main(String[] args) {
        for (int i = 0; i < 30; i++) {
            int c1 =  countWays(i, new int[i+1]);
            int c2 = Solution2.countWays(i);
            System.out.println(i + ": " + c1 + " " + c2);
        }
    }
    private static int countWays(int n, int[] memo) {
        if (n < 0) {
            return 0;
        }
        else if (n == 0) {
            return 1;
        }
        if (memo[n] == 0){
            memo[n] = countWays(n - 1, memo) + countWays(n - 2, memo) + countWays(n - 3, memo);
        }
        return memo[n];
    }
}
